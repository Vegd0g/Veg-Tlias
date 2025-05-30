package com.vegdog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vegdog.mapper.LogMapper;
import com.vegdog.pojo.OperateLog;
import com.vegdog.pojo.PageResult;
import com.vegdog.pojo.Student;
import com.vegdog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<OperateLog> getLog(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> list=logMapper.page();

        Page<OperateLog> p= (Page<OperateLog>) list;
        return new PageResult(p.getTotal(),p.getResult());

    }
}
