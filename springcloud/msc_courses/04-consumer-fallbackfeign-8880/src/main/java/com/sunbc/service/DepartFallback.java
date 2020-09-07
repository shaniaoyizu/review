package com.sunbc.service;

import com.sunbc.bean.Depart;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created on 2020-09-04
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
@RequestMapping("/fallback/consumer/depart")
public class DepartFallback implements DepartService {
    @Override
    public boolean saveDepart(Depart depart) {
        System.out.println("执行saveDepart()降级方法");
        return false;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        System.out.println("执行removeDepartById()降级方法");
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        System.out.println("执行modifyDepart()降级方法");
        return false;
    }

    @Override
    public Depart getDepartById(Integer id) {
        System.out.println("执行getDepartById()降级方法 -- class");
        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart -- class");
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        System.out.println("执行listAllDeparts()降级方法");
        return null;
    }
}
