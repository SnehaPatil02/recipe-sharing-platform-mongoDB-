package com.sample.service;

import java.util.List;

import com.sample.model.RecipeCollections;
import com.sample.model.RecipeRating;
import com.sample.model.UserCollectionsResponse;

public interface RecipeCollectionsService{
	
	public RecipeCollections collectRecipies(RecipeCollections collections);
	
	public List<UserCollectionsResponse> getMyCollections(String userId);
	
	public RecipeRating recipeRating(RecipeRating rating);
	
	public List<RecipeRating> getRatings(String recipeId);
}
