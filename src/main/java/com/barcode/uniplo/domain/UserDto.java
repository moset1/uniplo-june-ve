package com.barcode.uniplo.domain;

import java.sql.Date;

public class UserDto {
    private int user_id;
    private String user_email;
    private String user_password;
    private String user_last_name;
    private String user_first_name;
    private String user_phone_number;
    private Date user_birth_date;
    private String is_agreed;
    private String user_status;
    private String user_role;

    public UserDto() {}

    public UserDto(int user_id, String user_email, String user_password, String user_last_name, String user_first_name, String user_phone_number, Date user_birth_date, String is_agreed, String user_status, String user_role) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_last_name = user_last_name;
        this.user_first_name = user_first_name;
        this.user_phone_number = user_phone_number;
        this.user_birth_date = user_birth_date;
        this.is_agreed = is_agreed;
        this.user_status = user_status;
        this.user_role = user_role;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public Date getUser_birth_date() {
        return user_birth_date;
    }

    public void setUser_birth_date(Date user_birth_date) {
        this.user_birth_date = user_birth_date;
    }

    public String getIs_agreed() {
        return is_agreed;
    }

    public void setIs_agreed(String is_agreed) {
        this.is_agreed = is_agreed;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}
