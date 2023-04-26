package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.form.CreatePostForm;
import com.example.demo.service.CreatePostService;

@Controller
@RequestMapping("/posts")
public class PostsController{
    
    @Autowired
    private CreatePostService createPostService;
    @GetMapping
    public String index(Model model){
        return "posts/index";
    }
    
    @GetMapping("create")
    public String post(Model model) {
        model.addAttribute("form", new CreatePostForm());
        return "posts/create";
    }
    
    @PostMapping("create")
    public String create(@ModelAttribute("form") CreatePostForm form, Model model) {
        createPostService.create(form);
        return "posts/index";
    }
}