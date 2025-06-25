package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.CartDto;

import java.util.List;

public interface CartDao {
    int insertCart(CartDto cart) throws Exception;

    List<CartDto> getCartList(String userId) throws Exception;

    int deleteCartItem(CartDto cart) throws Exception;

    boolean isDuplicate(CartDto cart) throws Exception;

    int updateCnt(CartDto cart) throws Exception;
}