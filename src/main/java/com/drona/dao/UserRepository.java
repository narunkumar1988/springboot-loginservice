package com.drona.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.drona.model.User;
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
	List<User> findByUsername(String username);

}
