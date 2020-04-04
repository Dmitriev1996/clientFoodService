package com.service.clientFoodService.security;

import com.service.clientFoodService.daos.UserDAO;
import com.service.clientFoodService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Admin on 08.02.2020.
 */
@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
