package com.barcode.uniplo.domain;

public class OrderProductDto {
    private int order_id;
    private String item_id;
    private String item_color_code;
    private String item_size_code;
    private String ored_item_name;
    private Integer ored_item_price;
    private int ored_item_cnt;

    // Getters & Setters
    public int getOrder_id() { return order_id; }
    public void setOrder_id(int order_id) { this.order_id = order_id; }

    public String getItem_id() { return item_id; }
    public void setItem_id(String item_id) { this.item_id = item_id; }

    public String getItem_color_code() { return item_color_code; }
    public void setItem_color_code(String item_color_code) { this.item_color_code = item_color_code; }

    public String getItem_size_code() { return item_size_code; }
    public void setItem_size_code(String item_size_code) { this.item_size_code = item_size_code; }

    public String getOred_item_name() { return ored_item_name; }
    public void setOred_item_name(String ored_item_name) { this.ored_item_name = ored_item_name; }

    public Integer getOred_item_price() { return ored_item_price; }
    public void setOred_item_price(Integer ored_item_price) { this.ored_item_price = ored_item_price; }

    public int getOred_item_cnt() { return ored_item_cnt; }
    public void setOred_item_cnt(int ored_item_cnt) { this.ored_item_cnt = ored_item_cnt; }
}
