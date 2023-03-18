package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Followers;
import com.sample.model.UserFollowers;
import com.sample.repository.FollowRepository;
import com.sample.repository.UserRepository;


@Service
public class FollowServiceImpl implements FollowService{

	@Autowired
	FollowRepository followRepo;

	@Autowired
	UserRepository userRepo;
	
	@Override
	public Followers saveFollower(Followers follow) {
	
		 
		if(userRepo.findByUserId(follow.getFromUserId()) != null && 
				userRepo.findByUserId(follow.getToUserId()) != null) {
			
	
		return followRepo.save(follow);
	}else {
	return null;
	}
	}

	@Override
	public List<UserFollowers> getAllFollowers(String userId) {
				 List<Followers> allFollowers= followRepo.findAllByToUserId(userId);
				 System.out.println(allFollowers.size());
				 List<UserFollowers> userFollowers = new ArrayList<UserFollowers>();
				 for(Followers follow : allFollowers) {
					 UserFollowers uf = new UserFollowers();
					 uf.setUserId(follow.getFromUserId());
					 uf.setUserName(userRepo.findByUserId(follow.getFromUserId()).getUserName());
					 userFollowers.add(uf);
				 }
					
		return userFollowers;

	}
	
	@Override
	public List<UserFollowers> getAllFollowing(String userId) {
				 List<Followers> allFollowers= followRepo.findAllByFromUserId(userId);
			
				 List<UserFollowers> userFollowers = new ArrayList<UserFollowers>();
				 for(Followers follow : allFollowers) {
					 UserFollowers uf = new UserFollowers();
					 uf.setUserId(follow.getToUserId());
					 uf.setUserName(userRepo.findByUserId(follow.getToUserId()).getUserName());
					 userFollowers.add(uf);
				 }
					
		return userFollowers;
	}
}
