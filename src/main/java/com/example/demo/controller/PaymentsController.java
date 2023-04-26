package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/payments")
public class PaymentsController {
	
	
	@GetMapping("/create")
	public String create(Model model) {
//		model.addAttribute("form", new CreateSpendingForm());
		return "payments/create";
	}
	
//	@PostMapping("/create")
//	public String create(@Valid @ModelAttribute("form") CreateSpendingForm form, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//	        List<String> errorList = new ArrayList<String>();
//            for (ObjectError error : result.getAllErrors()) {
//                errorList.add(error.getDefaultMessage());
//            }
//            model.addAttribute("validationError", errorList);
//			model.addAttribute("form", form);
//			createSpendingService.create(form);
//			return "payments/create";
//		}
//		return "payments/create";
//	}
}