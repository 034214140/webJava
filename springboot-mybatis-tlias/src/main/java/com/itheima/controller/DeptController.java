package com.itheima.controller;


import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    //  @RequestMapping(value = "/depts",method = RequestMethod.GET)

    @Autowired
    private DeptService deptService;

    //查询全部数据
    @GetMapping
    public Result list() {
        log.info("查询全部数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    //删除部门
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除部门id=" + id + "数据");
        deptService.delete(id);
        return Result.success();
    }

    //新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门: " + dept.toString());
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询数据
    @GetMapping("/{id}")
    public Result idlist(@PathVariable Integer id) {
        log.info("查询id:{}的数据", id);
        Dept dept = deptService.selectId(id);
        return Result.success(dept);

    }
//修改id数据
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改id:{}的数据", dept.getId());
        log.info("修改为{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
