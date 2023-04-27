package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.form.LoginUserForm;
import com.example.demo.form.UserForm;
import com.example.demo.mapper.UserMapper;

@Service
public class LoginUserService {

	@Autowired
	private UserMapper mapper;

	@Transactional
	public User login(LoginUserForm form) {
		User entity = new User();
		entity.setName(form.getName());
		entity.setPassword(form.getPassword());

		return mapper.login(entity);

	}

	public User setUser(UserForm userForm) {
		User user = new User();
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
	
	return user;
	}
}
