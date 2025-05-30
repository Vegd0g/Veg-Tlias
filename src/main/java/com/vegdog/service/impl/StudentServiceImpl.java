package com.vegdog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vegdog.mapper.StudentMapper;
import com.vegdog.pojo.Clazz;
import com.vegdog.pojo.PageResult;
import com.vegdog.pojo.Student;
import com.vegdog.pojo.StudentQueryParam;
import com.vegdog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(),studentQueryParam.getPageSize());
        List<Student> list=studentMapper.page(studentQueryParam);

        Page<Student> p= (Page<Student>) list;
        return new PageResult(p.getTotal(),p.getResult());

    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void add(Student newSdu) {
        newSdu.setCreateTime(LocalDateTime.now());
        newSdu.setUpdateTime(LocalDateTime.now());

        studentMapper.insert(newSdu);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }

    @Override
    public void update(Student stu) {
        stu.setUpdateTime(LocalDateTime.now());
        studentMapper.update(stu);
    }

    @Override
    public void violation(Integer id, Integer score) {
        LocalDateTime currentDate = LocalDateTime.now();
        studentMapper.violation(id,score,currentDate);
    }
}
