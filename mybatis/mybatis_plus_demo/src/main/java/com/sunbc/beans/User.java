package com.sunbc.beans;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * Created on 2020-06-25
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class User {
    private Integer id;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;
    private Integer flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
