package com.vegdog.pojo;

import java.time.LocalDateTime;


public class OperateLog {
    private Integer id; // ID
    private Integer operateEmpId; // 操作人ID
    private LocalDateTime operateTime; // 操作时间
    private String className; // 操作类名
    private String methodName; // 操作方法名
    private String methodParams; // 操作方法参数
    private String returnValue; // 操作方法返回值
    private Long costTime; // 操作耗时
    private String operateEmpName;

    // 无参构造器
    public OperateLog() {
    }

    // 全参构造器
    public OperateLog(Integer id, Integer operateEmpId, LocalDateTime operateTime, String className, String methodName, String methodParams, String returnValue, Long costTime,String operateEmpName) {
        this.id = id;
        this.operateEmpId = operateEmpId;
        this.operateTime = operateTime;
        this.className = className;
        this.methodName = methodName;
        this.methodParams = methodParams;
        this.returnValue = returnValue;
        this.costTime = costTime;
        this.operateEmpName=operateEmpName;
    }

    // Getter 和 Setter 方法

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOperateEmpId() {
        return operateEmpId;
    }

    public void setOperateEmpId(Integer operateEmpId) {
        this.operateEmpId = operateEmpId;
    }

    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public String getReturnValue() {
        return returnValue;
    }

    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public String getOperateEmpName() {
        return operateEmpName;
    }

    public void setOperateEmpName(String operateEmpName) {
        this.operateEmpName = operateEmpName;
    }

    // toString 方法
    @Override
    public String toString() {
        return "OperateLog{" +
                "id=" + id +
                ", operateEmpId=" + operateEmpId +
                ", operateTime=" + operateTime +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodParams='" + methodParams + '\'' +
                ", returnValue='" + returnValue + '\'' +
                ", costTime=" + costTime +'\''+
                ", operateEmpName='" + operateEmpName +
                '}';
    }
}

