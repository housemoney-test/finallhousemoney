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
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Spending;
import com.example.demo.form.CreateSpendingForm;
import com.example.demo.form.EditSpendingForm;
import com.example.demo.service.CreateSpendingService;
import com.example.demo.service.EditSpendingService;
import com.example.demo.service.FindSpendingService;
import com.example.demo.service.GetAllSpendingsService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/payments")
public class PaymentsController {
	
	@Autowired
	private CreateSpendingService createSpendingService;
	
	@Autowired
	private FindSpendingService findSpendingService;
	
	@Autowired
	private EditSpendingService editSpendingService;
	
	@Autowired
	private GetAllSpendingsService getAllSpendingsService;
	
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
	
	@GetMapping("/spending_edit")
	public String spendingEdit(@RequestParam int id, EditSpendingForm editSpendingForm, Model model) {
		//Spending型にgetFindByIdの戻り値を格納
	    Spending spending = findSpendingService.getFindById(id);
	    //spendingr型にSpending型の情報を入れかえる
	    editSpendingForm.setId(spending.getId());
	    editSpendingForm.setCategoryId(spending.getCategoryId());
	    editSpendingForm.setAmount(spending.getAmount());
	    editSpendingForm.setUserId(spending.getUserId());
        model.addAttribute("editSpendingForm", editSpendingForm);
		return "payments/spending_edit";
	}
	
	@PostMapping("/spending_edit")
	public String spendingEdit(@Valid @ModelAttribute("editUser") EditSpendingForm editSpendingForm, BindingResult result, Model model) {
		List<Spending> spendings = getAllSpendingsService.getAllSpendings();
		if (result.hasErrors()) {
            model.addAttribute("editSpendingForm", editSpendingForm);
            return "payments/spending_edit";
        }
		model.addAttribute("spendings", spendings);
		editSpendingService.edit(editSpendingForm);
		return "payments/spending_edit";
	}
}