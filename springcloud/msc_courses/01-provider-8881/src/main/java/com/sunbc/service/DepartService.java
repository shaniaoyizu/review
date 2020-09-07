package com.sunbc.service;

import com.sunbc.bean.Depart;

import java.util.List;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface DepartService {

    boolean saveDepart(Depart depart);

    boolean removeDepartById(Integer id);

    boolean modifyDepart(Depart depart);

    Depart getDepartById(Integer id);

    List<Depart> listAllDeparts();
}
