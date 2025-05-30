package com.vegdog.mapper;

import com.vegdog.pojo.Emp;
import com.vegdog.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    List<Emp> list(EmpQueryParam empQueryParam);

    void insert(Emp emp);

    void delete(List<Integer> ids);

    void updateById(Emp emp);

    Emp selectById(Integer id);

    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    List<Map<String,Object>> countEmpGenderData();

    @Select("select * from emp where username=#{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);

    List<Emp> lists();
}
