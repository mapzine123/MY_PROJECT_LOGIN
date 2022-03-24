package com.firstSpring.app.domain;

public class PageHandler {
    private int totalCnt; // 전체 게시물 갯수
    private int naviSize = 10; // 페이지 네비게이션 수
    private int totalPage; // 전체 페이지의 갯수
//    private int page; // 현제 페이지
//    private int pageSize; // 한 페이지에 표시될 개시물 수
    private int beginPage; // 네비게이션의 첫번째 페이지
    private int endPage; // 네비게이션의 마지막 페이지
    private boolean showPrev; // 이전 페이지로 이동하는 링크 보여줄?
    private boolean showNext; // 다음 페이지로 이동하는 링크 보여줄?

    private SearchCondition sc;

    public PageHandler() {
    }

    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt, sc);
    }

    public void doPaging(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;
        totalPage = (int)Math.ceil(totalCnt / (double)sc.getPageSize());
        beginPage = (sc.getPage() - 1) / naviSize * naviSize + 1;
        endPage = Math.min(totalPage, beginPage + naviSize - 1);

        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
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

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }
}

