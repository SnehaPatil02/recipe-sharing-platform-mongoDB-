package com.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Recipe;
import com.sample.model.User;
import com.sample.model.UserRecipe;
import com.sample.repository.RecipeRepository;
import com.sample.repository.UserRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	UserRepository userrepo;
	
	
	@Override
	public UserRecipe addRecipe(Recipe recipe) {
		System.out.println(recipe.getUserId());
		
		Recipe new_recipe = recipeRepository.save(recipe);
		UserRecipe userrec = new UserRecipe();
		
		userrec.setIngridients(new_recipe.getIngridients());
		userrec.setRecipeId(new_recipe.getRecipeId());
		userrec.setSteps(new_recipe.getSteps());
		userrec.setRecipeName(new_recipe.getRecipeName());
		User user = userrepo.findByUserId(new_recipe.getUserId());
				
				userrec.setUserName(user.getUserName());
		
		return userrec;
		
		
	}


	@Override
	public List<Recipe> getRecipeByName(String recipeName) {
		
		return recipeRepository.findByRecipeName(recipeName);
	}


	@Override
	public List<UserRecipe> getAllRecipe() {
		List<Recipe> allRecipe =  recipeRepository.findAll();
		
		List<UserRecipe> userRecipelist = new ArrayList<UserRecipe>();
		
		for(Recipe recipe : allRecipe) {
			UserRecipe userRecipe = new UserRecipe();
			
			userRecipe.setIngridients(recipe.getIngridients());
			userRecipe.setRecipeId(recipe.getRecipeId());
			userRecipe.setRecipeName(recipe.getRecipeName());
			userRecipe.setSteps(recipe.getSteps());
			
			User user = userrepo.findByUserId(recipe.getUserId());
			if (user!=null) {
			userRecipe.setUserName(user.getUserName());
			}
			userRecipelist.add(userRecipe);
		
		}
		return userRecipelist;
	}


	@Override
	public String deleteById(String recipeId) {
		recipeRepository.deleteById(recipeId);
		return "Recipe deleted successfully";
	}
	
	

}
