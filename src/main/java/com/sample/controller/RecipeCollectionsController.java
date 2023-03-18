package com.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.model.RecipeCollections;
import com.sample.model.UserCollectionsResponse;
import com.sample.service.RecipeCollectionsService;

@RestController
@RequestMapping("/api")
public class RecipeCollectionsController {
	
	@Autowired
	RecipeCollectionsService recipeCollectionsService;

	@PostMapping("/recipeCollections")
	public String Collections(@RequestBody RecipeCollections collect) {
		if(recipeCollectionsService.collectRecipies(collect) != null) {
			return "This recipe is saved successfully";
		}else {
			return "Something went wrong";
		}
		
	}
	
	@GetMapping("/getMyCollections/{userId}")
	public List<UserCollectionsResponse> getMyCollections(@PathVariable String userId) {
		if(recipeCollectionsService.getMyCollections(userId) != null) {
		
			return recipeCollectionsService.getMyCollections(userId);
		}else {
		return null;
	}
	}
}
