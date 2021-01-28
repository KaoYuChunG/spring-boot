package com.kao.cache.cache.controller;

import com.kao.cache.cache.bean.Department;
import com.kao.cache.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentService.getDetpNtId(id);
    }
}
