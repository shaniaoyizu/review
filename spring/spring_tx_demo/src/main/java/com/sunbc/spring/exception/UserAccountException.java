package com.sunbc.spring.exception;

/**
 * Created on 2020-06-27
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class UserAccountException extends RuntimeException {
    public UserAccountException() {
        super();
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    protected UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
