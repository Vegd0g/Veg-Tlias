package com.vegdog.pojo;

import java.util.List;
import java.util.Objects;

public class ClazzOption {
    private List clazzList;
    private List dataList;

    // 无参构造器
    public ClazzOption() {
    }

    // 全参构造器
    public ClazzOption(List clazzList, List dataList) {
        this.clazzList = clazzList;
        this.dataList = dataList;
    }


    public List getClazzList() {
        return clazzList;
    }

    public void setClazzList(List clazzList) {
        this.clazzList = clazzList;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "ClazzOption{" +
                "clazzList=" + clazzList +
                ", dataList=" + dataList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzOption that = (ClazzOption) o;
        return Objects.equals(clazzList, that.clazzList) && Objects.equals(dataList, that.dataList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clazzList, dataList);
    }
}

