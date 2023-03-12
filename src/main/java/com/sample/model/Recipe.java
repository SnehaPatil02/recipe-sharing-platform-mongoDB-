package com.sample.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("recipies")
public class Recipe {
	
	@Id
	@Indexed(unique = true)
	private String recipeId;
	
	private String recipeName;
	
	private String ingridients;
	
	private String steps;

	private String userId;
	
	

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getIngridients() {
		return ingridients;
	}

	public void setIngridients(String ingridients) {
		this.ingridients = ingridients;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public Recipe(String recipeId, String recipeName, String ingridients, String steps, String userId) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.ingridients = ingridients;
		this.steps = steps;
		this.userId = userId;
	}

	

	
	

	


	
	

}
