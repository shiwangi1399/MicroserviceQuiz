package com.example.quiz_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.quiz_service.dao.QuizDao;
import com.example.quiz_service.entity.QuestionWrapper;
import com.example.quiz_service.entity.Quiz;
import com.example.quiz_service.entity.Response;
import com.example.quiz_service.service.Feign.QuizInterface;


@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;
	@Autowired
	QuizInterface quizInterface;
	
	

	public ResponseEntity<String> createquiz(String category, int numQ, String title) {
		List<Integer> questions = quizInterface.getquestionsForQuiz(category, numQ).getBody();
		Quiz quiz =new Quiz();
		quiz .setTitle(title); 
		quiz.setQuestionsId(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}



	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		Quiz quiz= quizDao.findById(id).get();
		List<Integer> questionId =quiz.getQuestionsId();
		ResponseEntity<List<QuestionWrapper>> QuizQuestion =quizInterface.getQuestionFromId(questionId);
		
		
		return QuizQuestion;
	}


//number of right response
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score=	quizInterface.getScore(responses);
		return score;
	}



	
	
	

}
