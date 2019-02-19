package com.drona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.drona.model.AuthResponse;
import com.drona.model.UserLogin;
import com.drona.service.AuthenticationService;

@RestController
public class LoginController {
	
	@Autowired
	AuthenticationService auth;
	
	
	@CrossOrigin
	@RequestMapping(value="/login" , method = RequestMethod.POST, produces = "application/json")
	public AuthResponse authenticate(@RequestBody UserLogin user) {
		AuthResponse response = auth.authenticate(user);
		return response;
	}
	
	//@CrossOrigin
	//public UserDetails fetchUserData()

}
