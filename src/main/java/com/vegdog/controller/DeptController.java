package com.vegdog.controller;

import com.vegdog.annotation.LogOperation;
import com.vegdog.pojo.Dept;
import com.vegdog.pojo.Result;
import com.vegdog.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depts")
public class DeptController {

    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list(){
        log.info("查询部门数据");
        List<Dept>deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @LogOperation
    @DeleteMapping
    public Result delete(Integer id){
        log.info("删除部门数据"+id);
        deptService.deleteById(id);
        return Result.success();
    }
    @LogOperation
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        //@RequestBody注解将前端传递的json数据转换为java对象，
        // java对象中的属性名必须和json数据中的属性名一致
        log.info("新增部门数据"+dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        //@PathVariable注解将url中的占位符参数绑定到控制器中的形参上
        // 例如：http://localhost:8080/depts/1
        // 形参名必须与占位符参数名一致
        log.info("查询部门数据"+id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @LogOperation
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门数据:{}",dept);
        deptService.update(dept);
        return Result.success();
    }


}
