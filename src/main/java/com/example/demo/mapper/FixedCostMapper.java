package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.FixedCost;

@Mapper
public interface FixedCostMapper {

	List<FixedCost> findAll();


	int edit(FixedCost fixedCost);

	FixedCost findById(int id);

	int createFixedCost(FixedCost entity);

}