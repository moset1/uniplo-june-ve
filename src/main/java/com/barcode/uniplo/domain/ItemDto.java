package com.barcode.uniplo.domain;

import java.time.LocalDateTime;

public class ItemDto {
    private int id;
    private String itemName;
    private int itemPrice;
    private String itemMaterial;
    private LocalDateTime itemManufacturingYearMonth;
    private String itemCateCode;
    private String itemCateDetailCode;
    private String genderCode;
    private int imageId;

    private String imageUrl;

    public ItemDto() {}
    public ItemDto(int id, String itemName, int itemPrice, String itemMaterial, LocalDateTime itemManufacturingYearMonth, String itemCateCode, String itemCateDetailCode, String genderCode, int imageId) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemMaterial = itemMaterial;
        this.itemManufacturingYearMonth = itemManufacturingYearMonth;
        this.itemCateCode = itemCateCode;
        this.itemCateDetailCode = itemCateDetailCode;
        this.genderCode = genderCode;
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public static ItemDto of(){
        return new ItemDto(1,"test",300,"test",LocalDateTime.now(), "t", "t", "M", 123);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(String itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    public LocalDateTime getItemManufacturingYearMonth() {
        return itemManufacturingYearMonth;
    }

    public void setItemManufacturingYearMonth(LocalDateTime itemManufacturingYearMonth) {
        this.itemManufacturingYearMonth = itemManufacturingYearMonth;
    }

    public String getItemCateCode() {
        return itemCateCode;
    }

    public void setItemCateCode(String itemCateCode) {
        this.itemCateCode = itemCateCode;
    }

    public String getItemCateDetailCode() {
        return itemCateDetailCode;
    }

    public void setItemCateDetailCode(String itemCateDetailCode) {
        this.itemCateDetailCode = itemCateDetailCode;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
