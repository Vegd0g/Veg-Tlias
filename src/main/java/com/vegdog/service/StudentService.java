package com.vegdog.service;

import com.vegdog.pojo.PageResult;
import com.vegdog.pojo.Student;
import com.vegdog.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface StudentService {
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void add(Student newSdu);

    Student getById(Integer id);

    void update(Student stu);

    void violation(Integer id, Integer score);

}


