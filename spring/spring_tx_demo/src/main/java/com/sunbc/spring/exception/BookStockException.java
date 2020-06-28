package com.sunbc.spring.exception;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class BookStockException extends RuntimeException {
    public BookStockException() {
        super();
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    protected BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
