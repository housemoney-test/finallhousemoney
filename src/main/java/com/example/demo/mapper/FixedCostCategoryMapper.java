package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.FixedCostCategory;

@Mapper
public interface FixedCostCategoryMapper {
    List<FixedCostCategory> fixedCostCategoryAll();
}