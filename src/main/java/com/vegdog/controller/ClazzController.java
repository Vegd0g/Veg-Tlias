package com.vegdog.controller;

import com.vegdog.annotation.LogOperation;
import com.vegdog.pojo.Clazz;
import com.vegdog.pojo.ClazzQueryParam;
import com.vegdog.pojo.PageResult;
import com.vegdog.pojo.Result;
import com.vegdog.service.ClazzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result list(ClazzQueryParam queryParam){
        log.info("班级列表展示");
        PageResult<Clazz> pageResult=clazzService.page(queryParam);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id获取单人信息");
        Clazz clazz=clazzService.getInfo(id);
        return Result.success(clazz);
    }

    @GetMapping("/list")
    public Result listAll(){
        List<Clazz> clazzes = clazzService.listAll();
        return Result.success(clazzes);
    }

    @LogOperation
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除班级");
        clazzService.delete(id);
        return Result.success();
    }

    @LogOperation
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加一个新的班级");
        clazzService.add(clazz);
        return Result.success();
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息");
        clazzService.update(clazz);
        return Result.success();
    }

}
