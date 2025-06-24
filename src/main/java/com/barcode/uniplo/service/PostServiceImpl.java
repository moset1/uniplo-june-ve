package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.PostDao;
import com.barcode.uniplo.domain.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao postDao;

    @Override
    public int getCount() {
        return postDao.count();
    }

    @Override
    public int remove(Integer post_id, Integer user_id) {
        return postDao.delete(post_id, user_id);
    }

    @Override
    public int write(PostDto postDto) {
        return postDao.insert(postDto);
    }

    @Override
    public PostDto read(Integer post_id) {
        postDao.increaseViewCount(post_id);
        return postDao.select(post_id);
    }

    @Override
    public List<PostDto> getPage(Map map) {
        return postDao.selectPage(map);
    }

    @Override
    public int modify(PostDto postDto) {
        return postDao.update(postDto);
    }


}
