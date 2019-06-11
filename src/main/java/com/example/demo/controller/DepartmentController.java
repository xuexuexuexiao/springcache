package com.example.demo.controller;

import com.example.demo.bean.Department;
import com.example.demo.bean.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-06-04
 **/
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable Integer id){
        Department deptById = departmentService.getDeptById(id);
        return  deptById;
    }
}
