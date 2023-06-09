package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Post;
import com.example.demo.form.CreatePostForm;
import com.example.demo.mapper.PostMapper;

@Service
public class CreatePostService{
    
    @Autowired
    private PostMapper postMapper;
    
    @Transactional
    public void create(CreatePostForm form) {
        Post entity = new Post();
        entity.setTitle(form.getTitle());;
        entity.setBody(form.getBody());
        entity.setUser_id(form.getUser_id());
        postMapper.create(entity);
    }
}