package com.vegdog.mapper;

import com.vegdog.pojo.Student;
import com.vegdog.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> page(StudentQueryParam studentQueryParam);

    void delete(List<Integer> ids);

    void insert(Student newSdu);

    Student getById(Integer id);

    void update(Student stu);

    void violation(Integer id, Integer score, LocalDateTime currentTime);

    List<Map<String, Object>> getStuDegreeData();

    List<Map<String, Object>> getStuCountData();
}
