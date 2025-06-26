package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CartDao;
import com.barcode.uniplo.dao.ItemDao;
import com.barcode.uniplo.domain.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private ItemDao itemDao;

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
        List<CartDto> cartList = cartDao.getCartList(userId);
        // 각 아이템에 대한 가격 세터 기능을 여기서 수행해야 해.
        // 리스트에서 하나씩 뽑아서, 아이템id기반 조회 후 가격 set.
        for (CartDto dto : cartList) {
            dto.setCart_item_price(itemDao.getPriceByItemId(Integer.parseInt(dto.getItem_id())));
        }
        return cartList;
    }

    public void deleteItem(CartDto cartDto) throws Exception {
        cartDao.deleteCartItem(cartDto);
    }

}