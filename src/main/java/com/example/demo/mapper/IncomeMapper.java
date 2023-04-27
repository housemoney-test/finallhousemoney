package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Income;

@Mapper
public interface IncomeMapper {

	List<Income> findAll();

	int createIncome(Income entity);

	int editIncome(Income income);

	Income findById(int id);

}