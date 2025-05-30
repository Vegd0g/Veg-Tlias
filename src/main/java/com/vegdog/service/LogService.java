package com.vegdog.service;

import com.vegdog.pojo.OperateLog;
import com.vegdog.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> getLog(Integer page, Integer pageSize);
}
