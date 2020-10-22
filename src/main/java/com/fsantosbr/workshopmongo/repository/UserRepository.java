package com.fsantosbr.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fsantosbr.workshopmongo.domain.User;

// Working with Spring Data


@Repository
public interface UserRepository extends MongoRepository<User, String>{
	// The Spring data has (already) the MongoRepository<T, ID> interface
	// The interface expects the domain class it will manage and the type of the Id of the class
	

}
