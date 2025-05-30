package com.vegdog.mapper;

import com.vegdog.pojo.Clazz;
import com.vegdog.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzQueryParam queryParam);

    @Delete("delete from clazz where id=#{id}")
    void delete(Integer id);

    @Select("select c.* from clazz as c where c.id=#{id}")
    Clazz getById(Integer id);

    void insert(Clazz clazz);

    void updateById(Clazz clazz);

    @Select("select c.* from clazz as c")
    List<Clazz> listAll();

}
