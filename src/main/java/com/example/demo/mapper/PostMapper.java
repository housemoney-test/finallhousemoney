package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;

@Mapper
public interface PostMapper {
    void create(Post entity);
    
    List<Post> getAll(User entity);
}
