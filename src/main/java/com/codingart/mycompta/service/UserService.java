package com.codingart.mycompta.service;

import com.codingart.mycompta.model.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User getUser(Long id);
    List<User> getAllUser();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
