package com.sunbc.bean;

import lombok.Data;

/**
 * Created on 2020-06-19
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    private Integer dId;
    private Department dept;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, String gender,Integer dId) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.dId = dId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", dId=" + dId +
                '}';
    }
}
