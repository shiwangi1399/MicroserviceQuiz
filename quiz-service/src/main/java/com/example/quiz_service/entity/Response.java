package com.example.quiz_service.entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
	private Integer id;
	private String response;

}
