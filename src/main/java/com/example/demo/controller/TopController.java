package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.example.demo.service.CreateUserService;
import com.example.demo.service.LoginUserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class TopController {

	@Autowired
	private LoginUserService loginUserService;

	@Autowired
	private CreateUserService createUserService;

	@GetMapping
	public String home(Model model) {
		return "top/top";
	}

	@GetMapping("/login")
	public String login(Model model) {
		//フォームの型指定
		model.addAttribute("loginUserForm", new LoginUserForm());
		return "top/login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("loginUserForm") LoginUserForm loginUserForm,
			BindingResult result, Model model, HttpSession session) {

		//loginUserFormのpassを暗号化
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		// serviceのloginメソッドの戻り値がloginUserに代入される
		User loginUser = loginUserService.login(loginUserForm);

		if (result.hasErrors()) {
			model.addAttribute("loginUserForm", new LoginUserForm());
			return "top/login";

		}

		//パスが一致している場合
		if (loginUser != null && encoder.matches(loginUserForm.getPassword(), loginUser.getPassword())) {
			// 認証が成功した場合、ログインされたUserオブジェクトをセッションに設定する
			//セッションにユーザー情報を保持する
			User user = loginUserService.setUser(loginUserForm);
			session.setAttribute("user", user);
			model.addAttribute("user", user);
			return "redirect:/users/home";

		} else {
			// falseの場合、ログイン画面に戻る
			result.rejectValue("loginErr", "Err", "ログインIDまたはパスワードが間違っています");
			model.addAttribute("loginErrorMessage", "ログインIDまたはパスワードが間違っています");
			return "top/login";
		}
	}

	@PostMapping("/signUp")
	public String create(@ModelAttribute("createUserForm") CreateUserForm createUserForm, BindingResult result,
			Model model, HttpSession session) {
		
		// ユーザー情報をデータベースに登録する
	    createUserService.create(createUserForm);
	    
	 // フォームにセットされたid情報を取得し、セッションにユーザー情報を保持する
	    User user = new User();
	    user.setId(createUserForm.getId());
	    user.setName(createUserForm.getName());
	    user.setPassword(createUserForm.getPassword());
	    session.setAttribute("user", user);
	    model.addAttribute("user", user);
	    
	    return "users/home";
	}

	@GetMapping("/signUp")
	public String create(Model model) {
		model.addAttribute("createUserForm", new CreateUserForm());

		return "top/signUp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/signUp";
	}

}
