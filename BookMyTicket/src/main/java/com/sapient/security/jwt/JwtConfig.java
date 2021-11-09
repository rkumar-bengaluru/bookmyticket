package com.sapient.security.jwt;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.security.Keys;
@Configuration	
@ConfigurationProperties(prefix="application.jwt")
public class JwtConfig {
	
	private String secret;
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Bean
	public SecretKey secretKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
}
