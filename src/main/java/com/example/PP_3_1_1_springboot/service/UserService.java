package com.example.PP_3_1_1_springboot.service;

import com.example.PP_3_1_1_springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> listUsers();

    void addUser(User user);

    User getUserId(long id);

    void deleteUserId(long id);

    void updateUser(User user);
}
