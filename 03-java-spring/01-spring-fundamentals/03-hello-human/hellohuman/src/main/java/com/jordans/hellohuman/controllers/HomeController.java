package com.jordans.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@RequestMapping("/")
	private String index(@RequestParam(value="name", required=false, defaultValue="Human") String nameInput, Model model) { 
		model.addAttribute("name", nameInput);
		return "greeting.jsp";
	}

}

