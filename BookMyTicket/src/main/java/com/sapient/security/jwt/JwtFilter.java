package com.sapient.security.jwt;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager manager;
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JwtFilter.class);

	public JwtFilter(AuthenticationManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			logger.trace("trace log");
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
			logger.info(String.format("username %s password %s", user.getUsername(), user.getPassword()));
			Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
			logger.info("credentials:" + auth);
			Authentication authentication = manager.authenticate(auth);
			logger.info("-----------------:");
			return authentication;
		} catch (IOException e) {
			logger.info(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String key = "mysecretmysecretmysecretmysecretmysecretmysecretmysecretmysecret";
		String token = Jwts.builder().setSubject(auth.getName()).claim("authorities", auth.getAuthorities())
				.setIssuedAt(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
				.signWith(Keys.hmacShaKeyFor(key.getBytes())).compact();
		response.addHeader("Authorization", "Bearer " + token);
	}

}
