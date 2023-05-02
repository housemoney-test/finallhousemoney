package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

@Service
public class FindUserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Transactional
    public User getFindById(int id) {
        return userMapper.findById(id);
    }
    
}