package com.drona.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.drona.dao.UserRepository;
import com.drona.model.AuthResponse;
import com.drona.model.User;
import com.drona.model.UserLogin;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthenticationService {

	@Autowired
	AuthResponse response;

	@Bean
	public AuthResponse response() {
		if (response == null) {
			response = new AuthResponse();
		}
		return response;
	}

	@Autowired
	UserRepository repo;

	public AuthResponse authenticate(UserLogin user) {

		log.info("User" + user);
		response.setStatus("failure");

		if (user != null && !StringUtils.isEmpty(user.getUsername()) && !StringUtils.isEmpty(user.getPassword())) {
			//List<User> users = repo.findByUsername(user.getUsername());
			List<User> users = repo.findByUsername(user.getUsername()).stream().filter(u -> u.getPassword().equals(user.getPassword())).collect(Collectors.toList());;
			//if (user.getUsername().equals("test") && user.getPassword().equals("test123")) {
			if(users.size()>0)
				response.setStatus("Success");
			//}
		}

		return response;
	}
}
