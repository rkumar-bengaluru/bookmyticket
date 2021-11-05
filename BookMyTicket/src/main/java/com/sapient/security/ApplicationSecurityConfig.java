package com.sapient.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	public ApplicationSecurityConfig(PasswordEncoder e) {
		this.passwordEncoder = e;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/index")
		.permitAll() 
		.antMatchers("/search/**") 
		.hasAnyRole(UserRoles.ADMIN.name(),UserRoles.PUBLIC.name()) 
		.antMatchers("/partners/**")
		.hasRole(UserRoles.ADMIN.name())
		.anyRequest().authenticated()
		.and().httpBasic();
	}
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails admin = User.builder().username("rupak") 
				.password(passwordEncoder.encode("abcd")).roles(UserRoles.ADMIN.name()).build();
		UserDetails user = User.builder().username("aryan")
		.password(passwordEncoder.encode("pwd")).roles(UserRoles.PUBLIC.name()).build();
		return new InMemoryUserDetailsManager(admin,user);
	}

}
