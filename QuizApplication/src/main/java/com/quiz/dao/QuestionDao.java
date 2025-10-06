package com.quiz.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.quiz.entities.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer > {

	List<Question> findByCategory(String category);
    //native queries
	@Query(value = "Select * from question q where q.category=:category order by Random() Limit :numQ", nativeQuery = true)
	List<Question> findRandomQuestionByCategory(String category, int numQ);
	



}
