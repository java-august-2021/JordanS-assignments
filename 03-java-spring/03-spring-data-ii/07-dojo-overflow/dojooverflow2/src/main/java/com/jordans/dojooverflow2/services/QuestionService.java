package com.jordans.dojooverflow2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordans.dojooverflow2.models.Answer;
import com.jordans.dojooverflow2.models.Question;
import com.jordans.dojooverflow2.repositories.QuestionRepo;

@Service
public class QuestionService {
	private final QuestionRepo questionRepo;
	
	public QuestionService(QuestionRepo questionRepo) {
		this.questionRepo = questionRepo;
	}
	
	public List<Question> allQuestions(){
		return questionRepo.findAll();
	}
	
	public Question createQuestion(Question question) {
		return questionRepo.save(question);
	}
	
	public Question findQuestion(Long id){
		Optional<Question> thisQuestion = questionRepo.findById(id);
		if(thisQuestion.isPresent()) {
			return thisQuestion.get();
		} else {
			return null;
		}
	}


}
