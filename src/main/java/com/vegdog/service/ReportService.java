package com.vegdog.service;

import com.vegdog.pojo.ClazzOption;
import com.vegdog.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String,Object>> getEmpGenderData();

    List<Map<String, Object>> getStuDegreeData();

    ClazzOption getStuCountData();
}
