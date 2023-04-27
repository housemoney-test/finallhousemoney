package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.FixedCost;
import com.example.demo.mapper.FixedCostMapper;



@Service
public class GetAllFixedCostsService {

	@Autowired
	private FixedCostMapper fixedCostMapper;

	@Transactional
	public List<FixedCost> getAllFixedCosts() {
		return fixedCostMapper.findAll();
	}

}