package com.itheima.service;


import com.itheima.pojo.Emp;

import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

public interface Empservice {
    PageBean page(Integer page, Integer pageSize, String name,  Short gender, LocalDate begin, LocalDate end);//分页

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp select(List<Integer> ids);
    public void update(Emp emp);
}
