package com.sample.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("comments")
public class Comments {
	private String comment;
	private String date;
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Comments(String comment, String date) {
		super();
		this.comment = comment;
		this.date = date;
	}
	public Comments() {
		super();
	}
	
	
}
