package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.*;
import com.barcode.uniplo.exception.UnauthorizedAccessException;
import com.barcode.uniplo.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostService postService;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(PostType.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(PostType.from(text));  // 소문자 허용
            }
        });
    }

    @GetMapping("/list")
    public String list(SearchCondition sc, Model m) {
        try {
            int totalCount = postService.getSearchResultCount(sc);
            m.addAttribute("totalCount", totalCount);
            PageHandler pageHandler = new PageHandler(totalCount, sc);
            List<PostDto> list = postService.getSearchResultPage(sc);
            m.addAttribute("postList", list);
            m.addAttribute("ph", pageHandler);
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg", "LIST_ERR");
            m.addAttribute("totalCount", 0);
        }
        return "post/postList";
    }

    @GetMapping("/{post_id}")
    public String read(@PathVariable("post_id") Integer post_id, HttpSession session, HttpServletResponse response, HttpServletRequest request, Model m) throws IOException {
        PostDto postDto = postService.read(post_id);
        UserDto loginUser = (UserDto) session.getAttribute("authUser");

        if("Y".equals(postDto.getIs_private())) {
            if(loginUser == null || !loginUser.getUser_id().equals(postDto.getUser_id()) ) {
                throw new UnauthorizedAccessException("비공개 게시물입니다.");
            }
        }

        m.addAttribute("postDto", postDto);
        return "post/post";
    }

//    @GetMapping("/editForm")

    @GetMapping("/write")
    public String write(HttpSession session, Model m, RedirectAttributes rattr) {

        // 로그인한 사용자 정보가 없으면 로그인 페이지로 리다이렉트
        if (session.getAttribute("authUser") == null) {
            rattr.addFlashAttribute("msg", "로그인이 필요합니다.");
            return "redirect:/login/login";
        }

        m.addAttribute("postDto", new PostDto());
        return "post/postForm";
    }

    @PostMapping("/write")
    public String write(PostDto postDto, Model m, HttpSession session, RedirectAttributes rattr) {
        UserDto userDto = (UserDto) session.getAttribute("authUser");
        Integer user_id = userDto.getUser_id();
        if(user_id == null)
            return "redirect:/login/login";
        postDto.setUser_id(user_id);
        try {
            int rowCnt = postService.write(postDto);
            if (rowCnt != 1)
                throw new Exception("Write failed");
            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/post/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(postDto);
            m.addAttribute("msg", "WRT_ERR");
            return "post/post";
        }
    }

    @PostMapping("/modify")
    public String modify(PostDto postDto, SearchCondition sc, Model m, RedirectAttributes rattr) {
        return "";
    }

    @PostMapping("/delete")
    public String delete() {
        return "";
    }


}
