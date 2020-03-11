package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.User;
import com.service.RolesService;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	private RolesService rolesService;

	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login(@ModelAttribute("user") User u) {

		return "login";
	}

	@PostMapping("/upCheck")
	public String check(@ModelAttribute("user") User u, BindingResult br, Model map, HttpSession session) {

		// String page = "login";
		map.addAttribute("flag", 1);

		if (br.hasErrors()) {
			return "login";
		}
		User user = userService.loginUser(u.getUserId(), u.getPassword());
		if (user != null) {

			session.setAttribute("user", user);
			session.setAttribute("userRole", user.getUserRole().getRoleName());

		}

		else {
			return "login";
		}

		return "redirect:home";
	}

	@PostMapping("/valid")
	public String signUp(@Valid @ModelAttribute("user") User u, BindingResult br, ModelMap map) {
		try {

			if (br.hasErrors()) {

				return "registration";

			}

			if (userService.userIdExists(u.getUserId())) {

				br.addError(new FieldError("user", "userId", "User Id " + u.getUserId() + " Already exists"));

				return "registration";

			}

			userService.registerUser(u);
			map.addAttribute("addCheck", true);
			return "index";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "index";
		}
	}

	@GetMapping("/signUp")
	public String reg(@ModelAttribute("user") User u) {

		return "registration";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		return "index";

	}

	@ModelAttribute("type")
	public Map<Integer, String> user() {
		Map<Integer, String> m = rolesService.getRolesList();

		return m;
	}

	@ExceptionHandler
	public String exceptionHandling() {

		return "error";
	}

}
