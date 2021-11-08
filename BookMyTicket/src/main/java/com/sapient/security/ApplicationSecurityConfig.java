package com.sapient.security;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sapient.security.auth.ApplicationUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final ApplicationUserDetailsService userDetails;
	
	public ApplicationSecurityConfig(PasswordEncoder e,
			ApplicationUserDetailsService userDetails) {
		this.passwordEncoder = e;
		this.userDetails = userDetails;
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
		// form based authentication
		.formLogin()
		// custom login page
		.loginPage("/login")
			.passwordParameter("password")
			.usernameParameter("username")
			.permitAll()
			.defaultSuccessUrl("/home",true)
		.and()
		// remember me enabled
		.rememberMe()
			.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(1))
			.key("secretkey")
			.rememberMeParameter("remember-me")
		.and()
		// custom logout page
		.logout()
			.logoutUrl("/logout")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.clearAuthentication(true)
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID","remember-me")
			.logoutSuccessUrl("/home");
			
	}
	
	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider());
	}
	
	@Bean
	private DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = 
				new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetails);
		return provider;
	}

}
