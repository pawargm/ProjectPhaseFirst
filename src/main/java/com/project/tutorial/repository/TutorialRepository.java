package com.project.tutorial.repository;

import java.util.LinkedList;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.tutorial.model.Tutorial;
import com.project.user.model.User;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial,String>{
	
	@Query("{ 'tags' : {$all : ?0} }")
	public List<Tutorial> findByTags(LinkedList<String> lst);
	public List<Tutorial> findByTags(String lst);

}
