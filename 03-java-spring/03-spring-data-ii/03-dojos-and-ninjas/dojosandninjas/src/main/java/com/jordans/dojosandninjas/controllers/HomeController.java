package com.jordans.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jordans.dojosandninjas.models.Dojo;
import com.jordans.dojosandninjas.models.Ninja;
import com.jordans.dojosandninjas.services.DojoService;
import com.jordans.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {
	private final DojoService dService;
	private final NinjaService nService;
	
	public HomeController(DojoService dService, NinjaService nService) {
		this.dService = dService;
		this.nService = nService;
	}
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/dojos/create", method = RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			dService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
//		List<Ninja> ninjas = nService.theseStudents(id);
		Dojo thisDojo = dService.findDojo(id);
		model.addAttribute("dojo", thisDojo);
		return "dojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dService.allDojos();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	
	@RequestMapping(value = "/ninjas/create", method = RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "ninja.jsp";
		} else {
		nService.createNinja(ninja);
		return "redirect:/ninjas/new";
		}
	}
}
