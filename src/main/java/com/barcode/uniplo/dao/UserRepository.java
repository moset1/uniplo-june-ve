package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.barcode.uniplo.dao.UserMapper.";

    @Override
    public UserDto selectByEmailAndPassword(Map<String, String> map) {
        return session.selectOne(namespace + "selectByEmailAndPassword", map);
    }

    @Override
    public int insert(UserDto dto) {
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public int countByEmail(String email) {
        return session.selectOne(namespace + "countByEmail", email);
    }

}
