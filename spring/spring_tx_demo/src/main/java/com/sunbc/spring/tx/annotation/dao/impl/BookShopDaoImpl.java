package com.sunbc.spring.tx.annotation.dao.impl;

import com.sunbc.spring.exception.BookStockException;
import com.sunbc.spring.exception.UserAccountException;
import com.sunbc.spring.tx.annotation.dao.BookShopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        String sql2 = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
        if (stock == 0){
            throw new BookStockException("库存不足");
        }
        String sql = "UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?";
        jdbcTemplate.update(sql,isbn);
    }

    @Override
    public void updateUserAccount(String username, int price) {
        String sql2 = "SELECT balance FROM account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql2,Integer.class,username);
        if (balance < price){
            throw new UserAccountException("余额不足!");
        }
        String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql,price,username);
    }
}
