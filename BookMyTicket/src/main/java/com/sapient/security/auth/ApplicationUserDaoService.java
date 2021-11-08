package com.sapient.security.auth;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.sapient.security.UserRoles;

@Repository("fakeDao")
public class ApplicationUserDaoService implements ApplicationUserDao {
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationUserDaoService(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUserDetails> findUserByName(String userName) {
		return fetchUsers() 
				.stream() 
				.filter(u -> userName.equals(u.getUsername())) 
				.findFirst();
	}

	public List<ApplicationUserDetails> fetchUsers() {
		List<ApplicationUserDetails> users = Arrays.asList(
				new ApplicationUserDetails(
						"rupak", 
						this.passwordEncoder.encode("password"),
						UserRoles.ADMIN.getGrantedAuthrities(), 
						true, true, true, true),
				new ApplicationUserDetails(
						"aryan", this.passwordEncoder.encode("password"),
						UserRoles.PUBLIC.getGrantedAuthrities(), 
						true, true, true, true));
		return users;
	}

}
