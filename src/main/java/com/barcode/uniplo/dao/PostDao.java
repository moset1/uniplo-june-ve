package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.PostDto;

import java.util.List;
import java.util.Map;

public interface PostDao {
    int count();

    int delete(Integer post_id, Integer user_id);

    int insert(PostDto postDto);

    PostDto select(Integer post_id);

    List<PostDto> selectPage(Map map);

    int update(PostDto postDto);

    int updateCommentCount(Map map);

    int increaseViewCount(Integer post_id);
}
