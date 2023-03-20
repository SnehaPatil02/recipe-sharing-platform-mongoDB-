package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Recipe;
import com.sample.model.RecipeCollections;
import com.sample.model.RecipeRating;
import com.sample.model.User;
import com.sample.model.UserCollectionsResponse;
import com.sample.model.UserRecipe;
import com.sample.repository.RecipeCollectionsRepository;
import com.sample.repository.RecipeRatingRepository;
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
	
	@Autowired
	RecipeRatingRepository recipeRatingRepo;
	
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

	@Override
	public RecipeRating recipeRating(RecipeRating rating) {
		
		int r = rating.getRating();
		System.out.println(r);
		if(r == 1 || r == 2 || r == 3 || r == 4 || r == 5) {
			return recipeRatingRepo.save(rating);
		}else {
			return null;
		}
		
	}

	@Override
	public List<RecipeRating> getRatings(String recipeId) {
		List<RecipeRating> lr = recipeRatingRepo.findByRecipeId(recipeId);
		List<RecipeRating> rcr = new ArrayList<RecipeRating>();
		for(RecipeRating rr : lr) {
			RecipeRating rc = new RecipeRating();
			rc.setRecipeId(rr.getRecipeId());
			System.out.println(rr);
			rcr.add(rr);
//		List<RecipeRating> re = recipeRatingRepo.findByRecipeId(rr.getRecipeId());
//			if(re  != rcr) {	
//				return null;
//		}
		}
		return  rcr;	
		}
//	User user = userrepo.findByUserId(recipe.getUserId());
//	if (user!=null) {
//	userRecipe.setUserName(user.getUserName());
//	}
//	userRecipelist.add(userRecipe);
//
//}
//return userRecipelist;
	
}
