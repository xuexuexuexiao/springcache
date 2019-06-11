package com.example.demo.mappper;

import com.example.demo.bean.Department;
import com.example.demo.bean.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-06-04
 **/
@Mapper
@Component
public interface EmployeeMapper {

    @Select("select  * from employee where id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("update employee set employeeName = #{employeeName}  where id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("delete from employee where id=#{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee(employeeName,d_id) values(#{employeeName},#{dId})")
    public void insertEmp(Employee employee);
}
