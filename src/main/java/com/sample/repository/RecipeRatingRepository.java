 package com.sample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.model.RecipeRating;

public interface RecipeRatingRepository extends MongoRepository<RecipeRating, String>{
	
	public List<RecipeRating> findByRecipeId(String recipeId);

}
