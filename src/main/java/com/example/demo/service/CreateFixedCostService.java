package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.FixedCost;
import com.example.demo.form.CreateFixedCostForm;
import com.example.demo.mapper.FixedCostMapper;

@Service
public class CreateFixedCostService {
    
    @Autowired
    private FixedCostMapper fixedCostMapper;
    
    @Transactional
	public int createFixedCost(CreateFixedCostForm createFixedCostForm) {
		FixedCost entity = new FixedCost();
		entity.setCategoryId(createFixedCostForm.getCategoryId());
		entity.setAmount(createFixedCostForm.getAmount());
		entity.setUserId(createFixedCostForm.getUserId());
		return fixedCostMapper.createFixedCost(entity);
	}
    
}