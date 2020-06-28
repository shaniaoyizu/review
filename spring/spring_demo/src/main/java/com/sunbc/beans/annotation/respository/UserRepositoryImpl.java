package com.sunbc.beans.annotation.respository;

import org.springframework.stereotype.Repository;

/**
 * Created on 2020-06-26
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void save() {
        System.out.println("UserRepository save ...");
    }
}
