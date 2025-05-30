package com.vegdog.service.impl;

import com.vegdog.mapper.EmpMapper;
import com.vegdog.mapper.StudentMapper;
import com.vegdog.pojo.ClazzOption;
import com.vegdog.pojo.JobOption;
import com.vegdog.service.ReportService;
import com.vegdog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String,Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Object>> getStuDegreeData() {
        List<Map<String, Object>> list=studentMapper.getStuDegreeData();
        return list;
    }

    @Override
    public ClazzOption getStuCountData() {
        List<Map<String,Object>> list=studentMapper.getStuCountData();
        List<Object> clazzList=list.stream().map(dataMap->dataMap.get("name")).toList();
        List<Object> dataList=list.stream().map(dataMap->dataMap.get("value")).toList();
        return new ClazzOption(clazzList,dataList);
    }
}