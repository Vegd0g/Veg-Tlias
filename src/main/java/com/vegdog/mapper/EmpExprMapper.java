package com.vegdog.mapper;

import com.vegdog.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//员工工作经历表
@Mapper
public interface EmpExprMapper {
    void insertBatch(List<EmpExpr> exprList);

    void delete(List<Integer> empids);
}
