package com.kao.cache.cache.mapper;

import com.kao.cache.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IDepartmentMapper {

    @Select("SELECT * FROM department WHERE id = #{id} ")
    Department getDepyById(Integer id);
}
