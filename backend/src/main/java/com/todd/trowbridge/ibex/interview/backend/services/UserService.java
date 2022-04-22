package com.todd.trowbridge.ibex.interview.backend.services;

import com.todd.trowbridge.ibex.interview.backend.entities.User;
import com.todd.trowbridge.ibex.interview.backend.repos.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDetailsRepository.findByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Doctor Not Found with User Name " + username);
        }
        return user;
    }
}
