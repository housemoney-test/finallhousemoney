package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Spending;
import com.example.demo.mapper.SpendingMapper;



@Service
public class GetAllSpendingsService {

	@Autowired
	private SpendingMapper spendingMapper;

	@Transactional
	public List<Spending> getAllSpendings() {
		return spendingMapper.findAll();
	}

}