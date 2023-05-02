package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Spending;
import com.example.demo.mapper.SpendingMapper;

@Service
@Transactional
public class DeleteSpendingService {
	
    @Autowired
    SpendingMapper spendingMapper;
    
    public void deleteSpending(int id) {
        Spending spending = spendingMapper.findById(id);
        spendingMapper.deleteSpending(spending);
      }
}