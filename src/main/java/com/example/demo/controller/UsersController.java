package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;
import com.example.demo.form.CreateUserForm;
import com.example.demo.form.LoginUserForm;
import com.example.demo.service.GetAllUsersService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private GetAllUsersService getAllUsersService;

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = getAllUsersService.getAllUsers();
        model.addAttribute("users", users);
        return "users/index";
    }
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        // HttpSession から createUserForm を取得
        CreateUserForm createUserForm = (CreateUserForm) session.getAttribute("createUserForm");
        if(createUserForm != null) {
            //新規登録の場合はCreateUserFormをModelにセット
            model.addAttribute("user", createUserForm);
        } else {
             LoginUserForm loginUserForm = (LoginUserForm) session.getAttribute("loginUserForm");
             //ログインの場合はLoginUserFormをModelにセット
             model.addAttribute("user", loginUserForm);
        }
      
        return "users/home";
    }
    
    @GetMapping("/incomeEdit")
    public String edit(Model model, HttpSession session) {
         User user = (User) session.getAttribute("user");
            
        model.addAttribute("user", user);
            return "users/incomeEdit";

        }
    
    
    @PostMapping("/incomeEdit")
    public String edit(@ModelAttribute("loginUserForm") LoginUserForm loginUserForm,
            BindingResult result, Model model, HttpSession session) {

            return "users/incomeEdit";

        }
    
    @GetMapping("/paymentsEdit")
    public String paymentsEdit(Model model, HttpSession session) {
         User user = (User) session.getAttribute("user");
            
        model.addAttribute("user", user);
            return "users/paymentsEdit";

        }
    
    
    @PostMapping("/paymentsEdit")
    public String paymentsEdit(@ModelAttribute("loginUserForm") LoginUserForm loginUserForm,
            BindingResult result, Model model, HttpSession session) {

            return "users/paymentsEdit";

        }
    
    
}
