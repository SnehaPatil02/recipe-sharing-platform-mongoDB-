package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.User;
import com.sample.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User searchByUserName(String userName) {
		
		return userRepository.findUserByUserName(userName);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public String deleteUserById(String userName) {
		userRepository.deleteById(userName);
		return "User is deleted successfully";
	}

}
