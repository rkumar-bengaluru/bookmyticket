package com.sapient.security.auth;

import java.util.Optional;

public interface ApplicationUserDao {
	Optional<ApplicationUserDetails> findUserByName(String userName);
}
