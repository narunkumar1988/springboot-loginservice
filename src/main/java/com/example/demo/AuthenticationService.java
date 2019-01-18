package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class AuthenticationService {
	
	@Autowired
	AuthResponse response;
	@Bean
	public AuthResponse response() {
		if(response == null) {
			response = new AuthResponse();
		}
		return response;
	}
	
	public AuthResponse authenticate(UserLogin user) {
		
		log.info("User"+user);
		response.status = "failure";
		
		if(user!=null && !StringUtils.isEmpty(user.username) && !StringUtils.isEmpty(user.password)) {
			if(user.username.equals("test") && user.password.equals("test123")) {
				response.status = "Success";
			}
		}
		
		return response;
	}
}
