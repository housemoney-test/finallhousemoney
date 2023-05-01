package com.example.demo.service;

import com.example.demo.mapper.SpendingMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.*;

@Service
public class GetTodaySpendingService{
    
    @Autowired
    private SpendingMapper mapper;
    
    @Transactional
    public User getTodaySpending(String name) {
        User user = new User();
        user.setName(name);
        return mapper.getTodaySpending(user);
    }
}