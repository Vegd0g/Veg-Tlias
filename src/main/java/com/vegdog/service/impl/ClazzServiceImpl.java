package com.vegdog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vegdog.mapper.ClazzMapper;
import com.vegdog.pojo.Clazz;
import com.vegdog.pojo.ClazzQueryParam;
import com.vegdog.pojo.PageResult;
import com.vegdog.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.updateById(clazz);

    }

    @Override
    public PageResult<Clazz> page(ClazzQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(),queryParam.getPageSize());
        LocalDate currentDate = LocalDate.now();
        List<Clazz> clazzesList =clazzMapper.list(queryParam);

        for (Clazz clazz:clazzesList){
            if(currentDate.isAfter(clazz.getEndDate())){
                clazz.setStatus("已结课");
            } else if (currentDate.isBefore(clazz.getBeginDate())) {
                clazz.setStatus("未开课");
            }else {
                clazz.setStatus("进行中");
            }
        }

        Page<Clazz> p= (Page<Clazz>) clazzesList;
        return new PageResult(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.delete(id);
    }

    @Override
    public Clazz getInfo(Integer id) {
        Clazz clazz=clazzMapper.getById(id);
        return clazz;
    }

    @Override
    public void add(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.insert(clazz);
    }

    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }
}
