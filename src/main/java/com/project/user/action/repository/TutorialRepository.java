package com.project.user.action.repository;

import java.util.LinkedList;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.user.action.model.Tutorial;
import com.project.user.action.model.User;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial,String>{

	public List<Tutorial> findByTags(LinkedList<String> lst);
	public List<Tutorial> findByTags(String lst);

}
