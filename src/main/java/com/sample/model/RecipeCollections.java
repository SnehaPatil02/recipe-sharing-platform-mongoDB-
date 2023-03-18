package com.sample.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("recipeCollections")
public class RecipeCollections {
	
	private String userId;
	private String recipeId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}
	
	
	
}
