package com.sample.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("followers")
public class Followers {
	@Id
	@Indexed(unique = true)
	private String id;
	
	private String fromUserId;
	
	private String toUserId;
	
	public Followers() {
		super();
	}

	public Followers(String id, String fromUserId, String toUserId) {
		super();
		this.id = id;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	
	
	

}
