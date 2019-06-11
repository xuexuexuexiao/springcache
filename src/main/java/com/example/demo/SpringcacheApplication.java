package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 缓存的使用
 * 	1、开启基于注解的缓存  @EnableCaching
 * 	2、标注注解缓存即可
 *    @cacheable
 *    @cachePut
 *    @cacheEvit
 *
 *
 */
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
@EnableCaching
public class SpringcacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcacheApplication.class, args);
	}

}
