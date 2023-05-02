package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Spending;
import com.example.demo.form.CreateSpendingForm;
import com.example.demo.mapper.SpendingMapper;

@Service
public class CreateSpendingService {
    
    @Autowired
    private SpendingMapper spendingMapper;
    
    @Transactional
	public int createSpending(CreateSpendingForm createSpendingForm) {
		Spending entity = new Spending();
		entity.setCategoryId(createSpendingForm.getCategoryId());
		entity.setAmount(createSpendingForm.getAmount());
		entity.setUserId(createSpendingForm.getUserId());
		return spendingMapper.createSpending(entity);
	}
    
}