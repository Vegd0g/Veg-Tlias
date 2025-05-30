package com.vegdog.controller;

import com.vegdog.annotation.LogOperation;
import com.vegdog.pojo.PageResult;
import com.vegdog.pojo.Result;
import com.vegdog.pojo.Student;
import com.vegdog.pojo.StudentQueryParam;
import com.vegdog.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentQueryParam studentQueryParam){
        log.info("展示所有学生信息");
        PageResult<Student> pageResult =studentService.page(studentQueryParam);
        return Result.success(pageResult);
    }

    @LogOperation
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除学生信息");
        studentService.delete(ids);
        return Result.success();
    }

    @LogOperation
    @PostMapping
    public Result add(@RequestBody Student newSdu){
        log.info("新增学员");
        studentService.add(newSdu);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id获取学员");
        Student stu =studentService.getById(id);
        return Result.success(stu);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Student stu){
        log.info("修改员工数据");
        studentService.update(stu);
        return Result.success();
    }

    @LogOperation
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id,@PathVariable Integer score){
        log.info("修改违纪记录");
        studentService.violation(id,score);
        return Result.success();
    }

}
