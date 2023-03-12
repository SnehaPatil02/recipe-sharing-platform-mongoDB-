package com.sample.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sample.model.Recipe;

@Service
public interface RecipeService {
	public Recipe addRecipe(Recipe recipe);
	
	public Recipe getRecipeByName(String recipeName);
	
	public List<Recipe> getAllRecipe();
	
	public String deleteById(String recipeId);
}
