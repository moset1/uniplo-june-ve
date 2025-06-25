package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.UserDao;
import com.barcode.uniplo.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    UserDao userDao;

    public boolean addUser(UserDto userDto) {
        userDto.setUser_status("A");
        userDto.setUser_role("C");

        if(userDao.countByEmail((userDto.getUser_email())) > 0) return false;
        return userDao.insert(userDto) == 1;
    }

    public Boolean countEmail(String userEmail) {
        return userDao.countByEmail(userEmail) > 0;
    }
}
