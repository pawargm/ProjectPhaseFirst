package com.project.tutorial.model;
import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;



@Document
public class Tutorial {

	@Id
	private String id;
	private String techName;
	@Indexed(name="tuturli",unique=true)
	private String tutUrl;
	private String userName;
	private int rating;
	private LinkedList<String> tags = null;
	
	public String getTechName() {
		return techName;
	}
	
	public void setTechName(String techName) {
		this.techName = techName;
	}
	
	public String getTutUrl() {
		return tutUrl;
	}
	
	public void setTutUrl(String tutUrl) {
		this.tutUrl = tutUrl;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		 this.userName = userName;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public LinkedList<String> getTags(){
		return this.tags;
	}
	
	public void setTags(LinkedList<String> tags) {
		this.tags = tags;
	}
}
