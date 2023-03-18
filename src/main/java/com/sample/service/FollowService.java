package com.sample.service;

import java.util.List;

import com.sample.model.Followers;
import com.sample.model.UserFollowers;

public interface FollowService {
	public Followers saveFollower(Followers follow);
	
	public List<UserFollowers> getAllFollowers(String userId);
	public List<UserFollowers> getAllFollowing(String userId);
}
