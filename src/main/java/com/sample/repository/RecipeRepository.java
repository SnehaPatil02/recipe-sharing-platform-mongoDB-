package com.sample.repository;


import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.sample.model.Recipe;
import com.sample.model.UserRecipe;

public interface RecipeRepository extends MongoRepository<Recipe, String>{
	
	@Query(value="{ 'recipeName' : {$regex : ?0, $options: '/i/'}}")
	public List<Recipe> findByRecipeName(String recipeName);


}

//value = " {'recipeName': {$or: {$all : [?0]}}}"
//value="{'recipeName' :?#{ [0] ? {$exists :true} : [1]} }
//value="{ 'recipeName' :{$in:[?0/i]}}
//value="{ 'recipeName' :{$all:[?0/i]}}