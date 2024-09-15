package com.example.quiz_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quiz_service.entity.Quiz;


@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
