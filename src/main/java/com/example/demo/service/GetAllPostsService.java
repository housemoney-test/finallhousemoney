package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.mapper.PostMapper;

@Service
public class GetAllPostsService {

	@Autowired
	private PostMapper mapper;
	
	@Transactional
	public List<Post> getAllPosts(String name) {
		User user = new User();
		user.setName(name);
		return mapper.getAll(user);
	}
}
