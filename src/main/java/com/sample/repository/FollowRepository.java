package com.sample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.model.Followers;

public interface FollowRepository extends MongoRepository<Followers, String>{
	public List<Followers> findAllByToUserId(String userId);
	public List<Followers> findAllByFromUserId(String userId);
}
