package com.sapient.security;

import static com.sapient.security.UserPermission.PARTNER_WRITE;
import static com.sapient.security.UserPermission.SEARCH_ALL;

import java.util.Set;

import com.google.common.collect.Sets;

public enum UserRoles {
	PUBLIC(Sets.newHashSet(SEARCH_ALL)),
	ADMIN(Sets.newHashSet(PARTNER_WRITE));
	
	private final Set<UserPermission> permissions;

	private UserRoles(Set<UserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<UserPermission> getPermissions() {
		return permissions;
	}
	
	
}
