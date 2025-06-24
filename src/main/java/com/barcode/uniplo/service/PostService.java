package com.barcode.uniplo.service;

import com.barcode.uniplo.domain.PostDto;

import java.util.List;
import java.util.Map;

public interface PostService {
    int getCount();

    int remove(Integer post_id, Integer user_id);

    int write(PostDto postDto);

    PostDto read(Integer post_id);

    List<PostDto> getPage(Map map);

    int modify(PostDto postDto);
}
