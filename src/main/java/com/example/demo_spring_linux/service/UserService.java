package com.example.demo_spring_linux.service;

import com.example.demo_spring_linux.model.User;
import com.example.demo_spring_linux.repository.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();
    public User getUser(int id) {
        return userRepository.getUser(id);
    }


}
