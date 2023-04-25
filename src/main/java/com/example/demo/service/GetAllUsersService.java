package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;



@Service
public class GetAllUsersService {

	@Autowired
	private UserMapper mapper;

	@Transactional
	public List<User> getAllUsers() {
		return mapper.findAll();
	}

}