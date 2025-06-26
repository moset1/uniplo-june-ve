package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.CommentDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommentRepositoryTest {
    @Autowired
    CommentDao commentDao;

    @Test
    public void count() throws Exception {
        commentDao.deleteAll(5);
        assertTrue(commentDao.count(5)==0);
    }

    @Test
    public void delete() throws Exception {
        commentDao.deleteAll(5);
        CommentDto commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==1);
    }

    @Test
    public void insert() throws Exception {
        commentDao.deleteAll(1);
        CommentDto commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==1);

        commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==2);
    }

    @Test
    public void selectAll() throws Exception {
        commentDao.deleteAll(5);
        CommentDto commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==1);

        List<CommentDto> list = commentDao.selectAll(5);
        assertTrue(list.size()==1);

        commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==2);

        list = commentDao.selectAll(5);
        assertTrue(list.size()==2);
    }

    @Test
    public void select() throws Exception {
        commentDao.deleteAll(5);
        CommentDto commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==1);

        List<CommentDto> list = commentDao.selectAll(5);
        String comment_content = list.get(0).getComment_content();
        Integer user_id = list.get(0).getUser_id();
        assertTrue(comment_content.equals(commentDto.getComment_content()));
        assertTrue(user_id.equals(commentDto.getUser_id()));
    }

    @Test
    public void update() throws Exception {
        commentDao.deleteAll(5);
        CommentDto commentDto = new CommentDto(5, null, "comment", 3);
        assertTrue(commentDao.insert(commentDto)==1);
        assertTrue(commentDao.count(5)==1);

        List<CommentDto> list = commentDao.selectAll(5);
        commentDto.setComment_id(list.get(0).getComment_id());
        commentDto.setComment_content("comment2");
        assertTrue(commentDao.update(commentDto)==1);

        list = commentDao.selectAll(5);
        String comment_content = list.get(0).getComment_content();
        Integer user_id = list.get(0).getUser_id();
        assertTrue(comment_content.equals(commentDto.getComment_content()));
        assertTrue(user_id.equals(commentDto.getUser_id()));
    }
}