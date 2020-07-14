package com.sunbc.cache.service;

import com.sunbc.cache.bean.Department;
import com.sunbc.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created on 2020-07-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
@CacheConfig(cacheNames = "dept", cacheManager = "deptCacheManager")
@Service
public class DeptService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        Department department = departmentMapper.getDeptById(id);
        return department;
    }
}
