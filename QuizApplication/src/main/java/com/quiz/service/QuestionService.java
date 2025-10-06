package com.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.dao.QuestionDao;
import com.quiz.dao.QuizDao;
import com.quiz.entities.Question;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QuestionService {

    private final QuizDao quizDao;
    @Autowired
	QuestionDao questionDao;

    QuestionService(QuizDao quizDao) {
        this.quizDao = quizDao;
    }
    
	public ResponseEntity<List<Question>>  getAllQuestion() {   
		try {
			return new ResponseEntity<>( questionDao.findAll(),HttpStatus.OK);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);

	}
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<>( questionDao.findByCategory(category),HttpStatus.OK);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.BAD_REQUEST);

		
	}
	public Optional<Question> getById(Integer id) {
		return questionDao.findById(id);
	}
	public ResponseEntity<String> addQuestion(Question question) {
		
		questionDao.save(question);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}
	public ResponseEntity<String> updateQuestionById(Integer id, Question question) {
		  Optional<Question> existing = questionDao.findById(id);
		  try {
			  if(existing.isPresent()) {
				  Question q = existing.get();
				  q.setQuestionTitle(question.getQuestionTitle());
	                q.setOption1(question.getOption1());
	                q.setOption2(question.getOption2());
	                q.setOption3(question.getOption3());
	                q.setOption4(question.getOption4());
	                q.setRightAnswer(question.getRightAnswer());
	                q.setCategory(question.getCategory());
	                q.setDifficultylevel(question.getDifficultylevel());
				  
				  questionDao.save(q);
				  return new ResponseEntity<>("update successfully",HttpStatus.OK);
			  }else {
				  return new ResponseEntity<>("Updation Failed",HttpStatus.NOT_FOUND);
			  }
		  }catch(Exception e) {
			 e.printStackTrace();
		  }
		return new ResponseEntity<>("Updation Failed",HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> deleteQuestionById(Integer id) {
		Optional<Question> q = questionDao.findById(id);
		try {
			if(q.isPresent()) {
				questionDao.deleteById(id);
		        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("Id not Found",HttpStatus.NOT_FOUND);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Deletion Failed",HttpStatus.BAD_REQUEST);
	}
	



}
