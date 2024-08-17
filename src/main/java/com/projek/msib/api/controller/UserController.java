package com.projek.msib.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projek.msib.api.model.User;
import com.projek.msib.service.UserService;

@RestController
@RequestMapping("/lokasi")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        userService.removeOne(id);
    }

}