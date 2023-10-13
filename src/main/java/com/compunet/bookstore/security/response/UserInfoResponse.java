package com.compunet.bookstore.security.response;

public class UserInfoResponse {
	private String username;

	public UserInfoResponse(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
