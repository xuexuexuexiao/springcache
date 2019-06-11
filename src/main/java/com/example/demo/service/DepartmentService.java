package com.example.demo.service;

import com.example.demo.bean.Department;
import com.example.demo.mappper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-06-04
 **/
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    public Department getDeptById(Integer id){
        Department deptById = departmentMapper.getDeptById(id);
        return deptById;
    }
}
