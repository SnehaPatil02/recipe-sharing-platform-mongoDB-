package com.sample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.model.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	public User findUserByUserName(String userName);
	
	public User findByUserId(String userId);

}
