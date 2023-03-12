package com.sample.repository;


import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sample.model.Recipe;

public interface RecipeRepository extends MongoRepository<Recipe, String>{
	
	@Query("{recipeName: '?0'}")
	Recipe findByRecipeName(String recipeName);

}
