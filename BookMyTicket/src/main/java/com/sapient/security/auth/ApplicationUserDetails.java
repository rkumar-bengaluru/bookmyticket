package com.sapient.security.auth;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6406515888275685066L;
	
	private final Set<? extends GrantedAuthority> authorities;
	private final String password;
	private final String userName;
	private final boolean isAccountNonExpired;
	private final boolean isAccountNonLocked;
	private final boolean isCredentialsNonExpired;
	private final boolean isEnabled;

	public ApplicationUserDetails(
			String userName, 
			String password,
			Set<? extends GrantedAuthority> authorities, 
			boolean isAccountNonExpired, 
			boolean isAccountNonLocked, 
			boolean isCredentialsNonExpired,
			boolean isEnabled) {
		super();
		this.authorities = authorities;
		this.password = password;
		this.userName = userName;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

}
