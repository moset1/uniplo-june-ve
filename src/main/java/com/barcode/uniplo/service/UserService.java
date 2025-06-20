package com.barcode.uniplo.service;

import com.barcode.uniplo.domain.UserDto;

import java.util.Map;

public interface UserService {
    UserDto login(String email, String password);

    boolean register(UserDto dto);
}
