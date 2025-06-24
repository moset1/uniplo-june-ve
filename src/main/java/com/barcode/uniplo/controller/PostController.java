package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.PostDto;
import com.barcode.uniplo.domain.UserDto;
import com.barcode.uniplo.service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/write")
    public String write(PostDto postDto, HttpSession session) {
        UserDto userDto = (UserDto)session.getAttribute("user");
        Integer user_id = userDto.getUser_id();
        if(user_id == null)
            return "redirect:/login/login";
        postDto.setUser_id(user_id);
        int rowCnt = postService.write(postDto);

    }
}
