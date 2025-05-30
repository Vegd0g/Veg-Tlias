package com.vegdog.service;

import com.vegdog.pojo.Clazz;
import com.vegdog.pojo.ClazzQueryParam;
import com.vegdog.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    void update(Clazz clazz);

    PageResult<Clazz> page(ClazzQueryParam queryParam);

    void delete(Integer id);

    Clazz getInfo(Integer id);

    void add(Clazz clazz);

    List<Clazz> listAll();
}
