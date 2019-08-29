package com.jk.service;

import com.jk.model.User;

public interface UserService {

    void addUser(User user);

    User queryLoginPhone(String phone);

}
