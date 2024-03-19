package com.K1dou.restwithspringbootandjava.service;

import com.K1dou.restwithspringbootandjava.entity.User;
import com.K1dou.restwithspringbootandjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null){
            return user;
        }else {
            throw new UsernameNotFoundException("Username "+username+" not found!");
        }
    }



}
