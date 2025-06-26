package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.UserDto;
import com.barcode.uniplo.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/cart/order")
    public String orderFromCart(HttpSession session) throws Exception {
        UserDto user = (UserDto) session.getAttribute("authUser");
        String userId = user.getUser_id()+"";
        orderService.makeOrder(userId);
        return "/cart/complete";
    }
}