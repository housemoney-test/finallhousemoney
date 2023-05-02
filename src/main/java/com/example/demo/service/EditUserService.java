package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.form.EditUserForm;
import com.example.demo.mapper.UserMapper;

@Service
public class EditUserService {
    
	 @Autowired
	    private UserMapper userMapper;

	    @Transactional
	    public int editIncome(EditUserForm editUserForm) {
	        User user = new User();
	        user.setIncome(editUserForm.getIncome());
	        return userMapper.editIncome(user);
	    }
    
}