package com.sunbc.jpa.controller;

import com.sunbc.jpa.entity.User;
import com.sunbc.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created on 2020-07-11
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id){
        User user = new User();
        user.setId(id);
        Optional<User> one = userRepository.findOne(Example.of(user));
        return one.orElse(null);
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
