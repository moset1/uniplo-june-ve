package com.barcode.uniplo.domain;

public class ItemCateDetailDto {
    private Integer item_cate_detail_id;
    private String item_cate_detail_name;
    private Integer item_cate_id;

    public ItemCateDetailDto() {}

    public ItemCateDetailDto(Integer item_cate_detail_id, String item_cate_detail_name, Integer item_cate_id) {
        this.item_cate_detail_id = item_cate_detail_id;
        this.item_cate_detail_name = item_cate_detail_name;
        this.item_cate_id = item_cate_id;
    }

    public Integer getItem_cate_detail_id() {
        return item_cate_detail_id;
    }

    public void setItem_cate_detail_id(Integer item_cate_detail_id) {
        this.item_cate_detail_id = item_cate_detail_id;
    }

    public String getItem_cate_detail_name() {
        return item_cate_detail_name;
    }

    public void setItem_cate_detail_name(String item_cate_detail_name) {
        this.item_cate_detail_name = item_cate_detail_name;
    }

    public Integer getItem_cate_id() {
        return item_cate_id;
    }

    public void setItem_cate_id(Integer item_cate_id) {
        this.item_cate_id = item_cate_id;
    }
}
