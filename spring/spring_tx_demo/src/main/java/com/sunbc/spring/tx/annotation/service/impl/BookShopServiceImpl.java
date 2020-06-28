package com.sunbc.spring.tx.annotation.service.impl;

import com.sunbc.spring.tx.annotation.dao.BookShopDao;
import com.sunbc.spring.tx.annotation.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,price);
    }
}
