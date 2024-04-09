package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.Empservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private Empservice empservice;

    //分页查询所有信息
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询所有信息，参数为{}，{},{},{},{},{}", page, pageSize, begin, end, name, gender);
        PageBean pageBean = empservice.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    //批量删除操作
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除操作,ids:{}", ids);
        empservice.delete(ids);
        return Result.success();
    }

    //添加员工{}的信息
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("添加员工{}的信息,{}", emp.getUsername(), emp);
        empservice.add(emp);
        return Result.success();
    }

    //查询id为{}的信息
    @GetMapping("/{ids}")
    public Result select(@PathVariable List<Integer> ids) {
        log.info("查询id为{}的信息,", ids);
        Emp emp = empservice.select(ids);
        return Result.success(emp);
    }

    //修改员工{}的信息
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改员工{}的信息", emp.getUsername());
        log.info(emp.toString());
        empservice.update(emp);
        return Result.success();
    }
    @PostMapping("/upload")
    public Result fileupload()
    {
        return Result.success();
    }
}
