package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
public class RecipeSharingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingApplication.class, args);
	}

}
