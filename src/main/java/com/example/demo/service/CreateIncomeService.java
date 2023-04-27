package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Income;
import com.example.demo.form.CreateIncomeForm;
import com.example.demo.mapper.IncomeMapper;

@Service
public class CreateIncomeService {
    
    @Autowired
    private IncomeMapper incomeMapper;
    
    @Transactional
	public int createIncome(CreateIncomeForm createIncomeForm) {
		Income entity = new Income();
		entity.setCategoryId(createIncomeForm.getCategoryId());
		entity.setAmount(createIncomeForm.getAmount());
		entity.setUserId(createIncomeForm.getUserId());
		return incomeMapper.createIncome(entity);
	}
    
}