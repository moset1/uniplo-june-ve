package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.CommentDto;

import java.util.List;

public interface CommentDao {
    int deleteAll(Integer post_id);

    int count(Integer post_id);

    int delete(Integer comment_id, Integer user_id);

    int insert(CommentDto commentDto);

    List<CommentDto> selectAll(Integer post_id);

    CommentDto select(Integer comment_id);

    int update(CommentDto commentDto);
}
