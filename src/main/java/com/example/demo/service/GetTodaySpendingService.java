package com.example.demo.service;

import com.example.demo.mapper.SpendingMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GetTodaySpendingService{
    
    @Autowired
    private SpendingMapper mapper;
    
    @Transactional
    public int getTodaySpending(String name) {
        return mapper.getTodaySpending(name);
    }
}