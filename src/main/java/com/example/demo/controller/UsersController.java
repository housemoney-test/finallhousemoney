package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.service.GetAllUsersService;


@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private GetAllUsersService getAllUsersService;

	@GetMapping("/index")
	public String index(Model model) {
		List<User> users = getAllUsersService.getAllUsers();
		model.addAttribute("users", users);
		return "users/index";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("users", new User());
		return "users/home";
	}
	
	
	
}
