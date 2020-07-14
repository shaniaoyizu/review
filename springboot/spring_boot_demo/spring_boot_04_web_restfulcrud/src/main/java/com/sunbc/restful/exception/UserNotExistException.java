package com.sunbc.restful.exception;

/**
 * Created on 2020-07-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
    }

    public UserNotExistException(String message) {
        super(message);
    }
}
