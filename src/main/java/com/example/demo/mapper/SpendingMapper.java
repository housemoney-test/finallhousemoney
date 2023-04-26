package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Spending;

@Mapper
public interface SpendingMapper {

	List<Spending> findAll();

	int create(Spending entity);

}