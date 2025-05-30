package com.vegdog.controller;

import com.vegdog.pojo.ClazzOption;
import com.vegdog.pojo.JobOption;
import com.vegdog.pojo.Result;
import com.vegdog.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/report")
@RestController
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计各个职位的员工人数");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别信息");
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }

    @GetMapping("/studentDegreeData")
    public Result getStuDegreeData(){
        log.info("统计学生学历信息");
        List<Map<String,Object>> degreeList =reportService.getStuDegreeData();
        return Result.success(degreeList);
    }

    @GetMapping("/studentCountData")
    public Result getStuCountData(){
        log.info("班级人数统计");
        ClazzOption clazzOption =reportService.getStuCountData();
        return  Result.success(clazzOption);
    }
}
