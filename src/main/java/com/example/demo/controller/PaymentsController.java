package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.CreateSpendingForm;
import com.example.demo.service.CreateSpendingService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/payments")
public class PaymentsController {
	
	@Autowired
	private CreateSpendingService createSpendingService;	
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("form", new CreateSpendingForm());
		return "payments/create";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("form") CreateSpendingForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
	        List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
			model.addAttribute("form", form);
			return "payments/create";
		}
		createSpendingService.create(form);
		return "payments/create";
	}
}