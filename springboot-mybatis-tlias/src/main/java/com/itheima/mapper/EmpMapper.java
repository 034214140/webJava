package com.itheima.mapper;

import com.itheima.pojo.Emp;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /*//获取总行数
        @Select("select  count(*) from emp")
        public Long count();
    //分页查询
        @Select("select * from emp limit #{start},#{pageSize}")
        public List<Emp> page(Integer start, Integer pageSize);*/
//员工信息查询
    // @Select("select * from emp ")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp select(List<Integer> ids);

    void update(Emp emp);
}
