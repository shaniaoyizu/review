package com.sunbc.spring.tx.xml.service.impl;

import com.sunbc.spring.tx.xml.service.BookShopDao;
import com.sunbc.spring.tx.xml.service.BookShopService;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class BookShopServiceImpl implements BookShopService {

    private BookShopDao bookShopDao;

    public void setBookShopDao(BookShopDao bookShopDao) {
        this.bookShopDao = bookShopDao;
    }

    @Override
    public void purchase(String username, String isbn) {
        int price = bookShopDao.findBookPriceByIsbn(isbn);
        bookShopDao.updateBookStock(isbn);
        bookShopDao.updateUserAccount(username,price);
    }
}
