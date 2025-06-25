package com.barcode.uniplo.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
    private SearchCondition sc;
    public final int NAV_SIZE = 10;
    private int totalCount;  // 게시물의 총 개수
    private int totalPage;  // 전체 페이지의 개수
    private int beginPage;
    private int endPage;
    private boolean showNext = false;  // 이후를 보여줄지의 여부. endPage==totalPage이면, showNext는 false
    private boolean showPrev = false;  // 이전을 보여줄지의 여부. beginPage==1이 아니면 showPrev는 false

    public PageHandler(int totalCount, Integer page) {
        this(totalCount, new SearchCondition(page, 10));
    }

    public PageHandler(int totalCount, Integer page, Integer pageSize) {
        this(totalCount, new SearchCondition(page, pageSize));
    }

    public PageHandler(int totalCount, SearchCondition sc) {
        this.totalCount = totalCount;
        this.sc = sc;

    }

    private void doPaging(int totalCount, SearchCondition sc) {
        this.totalPage = totalCount / sc.getPageSize() + (totalCount % sc.getPageSize()==0? 0:1);
        this.sc.setPage(Math.min(sc.getPage(), totalPage));  // page가 totalPage보다 크지 않게
        this.beginPage = (this.sc.getPage() - 1) / NAV_SIZE * NAV_SIZE + 1;
        this.endPage = Math.min(beginPage + NAV_SIZE - 1, totalPage);
        this.showPrev = beginPage != 1;
        this.showNext = endPage != totalPage;
    }

    public String getQueryString() {
        return getQueryString(this.sc.getPage());
    }

    public String getQueryString(Integer page) {
        // ?page=10&pageSize=10&option=T&keyword=title
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", sc.getPageSize())
                .queryParam("option", sc.getOption())
                .queryParam("keyword", sc.getKeyword())
                .build().toString();
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public int getNAV_SIZE() {
        return NAV_SIZE;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }
}
