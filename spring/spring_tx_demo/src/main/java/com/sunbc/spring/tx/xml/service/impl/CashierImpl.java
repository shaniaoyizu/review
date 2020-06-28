package com.sunbc.spring.tx.xml.service.impl;

import com.sunbc.spring.tx.xml.service.BookShopService;
import com.sunbc.spring.tx.xml.service.Cashier;

import java.util.List;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class CashierImpl implements Cashier {

    private BookShopService bookShopService;

    public void setBookShopService(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @Override
    public void checkOut(String username, List<String> isbns) {
        for (String isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
