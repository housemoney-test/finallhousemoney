package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostsController{
    
//    @Autowired
//    private CreatePostService createPostService;
    @GetMapping
    public String index(Model model){
        return "posts/index";
    }
    
    @GetMapping("create")
    public String post(Model model) {
//        model.addAttribute("form", createPostForm);
        return "posts/create";
    }
}