package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.entity.Post;

@Mapper
public interface PostMapper {
    int create(Post entity);
}
