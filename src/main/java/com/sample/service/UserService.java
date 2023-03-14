package com.sample.service;

import java.util.List;

import com.sample.model.User;

public interface UserService {

	public User addUser(User user);
	
	public User searchByUserName(String userName);
	
	public List<User> getAllUsers();
	
	public String deleteUserById(String userName);
}
