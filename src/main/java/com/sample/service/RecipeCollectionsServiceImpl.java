package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Recipe;
import com.sample.model.RecipeCollections;
import com.sample.model.User;
import com.sample.model.UserCollectionsResponse;
import com.sample.model.UserRecipe;
import com.sample.repository.RecipeCollectionsRepository;
import com.sample.repository.RecipeRepository;
import com.sample.repository.UserRepository;

@Service
public class RecipeCollectionsServiceImpl implements RecipeCollectionsService{

	@Autowired
	RecipeCollectionsRepository recipeCollectionsRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RecipeRepository recipeRepo;
	
	@Override
	public RecipeCollections collectRecipies(RecipeCollections collections) {
		
		return recipeCollectionsRepo.save(collections);
	}

	@Override
	public List<UserCollectionsResponse> getMyCollections(String userId) {
		List<RecipeCollections> recipeCollections = recipeCollectionsRepo.findAllByUserId(userId);
		
		List<UserCollectionsResponse> userCollectionsResponse = new ArrayList<UserCollectionsResponse>();
		for(RecipeCollections rc : recipeCollections) {
			UserCollectionsResponse uc = new UserCollectionsResponse();
			User user =userRepo.findByUserId(rc.getUserId());
			Recipe recipe =recipeRepo.findByRecipeId(rc.getRecipeId()) ;
			uc.setUserName(user.getUserName());
			uc.setRecipeName(recipe.getRecipeName());
			userCollectionsResponse.add(uc);
			
		}
		return userCollectionsResponse;
	}

}
