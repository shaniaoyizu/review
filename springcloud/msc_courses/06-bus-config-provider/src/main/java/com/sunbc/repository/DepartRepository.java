package com.sunbc.repository;

import com.sunbc.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
// 第一个泛型是当前Repository所操作的对象的类型
// 第二个泛型是当前Repository所操作的对象的id类型
public interface DepartRepository extends JpaRepository<Depart,Integer>{
}
