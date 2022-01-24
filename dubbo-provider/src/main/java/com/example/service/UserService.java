package com.example.service;


import com.example.pojo.User;

public interface UserService {
    String getUserInfo();

    User getUserById(String userId);
}

