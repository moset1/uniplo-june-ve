package com.barcode.uniplo.service;

import com.barcode.uniplo.domain.PostDto;
import com.barcode.uniplo.domain.SearchCondition;

import java.util.List;
import java.util.Map;

public interface PostService {
    int getCount();

    int remove(Integer post_id, Integer user_id);

    int write(PostDto postDto);

    List<PostDto> getList();

    PostDto read(Integer post_id);

    List<PostDto> getPage(Map map);

    int modify(PostDto postDto);

    int getSearchResultCount(SearchCondition sc);

    List<PostDto> getSearchResultPage(SearchCondition sc);
    }
