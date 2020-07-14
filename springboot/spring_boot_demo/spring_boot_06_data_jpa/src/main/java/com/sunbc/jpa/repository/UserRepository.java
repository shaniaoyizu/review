package com.sunbc.jpa.repository;

import com.sunbc.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
