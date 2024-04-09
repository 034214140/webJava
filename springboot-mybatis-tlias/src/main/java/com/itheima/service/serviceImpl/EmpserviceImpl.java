package com.itheima.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;

import com.itheima.pojo.PageBean;
import com.itheima.service.Empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpserviceImpl implements Empservice {
    @Autowired
    private EmpMapper empMapper;


    /*    @Override
        public PageBean page(Integer page, Integer pageSize) {
            Long count = empMapper.count();
            Integer start = (page - 1) * pageSize;
            List<Emp> empList = empMapper.page(start, pageSize);
         PageBean pageBean=new PageBean(count,empList) ;
            return pageBean;
        }*/
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        //封装至PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp select(List<Integer> ids) {
        Emp emp = empMapper.select(ids);
        return emp;
    }

    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

}
