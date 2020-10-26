package com.fsantosbr.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fsantosbr.workshopmongo.domain.Post;

// Working with Spring Data


@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	// The Spring data has (already) the MongoRepository<T, ID> interface
	// The interface expects the domain class it will manage and the type of the Id of the class	
	
	List<Post> findByTitleContainingIgnoreCase(String text);	
	/*	- Em nenhum momento precisamos implementar o corpo deste método.
		- O Spring Data fará todo o processo, pois: 1: Usamos o 'findBy' no início. 2: Já temos um campo/atributo 'title' na classe Post. 3: Usamos a keyword conforme o KB. 4: Usamos os mesmos parametros que a ferramenta pede no KB.
		- IgnoreCase é opcional, sem ele, a palavra é case sensitive.
		- Ref: https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongodb.repositories.queries
	*/

}
