package com.sunbc.service.impl;

import com.sunbc.beans.Employee;
import com.sunbc.mapper.EmployeeMapper;
import com.sunbc.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sunbc
 * @since 2020-06-25
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
