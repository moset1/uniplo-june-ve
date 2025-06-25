package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.PostDao;
import com.barcode.uniplo.domain.PostDto;
import com.barcode.uniplo.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        Date now = new Date();
        postDto.setCreated_at(now);
        postDto.setUpdated_at(now);

        postDto.setView_count(0);
        postDto.setLike_count(0);
        postDto.setReport_count(0);
        postDto.setComment_count(0);
        postDto.setPriority(0);
        return postDao.insert(postDto);
    }

    @Override
    public List<PostDto> getList() {
        return postDao.selectAll();
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

    @Override
    public int getSearchResultCount(SearchCondition sc) {
        return postDao.searchResultCount(sc);
    }

    @Override
    public List<PostDto> getSearchResultPage(SearchCondition sc) {
        return postDao.searchSelectPage(sc);
    }
}
