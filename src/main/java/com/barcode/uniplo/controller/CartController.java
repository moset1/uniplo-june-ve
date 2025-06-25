package com.barcode.uniplo.controller;

import com.barcode.uniplo.service.CartService;
import org.springframework.ui.Model;
import com.barcode.uniplo.domain.CartDto;
import com.barcode.uniplo.dao.CartRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // 장바구니 페이지
    @GetMapping
    public String viewCart(HttpSession session, Model model) throws Exception {
        String userId = (String) session.getAttribute("userId");
        List<CartDto> cartList = cartService.getItems(userId);
        model.addAttribute("cartList", cartList);
        return "cart/cartList";
    }

    // 장바구니에 추가
    @PostMapping("/add")
    public String addCartItem(@ModelAttribute CartDto cartDto, HttpSession session) throws Exception {
        String userId = (String) session.getAttribute("userId");
        cartDto.setUser_id(userId);
        cartService.addToCart(cartDto);
        return "redirect:/cart";
    }

    // 장바구니 항목 삭제
    @PostMapping("/delete")
    public String deleteCartItem(@ModelAttribute CartDto cartDto, HttpSession session) throws Exception {
        String userId = (String) session.getAttribute("userId");
        cartDto.setUser_id(userId);
        cartService.deleteItem(cartDto);
        return "redirect:/cart";
    }

    // 장바구니 수량 수정
    @PostMapping("/update")
    public String updateCartItem(@ModelAttribute CartDto cartDto, HttpSession session) throws Exception {
        String userId = (String) session.getAttribute("userId");
        cartDto.setUser_id(userId);
        cartService.updateCnt(cartDto);
        return "redirect:/cart";
    }
}