package com.barcode.uniplo.domain;

public class  OrderDto {
    private int order_id;
    private String user_id;
    private String order_status;
    private Integer order_price; // 일단 null로 저장되므로 Integer 사용

    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_status() {
        return order_status;
    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Integer getOrder_price() {
        return order_price;
    }
    public void setOrder_price(Integer order_price) {
        this.order_price = order_price;
    }
}
