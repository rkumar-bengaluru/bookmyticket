package com.sapient.security.jwt;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Strings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtTokenFilter extends OncePerRequestFilter {
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(JwtTokenFilter.class);
	private JwtConfig config;
	public JwtTokenFilter(JwtConfig config) {
		super();
		this.config = config;
	}

	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
			throws ServletException, IOException {
		logger.info("doFilterInternal");
		String authHeader = request.getHeader("Authorization");
		if (Strings.isNullOrEmpty(authHeader) || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		String token = authHeader.replace("Bearer ", "");
		try {
			Jws<Claims> claims = Jwts.parserBuilder()
				.setSigningKey(config.secretKey())
				.build()
				.parseClaimsJws(token);
			Claims body = claims.getBody();
			String username = body.getSubject();
			var auths = (List<Map<String,String>>)body.get("authorities");
			Set<SimpleGrantedAuthority> authorities = auths.stream()
				.map(map -> 
					new SimpleGrantedAuthority(map.get("authority"))
				).collect(Collectors.toSet());
			SecurityContextHolder 
				.getContext() 
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(username,null, authorities)
				);
		} catch (JwtException e) {
			throw new RuntimeException(e);
		}
		
		filterChain.doFilter(request, response);
		return;

	}

}
