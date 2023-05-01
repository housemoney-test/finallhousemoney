package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Spending;
import com.example.demo.entity.User;

@Mapper
public interface SpendingMapper {

	List<Spending> findAll();

	int create(Spending entity);

	int edit(Spending spending);

	Spending findById(int id);
	
	User getTodaySpending(User entity);

	void deleteSpending(Spending spending);

}