package com.sample.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.Recipe;
import com.sample.model.UserRecipe;
import com.sample.service.RecipeService;

@RestController
@RequestMapping("/api/v1")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@PostMapping("/addRecipe")
	public UserRecipe addRecipe(@RequestBody Recipe recipe ) {
		
		
			return recipeService.addRecipe(recipe);
		
	}
	
	@GetMapping("/searchByName/{recipeName}")
	public List<Recipe> searchRecipe(@PathVariable String recipeName) {
		if(recipeService.getRecipeByName(recipeName) != null) {
			return recipeService.getRecipeByName(recipeName);
		}else {
			return null;
		}
	}
	
	@GetMapping("/getAll")
	public List<UserRecipe> getAllRecipies(){
		if(recipeService.getAllRecipe() != null) {
			return recipeService.getAllRecipe();
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/deleteRecipe/{recipeId}")
	public String deleteById(@PathVariable String recipeId) {
		if(recipeService.deleteById(recipeId) != null) {
			return "Deleted successfully";
		}else {
			return "Something went wrong";
		}
	}
}
