package com.quiz.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Question;
import com.quiz.service.QuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
    @GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return  questionService.getAllQuestion();
	}
    
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCatogery(@PathVariable String category){
    	return questionService.getQuestionByCategory(category);
    }
    
    @GetMapping("/{id}")
    public Optional<Question> getById(@PathVariable Integer id) {
    	return questionService.getById(id);
    }
    
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
    	return questionService.addQuestion(question);
    }
    @PutMapping("update/{id}")
    	public ResponseEntity<String> updateQuestionById(@PathVariable Integer id, @RequestBody Question question){
    		return questionService.updateQuestionById(id,question);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id){
    	return questionService.deleteQuestionById(id);
    }
    
}
