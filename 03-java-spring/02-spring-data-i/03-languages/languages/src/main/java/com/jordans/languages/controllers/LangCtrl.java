package com.jordans.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jordans.languages.models.Language;
import com.jordans.languages.services.LangService;

@Controller
public class LangCtrl {
	private final LangService langService;
	
	public LangCtrl(LangService langService) {
		this.langService = langService;
	}
	
	@RequestMapping("/")
	public String redirectIndex() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("lang") Language lang, Model model) {
		List <Language> languages = langService.allLangs();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("lang") Language lang, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/languages";
        } else {
            langService.addLanguage(lang);
            return "redirect:/languages";
        }
    }
	
	@RequestMapping("/languages/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLanguage(id);
		model.addAttribute("language", lang);
		return "details.jsp";
	    }
	
	@RequestMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language lang = langService.findLanguage(id);
		model.addAttribute("language", lang);
		return "edit.jsp";
	    }
	
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("lang") Language lang, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            langService.updateLang(lang);
	            return "redirect:/languages/{id}";
	        }
	    }
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String deletion(@PathVariable("id") Long id) {
        langService.destroyLang(id);
        return "redirect:/languages";
    }
	
	//test
}
