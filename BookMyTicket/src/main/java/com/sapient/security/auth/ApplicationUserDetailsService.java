package com.sapient.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	private final ApplicationUserDao userDao;
	@Autowired
	public ApplicationUserDetailsService(ApplicationUserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(@Qualifier("fakeDao") String username) throws UsernameNotFoundException {
		return this.userDao.findUserByName(username) 
				.orElseThrow(
						() -> new UsernameNotFoundException(
							String.format("User not found %s", username)
						)
				);
	}
	
	
}
