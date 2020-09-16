package com.saulomendes.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.saulomendes.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	//?0 o primeiro parâmetro que vem no método
	@Query("{ 'title': {$regex: ?0, $options: 'i' } }")
	List<Post> serachTitle(String text);
}
