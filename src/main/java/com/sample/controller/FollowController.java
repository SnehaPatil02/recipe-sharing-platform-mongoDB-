package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Followers;
import com.sample.model.UserFollowers;
import com.sample.repository.UserRepository;
import com.sample.service.FollowService;


@RestController
@RequestMapping("/api")
public class FollowController {

	@Autowired
	FollowService followService;
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/follow")
	public String saveFollower(@RequestBody Followers follow) {
		if(followService.saveFollower(follow) != null) {
			return "Following";
		}else {
			return "This userid is not found";
		}
	}
	
	@GetMapping("/getMyFollowers/{userId}")
	public List<UserFollowers> getMyFollowers(@PathVariable String userId) {
		if(followService.getAllFollowers(userId) != null){
			return followService.getAllFollowers(userId);
		}else {
		
		return null;
	}
	}
	
	@GetMapping("/getMyFollowing/{userId}")
	public List<UserFollowers> getMyFollowing(@PathVariable String userId) {
		if(followService.getAllFollowers(userId) != null){
			return followService.getAllFollowing(userId);
		}else {
		
		return null;
	}
	}
}
