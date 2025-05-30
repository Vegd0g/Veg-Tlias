package com.vegdog.service;

import com.vegdog.pojo.Emp;
import com.vegdog.pojo.EmpQueryParam;
import com.vegdog.pojo.LoginInfo;
import com.vegdog.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageResult page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    void update(Emp emp);

    Emp getInfo(Integer id);

    LoginInfo login(Emp emp);

    List<Emp> lists();
}
