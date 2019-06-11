package com.example.demo.bean;


import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author huxiooxue
 * @date 2019-06-04
 */
@Data
public class Employee implements Serializable {

	private Integer id;

	private String employeeName;

	private Integer dId;

}
