package com.sample.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sample.model.Recipe;
import com.sample.model.UserRecipe;

@Service
public interface RecipeService {
	public UserRecipe addRecipe(Recipe recipe);
	
	public List<Recipe> getRecipeByName(String recipeName);
	
	public List<UserRecipe> getAllRecipe();
	
	public String deleteById(String recipeId);
}
