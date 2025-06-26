package com.barcode.uniplo.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CommentDto {
    private Integer comment_id;
    private Integer post_id;
    private Integer parent_comment_id;
    private String comment_content;
    private Integer user_id;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public CommentDto() {}

    public CommentDto(Integer post_id, Integer parent_comment_id, String comment_content, Integer user_id) {
        this.post_id = post_id;
        this.parent_comment_id = parent_comment_id;
        this.comment_content = comment_content;
        this.user_id = user_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getParent_comment_id() {
        return parent_comment_id;
    }

    public void setParent_comment_id(Integer parent_comment_id) {
        this.parent_comment_id = parent_comment_id;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
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

    @Override
    public String toString() {
        return "CommentDto{" +
                "comment_id=" + comment_id +
                ", post_id=" + post_id +
                ", parent_comment_id=" + parent_comment_id +
                ", comment_content='" + comment_content + '\'' +
                ", user_id=" + user_id +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(comment_id, that.comment_id) && Objects.equals(post_id, that.post_id) && Objects.equals(parent_comment_id, that.parent_comment_id) && Objects.equals(comment_content, that.comment_content) && Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment_id, post_id, parent_comment_id, comment_content, user_id);
    }
}
