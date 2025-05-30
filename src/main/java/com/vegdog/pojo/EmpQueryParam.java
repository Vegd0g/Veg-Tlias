package com.vegdog.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.Objects;

public class EmpQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name; //姓名
    private Integer gender; //性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //入职开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //入职结束时间

    // Getter and Setter methods

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    // toString method
    @Override
    public String toString() {
        return "EmpQueryParam{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", begin=" + begin +
                ", end=" + end +
                '}';
    }
}

