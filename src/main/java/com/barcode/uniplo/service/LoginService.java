package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.UserDao;
import com.barcode.uniplo.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    UserDao userDao;

    public UserDto login(String email, String password) {
        Map<String, String> param = new HashMap<>();
        param.put("email", email);
        param.put("password", password);
        return userDao.selectByEmailAndPassword(param);
    }
}
