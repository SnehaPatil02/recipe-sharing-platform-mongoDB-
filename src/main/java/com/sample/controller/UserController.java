package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.User;
import com.sample.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		if(userService.addUser(user) != null) {
			return "User created successfully";
		}else {
			return "Something went wrong";
		}
		
	}
	
	@GetMapping("/getUser/{userName}")
	public User searchByUserName(@PathVariable String userName) {
		if(userService.searchByUserName(userName) != null) {
			User user = userService.searchByUserName(userName);
			user.setPassword(null);
			return user;
		}else {
			return null;
		}
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		if(userService.getAllUsers() != null) {
			return userService.getAllUsers();
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUserById(@PathVariable String userName) {
		if(userService.deleteUserById(userName) == null) {
			return "User is deleted successfully";
		}else {
			return "Something went wrong";
		}
	}
}
