package com.kao.cache.cache.service;

import com.kao.cache.cache.bean.Department;
import com.kao.cache.cache.mapper.IDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

//@CacheConfig(cacheNames="dept", cacheManager = "redisCacheManager")
@Service
public class DepartmentService {

    @Autowired
    IDepartmentMapper departmentMapper;

    //@Qualifier 用於指定自訂的 cacheManager no config，當有很多個的時候。
    @Qualifier("redisCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;



    @Cacheable(cacheNames = "dept", cacheManager = "redisCacheManager")
    public Department getDetpNtId(Integer id){
        Department dept = departmentMapper.getDepyById(id);
        return dept;
    }

//  不用註解來加入緩存
    public Department getDetpNtIdSemAnotacao(Integer id){
        Department department = departmentMapper.getDepyById(id);
        Cache dept = deptCacheManager.getCache("dept");
        //add one data into cache
        dept.put("dept:1", department);
        return department;
    }
}
