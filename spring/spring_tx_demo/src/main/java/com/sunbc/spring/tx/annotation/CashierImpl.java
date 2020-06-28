package com.sunbc.spring.tx.annotation;

import com.sunbc.spring.tx.annotation.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;

    @Transactional
    @Override
    public void checkOut(String username, List<String> isbns) {
        for (String isbn : isbns){
            bookShopService.purchase(username,isbn);
        }
    }
}
