package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.CartDto;

import java.util.List;

public interface CartDao {
    int insertCart(CartDto cart) throws Exception;
    //전체 상품 불러오기
    List<CartDto> getCartList(String userId) throws Exception;
    //단일 상품 불러오기(수량 업데이트를 위해)
    CartDto getCartItem(CartDto cartDto) throws Exception;

    int deleteCartItem(CartDto cart) throws Exception;

    boolean isDuplicate(CartDto cart) throws Exception;

    int updateCnt(CartDto cart) throws Exception;

//    int getTotalPriceByUserId(String userId) throws Exception;
}