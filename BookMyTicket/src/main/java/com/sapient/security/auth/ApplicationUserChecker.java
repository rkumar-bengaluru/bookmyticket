package com.sapient.security.auth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;

public class ApplicationUserChecker implements UserDetailsChecker {
	private static final Log logger = LogFactory.getLog(ApplicationUserChecker.class);
	@Override
	public void check(UserDetails toCheck) {
		logger.info(toCheck.getUsername());
		logger.info(toCheck.getPassword());

	}

}
