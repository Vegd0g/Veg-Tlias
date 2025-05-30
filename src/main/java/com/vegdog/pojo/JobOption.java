package com.vegdog.pojo;

import java.util.List;

public class JobOption {
    private List jobList;
    private List dataList;

    public JobOption(List jobList, List dataList) {
        this.jobList = jobList;
        this.dataList = dataList;
    }
    public List getJobList() {
        return jobList;
    }
    public void setJobList(List jobList) {
        this.jobList = jobList;
    }
    public List getDataList() {
        return dataList;
    }
    public void setDataList(List dataList) {
        this.dataList = dataList;
    }
    @Override
    public String toString() {
        return "JobOption{" +
                "jobList=" + jobList +
                ", dataList=" + dataList +
                '}';
    }
}
