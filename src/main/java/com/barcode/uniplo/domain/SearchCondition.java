package com.barcode.uniplo.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page = 1;
    private Integer pageSize = DEFAULT_PAGE_SIZE;
    //    private Integer offset = 0;
    private String option = "";
    private String keyword = "";

    private PostType type;

    public static final int MIN_PAGE_SIZE = 5;
    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final int MAX_PAGE_SIZE = 50;

    public SearchCondition() {}

    public SearchCondition(Integer page, Integer pageSize) {
        this(page, pageSize, "", "");
    }

    public SearchCondition(Integer page, Integer pageSize, String option, String keyword) {
        this.page = page;
        this.pageSize = pageSize;
        this.option = option;
        this.keyword = keyword;
    }

    public SearchCondition(Integer page, Integer pageSize, String option, String keyword, PostType type) {
        this.page = page;
        this.pageSize = pageSize;
        this.option = option;
        this.keyword = keyword;
        this.type = type;
    }

    public String getQueryString(Integer page) {
        // ?page=1&pageSize=10&option=T&keyword="title"
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .queryParam("option", option)
                .queryParam("keyword", keyword)
                .queryParam("type", type != null ? type.name() : "")
                .build().toString();
    }

    public String getQueryString() {
        // ?page=1&pageSize=10&option=T&keyword="title"
        return getQueryString(page);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = (page != null && page > 0) ? page : 1;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) this.pageSize = DEFAULT_PAGE_SIZE;
        else if (pageSize < MIN_PAGE_SIZE) this.pageSize = MIN_PAGE_SIZE;
        else if (pageSize > MAX_PAGE_SIZE) this.pageSize = MAX_PAGE_SIZE;
        else this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (page - 1) * pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    // 필요 시 String으로도 받게 하려면
    public void setType(String type) {
        this.type = PostType.from(type);
    }
    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
