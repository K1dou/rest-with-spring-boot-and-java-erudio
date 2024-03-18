package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
