package com.vegdog.service;

import com.vegdog.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
