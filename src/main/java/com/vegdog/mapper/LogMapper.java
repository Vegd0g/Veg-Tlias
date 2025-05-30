package com.vegdog.mapper;

import com.vegdog.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    @Select("SELECT l.*,e.name as operateEmpName FROM operate_log l left join emp e on l.operate_emp_id=e.id")
    List<OperateLog> page();
}
