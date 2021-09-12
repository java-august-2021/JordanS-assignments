package com.jordans.dojooverflow2.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jordans.dojooverflow2.models.Answer;
import com.jordans.dojooverflow2.models.Question;
import com.jordans.dojooverflow2.services.AnswerService;
import com.jordans.dojooverflow2.services.QuestionService;
import com.jordans.dojooverflow2.services.TagService;
import com.jordans.dojooverflow2.validators.TagValidator;



@Controller
public class HomeController {
	private final AnswerService answerService;
	private final QuestionService questionService;
	private final TagService tagService;
	
	public HomeController(AnswerService answerService, QuestionService questionService, TagService tagService) {
		this.answerService = answerService;
		this.questionService = questionService;
		this.tagService = tagService;
	}
	
	@Autowired
	private TagValidator validator;
	
	@RequestMapping("/")
	public String dashboard(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}
	

	@RequestMapping("/question/new")
	public String newQuestion(@ModelAttribute("question") Question question, Model model) {
//		List<Tag> tags = tagService.allTags();
//		model.addAttribute("tags", tags);
		return "addQuestion.jsp";
	}
	
	@RequestMapping(value = "/question/create", method = RequestMethod.POST)
	public String createQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		validator.validate(question, result);
		if(result.hasErrors()) {
			return "addQuestion.jsp";
		} else {
			
			tagService.createQuestionWithTags(question);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/question/{id}")
	public String showQuestion(@PathVariable("id") Long id, @ModelAttribute("answer") Answer answer, Model model) {
		Question thisQuestion = questionService.findQuestion(id);
		model.addAttribute("question", thisQuestion);
		return "showQuestion.jsp";
	}
	
	@RequestMapping(value = "/question/{id}/answer", method = RequestMethod.POST)
		public String createAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "redirect:/question/{id}";
		}
		Answer newAnswer = answerService.createAnswer(new Answer(answer.getBody()));
		Question thisQuestion = questionService.findQuestion(id);
		answerService.addAnswer(newAnswer, thisQuestion);
		return "redirect:/question/{id}";
	}
	
}
