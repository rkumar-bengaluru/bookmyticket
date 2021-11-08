package com.sapient.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sapient.security.auth.ApplicationUserChecker;
import com.sapient.security.auth.ApplicationUserDetailsService;
import com.sapient.security.jwt.JwtFilter;

@Configuration
@EnableWebSecurity

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	@Autowired
	private final ApplicationUserDetailsService applicationUserDetailsService;
	
	public ApplicationSecurityConfig(PasswordEncoder e,ApplicationUserDetailsService as) {
		this.passwordEncoder = e;
		this.applicationUserDetailsService = as;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http 
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilter(new JwtFilter(authenticationManager()))		
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
		.authenticated();
		///.and()
		// form based authentication
		//.formLogin();
		// custom login page
//		.loginPage("/login")
//			.passwordParameter("password")
//			.usernameParameter("username")
//			.permitAll()
//			.defaultSuccessUrl("/home",true)
		//.and()
		// remember me enabled
//		.rememberMe()
//			.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(1))
//			.key("secretkey")
//			.rememberMeParameter("remember-me")
		//.and()
		// custom logout page
//		.logout()
//			.logoutUrl("/logout")
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.clearAuthentication(true)
//			.invalidateHttpSession(true)
//			.deleteCookies("JSESSIONID","remember-me")
//			.logoutSuccessUrl("/home");
			
	}
	
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		
//		UserDetails admin = User.builder() 
//				.username("rupak") 
//				.password(passwordEncoder.encode("password"))
//				.authorities(UserRoles.ADMIN.getGrantedAuthrities()) 
//				.build();
//		UserDetails user = User.builder() 
//				.username("aryan")
//				.password(passwordEncoder.encode("password"))
//				.authorities(UserRoles.PUBLIC.getGrantedAuthrities()) 
//				.build();
//		return new InMemoryUserDetailsManager(admin,user);
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(provider());
	}
	
	@Bean
	public DaoAuthenticationProvider provider() {
		DaoAuthenticationProvider provider = 
				new DaoAuthenticationProvider();
		provider.setPreAuthenticationChecks(new ApplicationUserChecker());
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserDetailsService);
		return provider;
	}

}
