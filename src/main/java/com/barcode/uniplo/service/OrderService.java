package com.barcode.uniplo.service;

import com.barcode.uniplo.dao.CartDao;
import com.barcode.uniplo.dao.OrderDao;
import com.barcode.uniplo.domain.CartDto;
import com.barcode.uniplo.domain.OrderDto;
import com.barcode.uniplo.domain.OrderProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    @Transactional
    public void makeOrder(String userId) throws Exception {
        // 1. 장바구니 조회
        // 장바구니 조회가 여기구나..
        // DAO의존보단 service 의존이 낫지 않을까? 하는 생각.
        // 캡슐화 위반 외에도, 서비스단에 추가 로직 있으므로, cartService 의존으로 변경하였습니다.
        List<CartDto> cartList = cartService.getItems(userId);
        // getItems 호출해야 제품 가격 설정 됩니다!

        int totalOrderPrice = 0;

        // 2. 주문 저장 (order)
        OrderDto order = new OrderDto();
        order.setUser_id(userId);
        order.setOrder_status("주문 완료");
        for (CartDto cart : cartList) {
            int itemPrice = cart.getCart_item_price();
            totalOrderPrice += itemPrice;
        }
        order.setOrder_price(totalOrderPrice); // 나중에 계산한다면 set 가능
        orderDao.insertOrder(order); // order_id가 자동으로 채워짐


        // 3. 주문상품 저장 (orderproduct)
        for (CartDto cart : cartList) {
            OrderProductDto op = new OrderProductDto();
            op.setOrder_id(order.getOrder_id());
            op.setItem_id(cart.getItem_id());
            op.setItem_color_code(cart.getItem_color_code());
            op.setItem_size_code(cart.getItem_size_code());
            op.setOred_item_cnt(cart.getCart_item_cnt());
            op.setOred_item_name(null);  // 나중에 상품 테이블에서 join해서 불러와도 됨
            int itemPrice = cart.getCart_item_price();
            op.setOred_item_price(itemPrice); // 가격도 마찬가지
            orderDao.insertOrderProduct(op);
        }




        // 4. 장바구니 비우기
        for (CartDto cart : cartList) {
            cartService.deleteItem(cart);
        }
    }
}