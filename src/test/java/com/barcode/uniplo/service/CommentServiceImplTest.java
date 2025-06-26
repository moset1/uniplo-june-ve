package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CommentDao;
import com.barcode.uniplo.dao.PostDao;
import com.barcode.uniplo.domain.CommentDto;
import com.barcode.uniplo.domain.PostDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentServiceImplTest {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentDao commentDao;
    @Autowired
    PostDao postDao;

    @Test
    public void remove() throws Exception {



//        postDao.deleteAll();
//
//        PostDto postDto = new PostDto(null, 1, LocalDateTime.now(), LocalDateTime.now(), "제목입니당","내용입니당내용입니당", 0, 0, 0, 0, 0,"QNA", "N", "문의", "배송");
//        assertTrue(postDao.insert(postDto) == 1);
//        Integer post_id = postDao.selectAll().get(0).getPost_id();
//        System.out.println("post_id = " + post_id);
        Integer post_id = 1323;
        commentDao.deleteAll(post_id);
        CommentDto commentDto = new CommentDto(post_id,null,"hi",3);

        assertTrue(postDao.select(post_id).getComment_count() == 0);
        assertTrue(commentService.write(commentDto)==1);
        assertTrue(postDao.select(post_id).getComment_count() == 1);

        Integer comment_id = commentDao.selectAll(post_id).get(0).getComment_id();

//        // 일부러 예외를 발생시키고 Tx가 취소되는지 확인해야.
        int rowCnt = commentService.remove(comment_id, post_id, commentDto.getUser_id());
        assertTrue(rowCnt==1);
        assertTrue(postDao.select(post_id).getComment_count() == 0);
    }

    @Test
    public void write() throws  Exception {
//        postDao.deleteAll();

//        PostDto postDto = new PostDto(null, 1, LocalDateTime.now(), LocalDateTime.now(), "제목입니당","내용입니당내용입니당", 0, 0, 0, 0, 0,"QNA", "N", "문의", "배송");
//        assertTrue(postDao.insert(postDto) == 1);
//        Integer post_id = postDao.selectAll().getFirst().getPost_id();
//        System.out.println("post_id = " + post_id);

        Integer post_id = 1323;

        commentDao.deleteAll(post_id);
        CommentDto commentDto = new CommentDto(post_id,null,"hi",3);

        assertTrue(postDao.select(post_id).getComment_count() == 0);
        assertTrue(commentService.write(commentDto)==1);

        Integer comment_id = commentDao.selectAll(post_id).getFirst().getComment_id();
        assertTrue(postDao.select(post_id).getComment_count() == 1);
    }
}