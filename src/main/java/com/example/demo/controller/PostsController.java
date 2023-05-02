package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.form.CreatePostForm;
import com.example.demo.service.CreatePostService;
import com.example.demo.service.GetAllPostsService;
import com.example.demo.service.GetTodaySpendingService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/posts")
public class PostsController{
    
    @Autowired
    private CreatePostService createPostService;
    
    @Autowired
    private GetTodaySpendingService getTodaySpendingService;
    
    @Autowired
    private GetAllPostsService getAllPostsService;
    
    @GetMapping
    public String index(Model model, HttpSession session){
//        session.setAttribute("session", session);
//        String name = (String) session.getAttribute("User.name");
        User user = (User) session.getAttribute("user");
        String name = user.getName(); 
        User spendingUser = getTodaySpendingService.getTodaySpending(name);
        if(spendingUser != null) {
        int amount = spendingUser.getDaySpending();
        model.addAttribute("amount",amount);
        } else {
            model.addAttribute("amount",0);
        }
        List<Post> posts = getAllPostsService.getAllPosts(name);
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    
    @GetMapping("create")
    public String post(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int loginId = user.getId();
        model.addAttribute("form", new CreatePostForm());
        model.addAttribute("loginId", loginId);
        return "posts/create";
    }
    
    @PostMapping("create")
    public String create(@ModelAttribute("form") CreatePostForm form, Model model) {
        createPostService.create(form);
        return "redirect:/posts";
    }
}