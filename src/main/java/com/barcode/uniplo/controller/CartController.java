package com.barcode.uniplo.controller;

import com.barcode.uniplo.domain.UserDto;
import com.barcode.uniplo.service.CartService;
import org.springframework.ui.Model;
import com.barcode.uniplo.domain.CartDto;
import com.barcode.uniplo.dao.CartRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    // 장바구니 페이지
    @GetMapping
    public String viewCart(HttpSession session, Model model) throws Exception {
        UserDto authUser = (UserDto) session.getAttribute("authUser");
        if (authUser == null || authUser.getUser_id() == null) {
            // 로그인 안 된 상태 → 로그인 페이지로 리다이렉트
            return "redirect:/login";
        }

        // DB 쿼리에 맞게 user_id를 문자열로 변환 (user_id가 Integer라서 String 필요 시)
        String userId = authUser.getUser_id().toString();

        //System.out.println("userId from session = " + userId); 세션에서 잘 출력되는지 확인해 봄

        List<CartDto> cartList = cartService.getItems(userId);
        model.addAttribute("cartList", cartList);
        return "cart/cartList";
    }


    // 장바구니에 추가
    @PostMapping("/add")
    public String addCartItem(@ModelAttribute CartDto cartDto, HttpSession session) throws Exception {
        UserDto authUser = (UserDto) session.getAttribute("authUser");

        //cartDto의 user_id에 세션의 authUser저장. 세션은 객체여서 String으로 변환 필요
        cartDto.setUser_id(authUser.getUser_id().toString());

        cartService.addToCart(cartDto);
        return "redirect:/cart";
    }

    // 장바구니 항목 삭제
    @PostMapping("/delete")
    public String deleteCartItem(@ModelAttribute CartDto cartDto, HttpSession session) throws Exception {
        UserDto authUser = (UserDto) session.getAttribute("authUser");

       //cartDto의 user_id에 세션의 authUser저장. 세션은 객체여서 String으로 변환 필요
        cartDto.setUser_id(authUser.getUser_id().toString());

        cartService.deleteItem(cartDto);
        return "redirect:/cart";
    }

    // 장바구니 수량 수정
    @PostMapping("/update")
    public String updateCnt(@RequestParam("item_id") String item_id,
                            @RequestParam("item_color_code") String item_color_code,
                            @RequestParam("item_size_code") String item_size_code,
                            @RequestParam("num") int num,
                            HttpSession session) throws Exception {
        UserDto authUser = (UserDto) session.getAttribute("authUser");

        String userId = authUser.getUser_id().toString();

        CartDto cartDto = new CartDto();
        cartDto.setUser_id(userId);
        cartDto.setItem_id(item_id);
        cartDto.setItem_color_code(item_color_code);
        cartDto.setItem_size_code(item_size_code);

        CartDto existingCart = cartService.getCartItem(cartDto);
        int currentCnt = existingCart.getCart_item_cnt(); //지금 DB에 저장된 수
        int newCnt = currentCnt + num; //더해 or 빼

        if (newCnt < 1) {
            newCnt = 1;  // 최소 1 유지
        }
        cartDto.setCart_item_cnt(newCnt);
        cartService.updateCnt(cartDto);

        return "redirect:/cart";  // 장바구니 목록 페이지로 다시 이동
    }

}