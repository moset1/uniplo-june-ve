package com.barcode.uniplo.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class PostDto {
    private Integer post_id;
    private Integer user_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String post_title;
    private String post_content;
    private Integer view_count;
    private Integer like_count;
    private Integer report_count;
    private Integer comment_count;
    private Integer priority;
    private String post_type;
    private String is_private;
    private String category_main;
    private String category_sub;

    public PostDto() {}



    public PostDto(Integer post_id, Integer user_id, String post_title, String post_content, String post_type, String is_private, String category_main, String category_sub) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_type = post_type;
        this.is_private = is_private;
        this.category_main = category_main;
        this.category_sub = category_sub;
    }

    public PostDto(Integer post_id, Integer user_id, LocalDateTime created_at, LocalDateTime updated_at, String post_title, String post_content, Integer view_count, Integer like_count, Integer report_count, Integer comment_count, Integer priority, String post_type, String is_private, String category_main, String category_sub) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.post_title = post_title;
        this.post_content = post_content;
        this.view_count = view_count;
        this.like_count = like_count;
        this.report_count = report_count;
        this.comment_count = comment_count;
        this.priority = priority;
        this.post_type = post_type;
        this.is_private = is_private;
        this.category_main = category_main;
        this.category_sub = category_sub;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public Integer getView_count() {
        return view_count;
    }

    public void setView_count(Integer view_count) {
        this.view_count = view_count;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getReport_count() {
        return report_count;
    }

    public void setReport_count(Integer report_count) {
        this.report_count = report_count;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getIs_private() {
        return is_private;
    }

    public void setIs_private(String is_private) {
        this.is_private = is_private;
    }

    public String getCategory_main() {
        return category_main;
    }

    public void setCategory_main(String category_main) {
        this.category_main = category_main;
    }

    public String getCategory_sub() {
        return category_sub;
    }

    public void setCategory_sub(String category_sub) {
        this.category_sub = category_sub;
    }


    @Override
    public String toString() {
        return "PostDto{" +
                "post_id=" + post_id +
                ", user_id=" + user_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", post_title='" + post_title + '\'' +
                ", post_content='" + post_content + '\'' +
                ", view_count=" + view_count +
                ", like_count=" + like_count +
                ", report_count=" + report_count +
                ", comment_count=" + comment_count +
                ", priority=" + priority +
                ", post_type='" + post_type + '\'' +
                ", is_private='" + is_private + '\'' +
                ", category_main='" + category_main + '\'' +
                ", category_sub='" + category_sub + '\'' +
                '}';
    }
}
