package com.jordans.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayController {
	
	@RequestMapping("/")
	private String index() {
		System.out.println("test");
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	private String displayDate(Model dateModel) {
		String pattern = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		dateModel.addAttribute("date", date);
		return "displayDate.jsp";
	}
	
	@RequestMapping("/time")
	private String displayTime(Model timeModel) {
		String pattern = "H:m a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		timeModel.addAttribute("time", time);
		return "displayTime.jsp";
	}

}
