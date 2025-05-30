package com.vegdog.controller;


import com.vegdog.pojo.*;
import com.vegdog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;
    @GetMapping("/page")
    public Result page(Integer page,Integer pageSize){
        PageResult<OperateLog> pageResult =logService.getLog(page,pageSize);
        return Result.success(pageResult);
    }
}
