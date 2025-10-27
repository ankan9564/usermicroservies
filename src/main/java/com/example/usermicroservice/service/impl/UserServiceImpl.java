
package com.example.usermicroservice.service.impl;

import com.example.usermicroservice.entity.User;
import com.example.usermicroservice.repository.UserRepository;
import com.example.usermicroservice.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) { return repository.save(user); }
    public List<User> getAllUsers() { return repository.findAll(); }
    public User getUserById(Long id) { return repository.findById(id).orElse(null); }
    public User updateUser(Long id, User user) {
        User existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setRole(user.getRole());
            return repository.save(existing);
        }
        return null;
    }
    public String deleteUser(Long id) {
        repository.deleteById(id);
        return "User deleted successfully";
    }
}
