package com.example.quiz_service.entity;
import lombok.Data;

@Data
public class QuizDto
{
    String categoryName;
    Integer numQuestions;
    String title;
}