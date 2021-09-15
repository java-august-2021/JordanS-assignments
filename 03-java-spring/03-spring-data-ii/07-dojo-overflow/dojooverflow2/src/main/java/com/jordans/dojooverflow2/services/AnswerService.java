package com.jordans.dojooverflow2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jordans.dojooverflow2.models.Answer;
import com.jordans.dojooverflow2.models.Question;
import com.jordans.dojooverflow2.repositories.AnswerRepo;

@Service
public class AnswerService {
	private final AnswerRepo answerRepo;
	
	public AnswerService(AnswerRepo answerRepo) {
		this.answerRepo = answerRepo;
	}
	
	public List<Answer> allAnswers(){
		return answerRepo.findAll();
	}
	
	public Answer createAnswer(Answer answer) {
		return answerRepo.save(answer);
	}
	
	public Answer findAnswer(Long id){
		Optional<Answer> thisAnswer = answerRepo.findById(id);
		if(thisAnswer.isPresent()) {
			return thisAnswer.get();
		} else {
			return null;
		}
	}
	
	public Answer addAnswer(Answer answer, Question question) {
		answer.setQuestion(question);
		return answerRepo.save(answer);
		}

}