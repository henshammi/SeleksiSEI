package com.projek.msib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projek.msib.api.model.User;
import com.projek.msib.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public void removeOne(Long id) {
        userRepository.deleteById(id);
    }
}