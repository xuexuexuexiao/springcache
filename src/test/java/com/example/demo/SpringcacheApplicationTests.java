package com.example.demo;

import com.example.demo.bean.Department;
import com.example.demo.mappper.DepartmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringcacheApplicationTests {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Test
	public void contextLoads() {
		Department deptById = departmentMapper.getDeptById(1);
		log.info("department: "+deptById);

	}

}
