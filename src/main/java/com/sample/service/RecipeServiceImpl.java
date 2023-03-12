package com.sample.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Recipe;
import com.sample.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeRepository recipeRepository;
	
	
	@Override
	public Recipe addRecipe(Recipe recipe) {
		System.out.println(recipe.getUserId());
		
		return recipeRepository.save(recipe);
	}


	@Override
	public Recipe getRecipeByName(String recipeName) {
		
		return recipeRepository.findByRecipeName(recipeName);
	}


	@Override
	public List<Recipe> getAllRecipe() {
		
		return recipeRepository.findAll();
	}


	@Override
	public String deleteById(UUID recipeId) {
		recipeRepository.deleteById(recipeId);
		return "Recipe deleted successfully";
	}
	
	

}
