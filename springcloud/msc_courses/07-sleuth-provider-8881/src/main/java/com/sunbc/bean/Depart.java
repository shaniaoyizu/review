package com.sunbc.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Data
@Entity //使用自动建表
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","fieldHandler"}) //忽略延迟加载
public class Depart {
    @Id //表示当前属性为自动建的表的主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //主键自动递增
    private Integer id;
    private String name;
}
