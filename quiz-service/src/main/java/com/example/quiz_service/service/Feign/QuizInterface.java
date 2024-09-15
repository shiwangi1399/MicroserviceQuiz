package com.example.quiz_service.service.Feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.quiz_service.entity.QuestionWrapper;
import com.example.quiz_service.entity.Response;

@FeignClient("DEMO")
public interface QuizInterface {
    @GetMapping("/question/generate")
		public ResponseEntity<List<Integer>> getquestionsForQuiz(@RequestParam String categoryName, @RequestParam Integer numQuestions);
		

//question based on question id ->list of qus return
	@PostMapping("/question/getQuestions")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromId(@RequestBody List<Integer> questionIds);
	

	@PostMapping("/question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
	

}
