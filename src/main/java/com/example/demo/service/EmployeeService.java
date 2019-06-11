package com.example.demo.service;/**
 * Created by 20190301 on 2019/6/4.
 */

import com.example.demo.bean.Employee;
import com.example.demo.mappper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Huxiaoxue
 * @version V1.0
 * @ClassName
 * @desc:
 * @create: 2019-06-04
 **/
@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询缓存，将方法的查询结果进行缓存，以后再要相同的方法，不用调用方法
     * CacheManager管理多个Cache组件，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件都有一个唯一一个名字
     *
     * 几个属性：
     *   cacheNames/value:指定缓存的组件的名字
     *   key：缓存数据使用的key;可以用它来指定，默认是使用方法参数的值
     *     spel：#id,参数的值   #a #b  #root.args[0]
     *   keyGenerator:key的生成器，可以指定key的组件生成器的组件id（将自定义的keyGenerator放到容器中）
     *     key/keyGenerator:二选一使用
     *   cacheManager缓存管理器：指定缓存管理器。或者cacheResolver指定解析器
     *   condition:指定符合条件的情况下才缓存
     *   unless:否定缓存，当unless的为true时，才不被缓存
     *
     *   原理：
     *   1、自动配置：CacheAutoConfiguration:
     *   2、缓存的配置类：
     *   0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
         1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
         2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
         3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
         4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
         5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
         6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
         7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
         8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
         9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
         3、哪些配置类默认生效？
            分析类头的注解
        4、SimpleCacheConfiguration
            SimpleCacheConfiguration 生效：
            给容器中注册了一个ConcurrentMapCacheManager
            安装缓存的名字得到缓存组件
           4.2、可以创建和获取ConcurrentMapCache类型 的缓存组件，他的作用就是将数据保存在ConcurrentMap中

       运行流程：
        1、方法运行之前，先去查询Cache（查询组件），按照cacheNames指定的名字获取
        2、去cache中查找缓存的的内容，使用一个key,默认就是方法的参数，key是按照
         某种策略生成的，默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key
            生成key的策略：
            入
        3、没有查到缓存，就调用目标方法
        4、将目标方法的结果放到缓存中
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emps")
    public Employee getEmp(Integer id){
        log.info("查询员工: "+id);
        Employee empById = employeeMapper.getEmpById(id);
        return  empById;
    }
}
