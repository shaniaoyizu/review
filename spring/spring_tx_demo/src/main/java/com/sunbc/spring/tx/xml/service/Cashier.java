package com.sunbc.spring.tx.xml.service;

import java.util.List;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface Cashier {

    void checkOut(String username, List<String> isbns);
}
