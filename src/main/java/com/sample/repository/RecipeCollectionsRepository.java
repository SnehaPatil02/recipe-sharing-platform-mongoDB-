package com.sample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.model.RecipeCollections;

public interface RecipeCollectionsRepository extends MongoRepository<RecipeCollections, String>{
	
	public List<RecipeCollections> findAllByUserId(String userId);

}
