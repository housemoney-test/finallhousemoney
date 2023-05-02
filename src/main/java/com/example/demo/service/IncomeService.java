package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Income;
import com.example.demo.form.CreateIncomeForm;
import com.example.demo.form.EditIncomeForm;
import com.example.demo.mapper.IncomeMapper;

@Service
public class IncomeService {
    
    @Autowired
    private IncomeMapper incomeMapper;
    
    @Transactional
	public int createIncome(CreateIncomeForm createIncomeForm) {
		Income entity = new Income();
		entity.setCategoryName(createIncomeForm.getCategoryName());
		entity.setAmount(createIncomeForm.getAmount());
		entity.setUserId(createIncomeForm.getUserId());
		return incomeMapper.createIncome(entity);
	}
    
    @Transactional
    public int editIncome(EditIncomeForm editIncomeForm) {
        Income income = new Income();
        income.setId(editIncomeForm.getId());
        income.setCategoryName(editIncomeForm.getCategoryName());
        income.setAmount(editIncomeForm.getAmount());
        income.setUserId(editIncomeForm.getUserId());
        return incomeMapper.editIncome(income);
    }
    
    @Transactional
    public Income getFindById(int id) {
        return incomeMapper.findById(id);
    }
    
    @Transactional
	public List<Income> getAllIncomes() {
		return incomeMapper.findAll();
	}
    
}