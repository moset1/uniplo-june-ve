package com.barcode.uniplo.domain;

import java.util.Date;
import java.util.Objects;

public class CartDto {
    private String user_id;
    private String item_id;
    private String item_color_code;
    private String item_size_code;
    private Date cart_reg_date;
    private int cart_item_cnt = 1; // 추가된 필드

    public CartDto() {}

    public CartDto(String user_id, String item_id, String item_color_code, String item_size_code, Date cart_reg_date, int cart_item_cnt) {
        this.user_id = user_id;
        this.item_id = item_id;
        this.item_color_code = item_color_code;
        this.item_size_code = item_size_code;
        this.cart_reg_date = cart_reg_date;
        this.cart_item_cnt = cart_item_cnt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return Objects.equals(user_id, cartDto.user_id) &&
                Objects.equals(item_id, cartDto.item_id) &&
                Objects.equals(item_color_code, cartDto.item_color_code) &&
                Objects.equals(item_size_code, cartDto.item_size_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, item_id, item_color_code, item_size_code);
    }

    public String getUser_id() { return user_id; }
    public void setUser_id(String user_id) { this.user_id = user_id; }

    public String getItem_id() { return item_id; }
    public void setItem_id(String item_id) { this.item_id = item_id; }

    public String getItem_color_code() { return item_color_code; }
    public void setItem_color_code(String item_color_code) { this.item_color_code = item_color_code; }

    public String getItem_size_code() { return item_size_code; }
    public void setItem_size_code(String item_size_code) { this.item_size_code = item_size_code; }

    public Date getCart_reg_date() { return cart_reg_date; }
    public void setCart_reg_date(Date cart_reg_date) { this.cart_reg_date = cart_reg_date; }

    public int getCart_item_cnt() { return cart_item_cnt; }
    public void setCart_item_cnt(int cart_item_cnt) { this.cart_item_cnt = cart_item_cnt; }
}