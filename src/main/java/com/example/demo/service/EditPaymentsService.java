package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

public class EditPaymentsService {
	
	@Autowired
	private UserMapper mapper;

	@Transactional
	public User getFindById(int id) {
		return mapper.findById(id);
	}

}
