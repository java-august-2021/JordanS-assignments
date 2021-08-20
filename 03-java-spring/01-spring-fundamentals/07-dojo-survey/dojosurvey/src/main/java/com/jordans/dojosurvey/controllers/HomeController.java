package com.jordans.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
}
	@RequestMapping(path="/survey", method=RequestMethod.POST)
	public String generateResults(
			@RequestParam(value="name") String name,
			@RequestParam(value="location") String location,
			@RequestParam(value="favoriteLanguage") String favoriteLanguage,
			@RequestParam(value="comments") String comments,
			HttpSession session
			) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("favoriteLanguage", favoriteLanguage);
		session.setAttribute("comments", comments);
		
		if(session.getAttribute("favoriteLanguage").equals("Java")) {
			return "redirect:/success";
		} else {
			return "redirect:/results";
		}
	}
	
	@RequestMapping("/success")
	public String success() {
		return "success.jsp";
	}
	
	@RequestMapping("/results")
	public String results() {
		return "results.jsp";
	}

}
