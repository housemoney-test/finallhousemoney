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
	public User create(CreateUserForm createUserForm) {
		User entity = new User();
		entity.setName(createUserForm.getName());
		entity.setPassword(createUserForm.getPassword());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		entity.setPassword(encoder.encode(createUserForm.getPassword()));
		
		// 新しいユーザーをデータベースに挿入し、その結果として得られたidをentityにセットする
        mapper.create(entity);
        entity = mapper.findByName(entity.getName()); // IDをセット
        createUserForm.setId(entity.getId());
        
        return entity;
	}

}