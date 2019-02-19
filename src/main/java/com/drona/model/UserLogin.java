package com.drona.model;

import lombok.Data;

@Data
public class UserLogin {
	
	String username;
	
	String password;

	@Override
	public String toString() {
		return "UserLogin [username=" + username + ", password=" + password + "]";
	}
	
	
}
