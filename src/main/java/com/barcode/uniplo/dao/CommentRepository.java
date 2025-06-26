package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.CommentDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CommentRepository implements CommentDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.barcode.uniplo.dao.CommentMapper.";

    @Override
    public int deleteAll(Integer post_id) {
        return session.delete(namespace + "deleteAll", post_id);
    }

    @Override
    public int count(Integer post_id) {
        return session.selectOne(namespace + "count", post_id);
    }

    @Override
    public int delete(Integer comment_id, Integer user_id) {
        Map map = new HashMap();
        map.put("comment_id", comment_id);
        map.put("user_id", user_id);
        return session.delete(namespace + "delete", map);
    }

    @Override
    public int insert(CommentDto commentDto) {
        return session.insert(namespace + "insert", commentDto);
    }

    @Override
    public List<CommentDto> selectAll(Integer post_id) {
        return session.selectList(namespace + "selectAll", post_id);
    }

    @Override
    public CommentDto select(Integer comment_id) {
        return session.selectOne(namespace + "select", comment_id);
    }

    @Override
    public int update(CommentDto commentDto) {
        return session.update(namespace + "update", commentDto);
    }
}
