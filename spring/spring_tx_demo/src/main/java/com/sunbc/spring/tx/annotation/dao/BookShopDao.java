package com.sunbc.spring.tx.annotation.dao;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface BookShopDao {

    /**
     * 根据书号获取书的单价
     * @param isbn
     * @return
     */
    int findBookPriceByIsbn(String isbn);

    /**
     * 更新书的库存，使书号对应的库存减1
     * @param isbn
     */
    void updateBookStock(String isbn);

    /**
     * 更新用户的账户余额：使username的balance-price
     * @param username
     * @param price
     */
    void updateUserAccount(String username,int price);
}
