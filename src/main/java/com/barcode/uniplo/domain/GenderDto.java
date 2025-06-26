package com.barcode.uniplo.domain;

public class GenderDto {
    private Integer gender_id;
    private String gender_name;

    public GenderDto() {}

    public GenderDto(Integer gender_id, String gender_name) {
        this.gender_id = gender_id;
        this.gender_name = gender_name;
    }

    public Integer getGender_id() {
        return gender_id;
    }

    public void setGender_id(Integer gender_id) {
        this.gender_id = gender_id;
    }

    public String getGender_name() {
        return gender_name;
    }

    public void setGender_name(String gender_name) {
        this.gender_name = gender_name;
    }
}
