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

import com.example.demo.entity.FixedCost;
import com.example.demo.entity.Spending;
import com.example.demo.form.CreateSpendingForm;
import com.example.demo.form.EditFixedCostForm;
import com.example.demo.form.EditSpendingForm;
import com.example.demo.service.CreateSpendingService;
import com.example.demo.service.EditFixedCostService;
import com.example.demo.service.EditSpendingService;
import com.example.demo.service.FindFixedCostService;
import com.example.demo.service.FindSpendingService;
import com.example.demo.service.GetAllFixedCostsService;
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
	
	@Autowired
	private FindFixedCostService findFixedCostService;
	
	@Autowired
	private EditFixedCostService editFixedCostService;
	
	@Autowired
	private GetAllFixedCostsService getAllFixedCostsService;
	
//	@Autowired
//	private CreateFixedCostService createFixedCostService;
	
	@GetMapping("/index")
	public String index(Model model) {
		List<FixedCost> fixedCosts = getAllFixedCostsService.getAllFixedCosts();
		model.addAttribute("fixedCosts", fixedCosts);
		return "payments/index";
	}
	
	
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
		return "payments/spendingEdit";
	}
	
	@PostMapping("/spending_edit")
	public String spendingEdit(@Valid @ModelAttribute("editSpendingForm") EditSpendingForm editSpendingForm, BindingResult result, Model model) {
		List<Spending> spendings = getAllSpendingsService.getAllSpendings();
		if (result.hasErrors()) {
            model.addAttribute("editSpendingForm", editSpendingForm);
            return "redirect:/payments/spendingEdit";
        }
		model.addAttribute("spendings", spendings);
		editSpendingService.edit(editSpendingForm);
		return "redirect:/users/index";
	}
	
//	@GetMapping("/fixed/create")
//	public String createFixedCost(Model model) {
//		model.addAttribute("createFixedCostForm", new CreateFixedCostForm());
//		return "payments/create";
//	}
//	
//	@PostMapping("/fixed/create")
//	public String createFixedCost(@Valid @ModelAttribute("createFixedCost") CreateFixedCostForm createFixedCostForm, BindingResult result, Model model) {
//		if (result.hasErrors()) {
//	        List<String> errorList = new ArrayList<String>();
//            for (ObjectError error : result.getAllErrors()) {
//                errorList.add(error.getDefaultMessage());
//            }
//            model.addAttribute("validationError", errorList);
//			model.addAttribute("createFixedCostForm", createFixedCostForm);
//			return "payments/fixed";
//		}
//		createFixedCostService.createFixedCost(createFixedCostForm);
//		return "payments/fixed";
//	}
	
	@GetMapping("/fixed")
	public String edit(@RequestParam int id, EditFixedCostForm editFixedCostForm, Model model) {
		
		List<FixedCost> fixedCosts = getAllFixedCostsService.getAllFixedCosts();
		model.addAttribute("fixedCosts", fixedCosts);
		
		//FixedCost型にgetFindByIdの戻り値を格納
	    FixedCost fixedCost = findFixedCostService.getFindById(id);
	    //fixedCost型にFixedCost型の情報を入れかえる
	    editFixedCostForm.setId(fixedCost.getId());
	    editFixedCostForm.setCategoryId(fixedCost.getCategoryId());
	    editFixedCostForm.setAmount(fixedCost.getAmount());
	    editFixedCostForm.setUserId(fixedCost.getUserId());
        model.addAttribute("editFixedCostForm", editFixedCostForm);
		return "payments/fixed";
	}
	
	@PostMapping("/fixed")
	public String edit(@Valid @ModelAttribute("editFixedForm") EditFixedCostForm editFixedCostForm, BindingResult result, Model model) {
		List<FixedCost> fixedCosts = getAllFixedCostsService.getAllFixedCosts();
		if (result.hasErrors()) {
            model.addAttribute("editFixedCostForm", editFixedCostForm);
            return "redirect:/payments/fixed";
        }
		model.addAttribute("fixedCosts", fixedCosts);
		editFixedCostService.edit(editFixedCostForm);
		return "redirect:/users/index";
	}
	
	
//	@PostMapping("/fixed")
//	public String handleFormSubmit(@RequestParam("action") String action, @ModelAttribute("form") Object form, 
//			@RequestParam(value = "id", required = false) Integer id, BindingResult result, Model model) {
//	
//		if ("create".equals(action)) {
//			
//			if (!(form instanceof CreateFixedCostForm)) {
//			// CreateFixedCostForm以外が渡された場合はエラーとする
//			result.reject("error.invalidForm");
//			return "payments/fixed";
//			}
//			// createアクションのロジックを実装
//			CreateFixedCostForm createFixedCostForm = (CreateFixedCostForm) form;
//			if (result.hasErrors()) {
//		        List<String> errorList = new ArrayList<String>();
//	            for (ObjectError error : result.getAllErrors()) {
//	                errorList.add(error.getDefaultMessage());
//	            }
//	            model.addAttribute("validationError", errorList);
//				model.addAttribute("createFixedCostForm", createFixedCostForm);
//				return "payments/fixed";
//			}
//			createFixedCostService.createFixedCost((CreateFixedCostForm) form);
//			return "redirect:/users/index";
//			
//		} else if ("edit".equals(action)) {
//			if (!(form instanceof EditFixedCostForm)) {
//			// EditFixedCostForm以外が渡された場合はエラーとする
//			result.reject("error.invalidForm");
//			return "payments/fixed";
//			}
//			if (id == null) {
//			// idが指定されていない場合はエラーとする
//			result.reject("error.invalidId");
//			return "payments/fixed";
//			}
//			// editアクションのロジックを実装
//			EditFixedCostForm editFixedCostForm = (EditFixedCostForm) form;
//	        editFixedCostForm.setId(id);
//			List<FixedCost> fixedCosts = getAllFixedCostsService.getAllFixedCosts();
//			if (result.hasErrors()) {
//	            model.addAttribute("editFixedCostForm", editFixedCostForm);
//	            return "redirect:/payments/fixed";
//	        }
//			model.addAttribute("fixedCosts", fixedCosts);
//			
//			editFixedCostForm.setId(id);
//			editFixedCostService.edit(editFixedCostForm);
//			return "redirect:/users/index";
//			
//		} else {
//		// アクションが指定されていない場合はエラーとする
//		result.reject("error.invalidAction");
//		return "payments/fixed";
//		}
//	}
	
}