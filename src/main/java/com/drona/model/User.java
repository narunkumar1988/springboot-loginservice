package com.drona.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection="User")
public class User {
	
	@Id String id;
	
	@Field(value="username")
	String username;
	
	@Field(value="password")
	String password;


	
}
