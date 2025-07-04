package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.PostDto;
import com.barcode.uniplo.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface PostDao {
    int count();

    int delete(Integer post_id, Integer user_id);

    int insert(PostDto postDto);

    List<PostDto> selectAll();

    PostDto select(Integer post_id);

    List<PostDto> selectPage(Map map);

    int update(PostDto postDto);

    int updateCommentCount(Integer post_id, int count);

    int increaseViewCount(Integer post_id);

    List<PostDto> searchSelectPage(SearchCondition sc);

    int searchResultCount(SearchCondition sc);

    public Boolean deletePost(Map map);
}
