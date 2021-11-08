package com.sapient.security.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	private static final Log logger = LogFactory.getLog(ApplicationUserDetailsService.class);
	private final ApplicationUserDao userDao;
	@Autowired
	public ApplicationUserDetailsService(ApplicationUserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(@Qualifier("fakeDao") String username) 
			throws UsernameNotFoundException {
		logger.info("username->" + username);
		return this.userDao.findUserByName(username) 
				.orElseThrow(
						() -> new UsernameNotFoundException(
							String.format("User not found %s", username)
						)
				);
	}
	
	
}
