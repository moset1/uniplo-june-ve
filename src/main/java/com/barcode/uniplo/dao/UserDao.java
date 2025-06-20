package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.UserDto;

import java.util.Map;

public interface UserDao {
    UserDto selectByEmailAndPassword(Map<String, String> map);

    int insert(UserDto dto);

    int countByEmail(String email);
}
