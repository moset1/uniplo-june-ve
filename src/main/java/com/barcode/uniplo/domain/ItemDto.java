package com.barcode.uniplo.domain;

import java.time.LocalDateTime;

public class ItemDto {
    private int item_id;
    private String item_name;
    private int item_price;
    private String item_material;
    private LocalDateTime item_manufacturing_year_month;
    private String item_cate_code;
    private String item_cate_detail_code;
    private String gender_code;
    private int image_id;

    private String image_url;

    public ItemDto() {}

    public ItemDto(int item_id, String item_name, int item_price, String item_material, LocalDateTime item_manufacturing_year_month, String item_cate_code, String item_cate_detail_code, String gender_code, int image_id, String image_url) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_price = item_price;
        this.item_material = item_material;
        this.item_manufacturing_year_month = item_manufacturing_year_month;
        this.item_cate_code = item_cate_code;
        this.item_cate_detail_code = item_cate_detail_code;
        this.gender_code = gender_code;
        this.image_id = image_id;
        this.image_url = image_url;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public String getItem_material() {
        return item_material;
    }

    public void setItem_material(String item_material) {
        this.item_material = item_material;
    }

    public LocalDateTime getItem_manufacturing_year_month() {
        return item_manufacturing_year_month;
    }

    public void setItem_manufacturing_year_month(LocalDateTime item_manufacturing_year_month) {
        this.item_manufacturing_year_month = item_manufacturing_year_month;
    }

    public String getItem_cate_code() {
        return item_cate_code;
    }

    public void setItem_cate_code(String item_cate_code) {
        this.item_cate_code = item_cate_code;
    }

    public String getItem_cate_detail_code() {
        return item_cate_detail_code;
    }

    public void setItem_cate_detail_code(String item_cate_detail_code) {
        this.item_cate_detail_code = item_cate_detail_code;
    }

    public String getGender_code() {
        return gender_code;
    }

    public void setGender_code(String gender_code) {
        this.gender_code = gender_code;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", item_price=" + item_price +
                ", item_material='" + item_material + '\'' +
                ", item_manufacturing_year_month=" + item_manufacturing_year_month +
                ", item_cate_code='" + item_cate_code + '\'' +
                ", item_cate_detail_code='" + item_cate_detail_code + '\'' +
                ", gender_code='" + gender_code + '\'' +
                ", image_id=" + image_id +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
