package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.FixedCost;
import com.example.demo.mapper.FixedCostMapper;

@Service
public class FindFixedCostService {
    
    @Autowired
    private FixedCostMapper fixedCostMapper;
    
    @Transactional
    public FixedCost getFindById(int id) {
        return fixedCostMapper.findById(id);
    }
    
}