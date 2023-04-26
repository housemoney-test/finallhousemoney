package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TopController {
	
	@GetMapping
	public String home(Model model) {
		return "top/top";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "top/login";
	}
	
	@GetMapping("/signUp")
	public String signUp(Model model) {
		return "top/signUp";
	}

}
