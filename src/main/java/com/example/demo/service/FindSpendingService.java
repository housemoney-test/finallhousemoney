package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Spending;
import com.example.demo.mapper.SpendingMapper;

@Service
public class FindSpendingService {
    
    @Autowired
    private SpendingMapper spendingMapper;
    
    @Transactional
    public Spending getFindById(int id) {
        return spendingMapper.findById(id);
    }
    
}