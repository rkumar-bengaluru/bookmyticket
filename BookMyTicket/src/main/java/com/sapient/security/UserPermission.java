package com.sapient.security;

public enum UserPermission {
	PARTNER_WRITE("partner:write"), PARTNER_READ("partner:read"), 
	SEARCH_ALL("public:read");
			

	private final String permission;

	UserPermission(String string) {
		this.permission = string;
	}

	public String getPermission() {
		return permission;
	}

}
