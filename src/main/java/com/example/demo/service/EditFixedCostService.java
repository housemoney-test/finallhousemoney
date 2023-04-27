package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.FixedCost;
import com.example.demo.form.EditFixedCostForm;
import com.example.demo.mapper.FixedCostMapper;

@Service
public class EditFixedCostService {
    
	 @Autowired
	    private FixedCostMapper fixedCostMapper;

	    @Transactional
	    public int edit(EditFixedCostForm editFixedCostForm) {
	        FixedCost fixedCost = new FixedCost();
	        fixedCost.setId(editFixedCostForm.getId());
	        fixedCost.setCategoryId(editFixedCostForm.getCategoryId());
	        fixedCost.setAmount(editFixedCostForm.getAmount());
	        fixedCost.setUserId(editFixedCostForm.getUserId());
	        return fixedCostMapper.edit(fixedCost);
	    }
    
}