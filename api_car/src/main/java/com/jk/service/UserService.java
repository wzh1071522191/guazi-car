package com.jk.service;

import com.jk.model.User;

public interface UserService {
    int queryPhone(String phone);
    void addUser(User user);
}
