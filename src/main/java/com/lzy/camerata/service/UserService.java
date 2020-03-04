package com.lzy.camerata.service;


import com.lzy.camerata.model.User;
import com.lzy.camerata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User register(User user) {
        return userRepository.save(user);
    }

    public  User findMyToken(String token) {
        return userRepository.findMyToken(token);
    }
}
