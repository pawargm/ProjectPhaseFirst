package com.project.user.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.user.model.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
	 public User findByUserName(String userName);

	public User findByEmail(String email);
	public List<User> findByFirstName(String username);
}
