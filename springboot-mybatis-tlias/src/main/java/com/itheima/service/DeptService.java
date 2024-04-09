package com.itheima.service;


import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
//查询全部数据
    List<Dept> list();
    void delete(Integer id);
    void add(Dept dept);
    Dept selectId(Integer id);
    void update(Dept dept);
}
