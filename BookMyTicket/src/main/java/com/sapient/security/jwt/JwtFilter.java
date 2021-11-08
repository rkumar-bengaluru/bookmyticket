package com.sapient.security.jwt;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtFilter extends UsernamePasswordAuthenticationFilter {
	
	private final AuthenticationManager manager;
	
	public JwtFilter(AuthenticationManager manager) {
		super();
		this.manager = manager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String username = obtainUsername(request);
		username = (username != null) ? username : "";
		username = username.trim();
		String password = obtainPassword(request);
		password = (password != null) ? password : "";
		Authentication auth = new UsernamePasswordAuthenticationToken(
				username,password);
		return manager.authenticate(auth);
	}
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String key = "mysecret";
		String token = Jwts.builder()
			.setSubject(auth.getName())
			.claim("authorities", auth.getAuthorities())
			.setIssuedAt(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
			.signWith(Keys.hmacShaKeyFor(key.getBytes()))
			.compact();
		response.addHeader("Authorization", "Bearer " + 	token);
	}
	
}
