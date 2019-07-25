package com.basic.quizapp.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.basic.quizapp.entity.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Serializable>{

}
