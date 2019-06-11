package com.example.demo.mappper;

import com.example.demo.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-06-04
 **/
@Mapper
@Repository
public interface DepartmentMapper {

    @Select("select  * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Update("update department set departmentName = #{departmentName}  where id=#{id}")
    public void updateDept(Department department);

    @Delete("delete from department where id=#{id}")
    public void deleteDeptById(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    public void insertDept(Department department);

}
