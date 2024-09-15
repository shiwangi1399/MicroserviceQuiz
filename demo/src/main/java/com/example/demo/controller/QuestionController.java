package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.entity.QuestionWrapper;
import com.example.demo.entity.Response;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	@GetMapping("/allquestion")
	public ResponseEntity<List<Question>> getallquestions() {
		
		return questionService.getallquestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> questionByCategory(@PathVariable String category)
	{
		return questionService.getquestionByCategory(category);
		
	
	}
	//@RequestBody->json into java
	@PostMapping("/add/")
	public String addquestion(@RequestBody Question question)
	{
		questionService.addquestion(question);
		return "Question Saved";
		
	}
	@DeleteMapping("/delete/{id}")
	public String deletequestion(@PathVariable int id)
	{
		questionService.deletequestion(id);
		return "Delete question";
		
	}
   //returning id of questions
	@GetMapping("/generate")
		public ResponseEntity<List<Integer>> getquestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions)
		{
			return questionService.getquestionForQuiz(categoryName,numQuestions);
		}

//question based on question id ->list of qus return
	@PostMapping("getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds) {
		return questionService.getquestionsFromId(questionIds);
		
	}

	@PostMapping("getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) 
	{
	   	return questionService.getScore(responses);
	}
	
	
	
}

