package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.form.CreateUserForm;
import com.example.demo.mapper.UserMapper;

@Service
public class CreateUserService {

	@Autowired
	private UserMapper mapper;
	
	@Transactional
	public int create(CreateUserForm form) {
		User entity = new User();
		entity.setName(form.getName());
		entity.setPhoneNumber(form.getPhoneNumber());
		entity.setPassword(form.getPassword());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		entity.setPassword(encoder.encode(form.getPassword()));
		
		return mapper.create(entity);
	}

}