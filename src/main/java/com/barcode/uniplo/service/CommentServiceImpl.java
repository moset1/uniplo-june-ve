package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CommentDao;
import com.barcode.uniplo.dao.PostDao;
import com.barcode.uniplo.domain.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;
    PostDao postDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao, PostDao postDao) {
        this.commentDao = commentDao;
        this.postDao = postDao;
    }

    @Override
    public int getCount(Integer post_id) {
        return commentDao.count(post_id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int remove(Integer comment_id, Integer post_id, Integer user_id) {
        int rowCount = postDao.updateCommentCount(post_id, -1);
        rowCount = commentDao.delete(comment_id, user_id);
        return rowCount;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int write(CommentDto commentDto) {
        postDao.updateCommentCount(commentDto.getPost_id(), 1);
        return commentDao.insert(commentDto);
    }

    @Override
    public List<CommentDto> getList(Integer post_id) {
        return commentDao.selectAll(post_id);
    }

    @Override
    public CommentDto read(Integer comment_id) {
        return commentDao.select(comment_id);
    }

    @Override
    public int modify(CommentDto commentDto) {
        return commentDao.update(commentDto);
    }
}
