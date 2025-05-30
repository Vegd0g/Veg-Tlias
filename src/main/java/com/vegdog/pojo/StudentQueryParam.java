package com.vegdog.pojo;

public class StudentQueryParam {

    private String name; // 学员姓名
    private Integer degree; // 学历(1:初中,2:高中,3:大专,4:本科,5:硕士,6:博士)
    private Integer clazzId; // 班级ID
    private Integer page; // 分页查询的页码，如果未指定，默认为1
    private Integer pageSize; // 分页查询的每页记录数，如果未指定，默认为10

    // Getter and Setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
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

    // toString method

    @Override
    public String toString() {
        return "StudentQueryParam{" +
                "name='" + name + '\'' +
                ", degree=" + degree +
                ", clazzId=" + clazzId +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}

