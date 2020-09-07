package com.sunbc.bean;

import lombok.Data;

import java.util.List;

/**
 * Created on 2020-06-20
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Data
public class Department {

    private Integer id;
    private String deptName;
    private List<Employee> emps;

    public Department() {
    }

    public Department(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
