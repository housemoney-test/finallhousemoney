package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {

	List<User> findAll();

	int create(User entity);
	User login(User entity);

	User findById(Integer id);
	User findByName(String name);
	

}