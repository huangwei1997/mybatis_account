package com.xjtu.pojo;

import java.util.List;

/*
* 存储分页相关信息
* */
public class Page {

    private int pageNum; //当前请求的页码数
    private int pageSize; //当前请求的每页的记录数
    private int pageStart;//当次请求，分页起始查询的行角标
    private int count; //总的数据条数
    private int pages; //总的数据页数
    private List<Log> ll; //当前分页请求的数据

    public Page(){}

    public Page(int pageNum, int pageSize, int pageStart, int count, int pages, List<Log> ll) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pageStart = pageStart;
        this.count = count;
        this.pages = pages;
        this.ll = ll;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", pageStart=" + pageStart +
                ", count=" + count +
                ", pages=" + pages +
                ", ll=" + ll +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Log> getLl() {
        return ll;
    }

    public void setLl(List<Log> ll) {
        this.ll = ll;
    }
}
