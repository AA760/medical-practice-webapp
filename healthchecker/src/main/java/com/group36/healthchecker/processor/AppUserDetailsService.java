package com.group36.healthchecker.processor;

import com.group36.healthchecker.model.AppUserDetails;
import com.group36.healthchecker.model.User2;
import com.group36.healthchecker.repository.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService 
{

    @Autowired
    UserRepository2 userRepository2;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException
    	{
        Optional<User2> user2 = userRepository2.findByUserName(userName);

        user2.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user2.map(AppUserDetails::new).get();
    }

	
    
  
}