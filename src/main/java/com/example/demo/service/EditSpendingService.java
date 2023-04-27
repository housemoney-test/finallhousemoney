package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Spending;
import com.example.demo.form.EditSpendingForm;
import com.example.demo.mapper.SpendingMapper;

@Service
public class EditSpendingService {

    @Autowired
    private SpendingMapper spendingMapper;

    @Transactional
    public int edit(EditSpendingForm editSpendingtForm) {
        Spending spending = new Spending();
        spending.setId(editSpendingtForm.getId());
        spending.setCategoryId(editSpendingtForm.getCategoryId());
        spending.setAmount(editSpendingtForm.getAmount());
        spending.setUserId(editSpendingtForm.getUserId());
        return spendingMapper.edit(spending);
    }
}