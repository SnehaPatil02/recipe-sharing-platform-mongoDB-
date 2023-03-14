package com.sample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User {
	
	@Id
	@Indexed(unique = true)
	private String userId;
	
	private String userName;
	
	private String email;
	
	private String password;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String userId, String userName, String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	

}
