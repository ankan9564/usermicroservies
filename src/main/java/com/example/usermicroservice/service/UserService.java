package com.example.usermicroservice.service;

import com.example.usermicroservice.entity.User;
import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    String deleteUser(Long id);
}
