package com.vegdog.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ClazzQueryParam {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    private Integer page = 1;      // 默认值 1
    private Integer pageSize = 10; // 默认值 10

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "ClazzQueryParam{" +
                "name='" + name + '\'' +
                ", begin=" + begin +
                ", end=" + end +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
