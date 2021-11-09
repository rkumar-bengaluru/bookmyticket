package com.sapient.security.jwt;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.security.Keys;

@ConfigurationProperties(prefix="application.jwt")
@Service	
public class JwtConfig {
	
	
	@Value("${application.jwt.secret}")
	private String secret;
	
	
	public String getKey() {
		return secret;
	}


	public void setKey(String key) {
		this.secret = key;
	}

	@Bean
	public SecretKey secretKey() {
		return Keys.hmacShaKeyFor(secret.getBytes());
	}
}
