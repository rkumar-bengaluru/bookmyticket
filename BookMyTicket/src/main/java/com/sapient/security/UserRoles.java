package com.sapient.security;

import static com.sapient.security.UserPermission.PARTNER_WRITE;
import static com.sapient.security.UserPermission.SEARCH_ALL;
import static com.sapient.security.UserPermission.PARTNER_READ;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum UserRoles {
	PUBLIC(Sets.newHashSet(SEARCH_ALL)),
	ADMIN(Sets.newHashSet(SEARCH_ALL,PARTNER_WRITE,PARTNER_READ));
	
	public Set<SimpleGrantedAuthority> getGrantedAuthrities() {
		Set<SimpleGrantedAuthority> all = 
				this.getPermissions().stream().map(
				permission -> 
				new SimpleGrantedAuthority(
						permission.getPermission())) 
				.collect(Collectors.toSet());
		
		all.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return all;
	}

	private final Set<UserPermission> permissions;

	private UserRoles(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<UserPermission> getPermissions() {
		return permissions;
	}
	
}
