package com.barcode.uniplo.domain;

public class ItemCateDto {
    private Integer item_cate_id;
    private String item_cate_name;
    private Integer gender_id;

    public ItemCateDto() {}

    public ItemCateDto(Integer item_cate_id, String item_cate_name, Integer gender_id) {
        this.item_cate_id = item_cate_id;
        this.item_cate_name = item_cate_name;
        this.gender_id = gender_id;
    }

    public Integer getItem_cate_id() {
        return item_cate_id;
    }

    public void setItem_cate_id(Integer item_cate_id) {
        this.item_cate_id = item_cate_id;
    }

    public String getItem_cate_name() {
        return item_cate_name;
    }

    public void setItem_cate_name(String item_cate_name) {
        this.item_cate_name = item_cate_name;
    }

    public Integer getGender_id() {
        return gender_id;
    }

    public void setGender_id(Integer gender_id) {
        this.gender_id = gender_id;
    }
}
