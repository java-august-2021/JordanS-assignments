package com.jordans.dojooverflow2.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jordans.dojooverflow2.models.Question;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long>{
		List<Question> findAll();
		
}
