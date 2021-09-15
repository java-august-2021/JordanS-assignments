package com.jordans.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jordans.authentication.models.User;
import com.jordans.authentication.services.UserService;

@Controller
public class Users {
		private final UserService userService;
		
		public Users(UserService userService) {
			this.userService = userService;
		}
		
		@RequestMapping("/")
		public String redirHome() {
			return "redirect:/registration";
		}
		
		@RequestMapping("/registration")
	    public String registerForm(@ModelAttribute("user") User user) {
	        return "regPage.jsp";
	    }
		
	    @RequestMapping("/login")
	    public String login() {
	        return "loginPage.jsp";
	    }
	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	        // if result has errors, return the registration page (don't worry about validations just now)
	    	if(result.hasErrors()) {
	    		return "redirect:/registration";
	    	} else {
	    		// else, save the user in the database, save the user id in session, and redirect them to the /home route
	    		userService.registerUser(user);
	    		session.setAttribute("loggedUser", user.getId());
	    		return "redirect:/home";
	    	}
	    }
//	    
	    @RequestMapping(value="/login", method=RequestMethod.POST)
	    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	        // if the user is authenticated, save their user id in session
	    	if(userService.authenticateUser(email, password)) {
	    		User loggedUser = userService.findByEmail(email);
	    		session.setAttribute("loggedUser", loggedUser.getId());
	    		return "redirect:/home";
	    	} else {
	    		// else, add error messages and return the login page
	    		model.addAttribute("error", "Credentials are invalid.");
	    		return "loginPage.jsp";
	    	}
	        
	    }
//	    
	    @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	        // get user from session, save them in the model and return the home page
	    	Long sessionId = (Long) session.getAttribute("loggedUser");
	    	User thisUser = userService.findUserById(sessionId);
	    	model.addAttribute("loggedUser", thisUser);
	    	return "homePage.jsp";
	    }
	    
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        // invalidate session
	    	session.invalidate();
	        // redirect to login page
	    	return "redirect:/login";
	    }
}
