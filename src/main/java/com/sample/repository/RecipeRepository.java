package com.sample.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, UUID>{
	
	Recipe findByRecipeName(String recipeName);

}
