package com.vegdog.controller;

import com.vegdog.annotation.LogOperation;
import com.vegdog.pojo.Emp;
import com.vegdog.pojo.EmpQueryParam;
import com.vegdog.pojo.PageResult;
import com.vegdog.pojo.Result;
import com.vegdog.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {
        log.info("查询请求参数： {}", empQueryParam);
        PageResult pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询员工的详细信息");
        Emp emp  = empService.getInfo(id);
        return Result.success(emp);
    }

    @GetMapping("/list")
    public Result list() {
        List<Emp> emps = empService.lists();
        return Result.success(emps);
    }

    @LogOperation
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

    @LogOperation
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("删除员工ids: {}", ids);
        empService.delete(ids);
        return Result.success();
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息, {}", emp);
        empService.update(emp);
        return Result.success();
    }

}
