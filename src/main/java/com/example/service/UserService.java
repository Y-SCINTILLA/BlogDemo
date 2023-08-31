package com.example.service;

import com.example.pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> selectAll();

    User selectBYUsername(String username);
}
