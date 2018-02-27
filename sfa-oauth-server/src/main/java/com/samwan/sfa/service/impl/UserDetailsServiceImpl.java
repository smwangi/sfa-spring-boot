/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.sfa.service.impl;

import com.samwan.sfa.entity.User;
import com.samwan.sfa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
    
    @Override
    public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
        User user = null;

        if (input.contains("@"))
                user = userRepository.findActiveByEmail(input);
        else{
            System.out.println("<< Input string >> "+input);
            user = userRepository.findActiveByUsername(input);
          
            System.out.println("<< User object >> "+user);
        }
                

        if (user == null)
                throw new UsernameNotFoundException("Incorrect username, password or admin id.");

        detailsChecker.check(user);

        return user;
    }
    
}
