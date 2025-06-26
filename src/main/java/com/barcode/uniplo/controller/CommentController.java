package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.CommentDto;
import com.barcode.uniplo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments")  // /comments?post_id=1323
    @ResponseBody public List<CommentDto> list(Integer post_id) {
        List<CommentDto> commentList = commentService.getList(post_id);
        return commentList;
    }
}
