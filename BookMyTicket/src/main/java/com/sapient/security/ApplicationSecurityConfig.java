package com.sapient.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

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
		http 
		//.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
		.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers(HttpMethod.DELETE,"/partners/**") 
		.hasAuthority(UserPermission.PARTNER_WRITE.getPermission())
		.antMatchers(HttpMethod.POST, "/partners/**") 
		.hasAuthority(UserPermission.PARTNER_WRITE.getPermission())
		.antMatchers(HttpMethod.GET, "/partners/**") 
		.hasAuthority(UserPermission.PARTNER_READ.getPermission())
		.antMatchers(HttpMethod.GET,"/search/**") 
		.hasAnyRole(UserRoles.ADMIN.name(),UserRoles.PUBLIC.name())
		.anyRequest()
		.authenticated()
		.and()
		//.httpBasic();
		.formLogin();
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
//		UserDetails admin = User.builder() 
//				.username("rupak") 
//				.password(passwordEncoder.encode("abcd")) 
//				.roles(UserRoles.ADMIN.name()).build();
//		UserDetails user = User.builder() 
//				.username("aryan")
//				.password(passwordEncoder.encode("pwd")) 
//				.roles(UserRoles.PUBLIC.name()).build();
		
		UserDetails admin = User.builder() 
				.username("rupak") 
				.password(passwordEncoder.encode("abcd"))
				.authorities(UserRoles.ADMIN.getGrantedAuthrities()) 
				.build();
		UserDetails user = User.builder() 
				.username("aryan")
				.password(passwordEncoder.encode("pwd"))
				.authorities(UserRoles.PUBLIC.getGrantedAuthrities()) 
				.build();
		return new InMemoryUserDetailsManager(admin,user);
	}

}
