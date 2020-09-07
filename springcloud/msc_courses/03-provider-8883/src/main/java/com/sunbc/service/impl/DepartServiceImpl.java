package com.sunbc.service.impl;

import com.sunbc.bean.Depart;
import com.sunbc.repository.DepartRepository;
import com.sunbc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Value("${server.port}")
    private int port;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = repository.save(depart);
        return obj != null ? true : false;
    }

    @Override
    public boolean removeDepartById(Integer id) {
        if (repository.existsById(id)) {
            // 若DB中指定的id不存在，会抛出异常
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        return obj != null ? true : false;
    }

    @Override
    public Depart getDepartById(Integer id) {
        if (repository.existsById(id)) {
            Depart depart = repository.getOne(id);
            depart.setName(depart.getName() + port);
            return depart;
        }
        Depart depart = new Depart();
        depart.setName("no this depart" + port);
        return depart;
    }

    @Override
    public List<Depart> listAllDeparts() {
        List<Depart> list = repository.findAll();
        for (Depart depart : list) {
            depart.setName(depart.getName() + port);
        }
        return list;
    }
}
