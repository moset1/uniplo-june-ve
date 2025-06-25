package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.UserDto;
import com.barcode.uniplo.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "login/signup";
    }

    @PostMapping("/signup")
    public String addUser(UserDto userDto) {
        if(signupService.addUser(userDto))
            return "login/signup-success";
        return "login/signup";
    }

    @GetMapping(value = "/check-email")
    public ResponseEntity<String> checkDuplicateEmail(@RequestParam("user_email") String user_email) {

        boolean exists = signupService.countEmail(user_email);

        return exists ? ResponseEntity.ok("DUPLICATE") : ResponseEntity.ok("OK");
    }
}
