package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CartDao;
import com.barcode.uniplo.domain.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    public void addToCart(CartDto cartDto) throws Exception {
        if (cartDao.isDuplicate(cartDto)) {
            // 1. 기존 수량 조회
            List<CartDto> cartList = cartDao.getCartList(cartDto.getUser_id());
            for (CartDto existing : cartList) {
                if (existing.equals(cartDto)) { // equals가 아이템 ID/색상/사이즈 기준으로 구현되어 있음
                    cartDto.setCart_item_cnt(existing.getCart_item_cnt() + 1);
                    break;
                }
            }
            // 2. 수량 증가로 update
            cartDao.updateCnt(cartDto);
        } else {
            cartDto.setCart_item_cnt(1); // 수량 1로 초기 설정
            cartDao.insertCart(cartDto);
        }
    }

    public void updateCnt(CartDto cartDto) throws Exception {
        // 0 이하 입력 시 삭제 처리로 변경할 수도 있음
        if (cartDto.getCart_item_cnt() <= 0) {
            cartDao.deleteCartItem(cartDto);
        } else {
            cartDao.updateCnt(cartDto);
        }
    }

    public CartDto getCartItem(CartDto cartDto) throws Exception {
        return cartDao.getCartItem(cartDto);
    }

    public List<CartDto> getItems(String userId) throws Exception {
        return cartDao.getCartList(userId);
    }

    public void deleteItem(CartDto cartDto) throws Exception {
        cartDao.deleteCartItem(cartDto);
    }

}