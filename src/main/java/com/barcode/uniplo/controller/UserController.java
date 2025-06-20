package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.UserDto;
import com.barcode.uniplo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("user_email") String email,@RequestParam("user_password") String password, HttpServletRequest request) {
        UserDto userDto = userService.login(email, password);
        if(userDto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDto);
            return "redirect:/";
        }
        return "login/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "login/signup";
    }

    @PostMapping("/signup")
    public String addUser(UserDto userDto) {
        if(userService.register(userDto))
            return "login/signup-success";
        return "login/signup";
    }
}
