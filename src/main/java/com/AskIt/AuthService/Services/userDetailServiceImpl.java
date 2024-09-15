package com.AskIt.AuthService.Services;

import com.AskIt.AuthService.Repository.UserRepository;
import com.AskIt.EntityService.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class userDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public userDetailServiceImpl(){

    }
//    public userDetailServiceImpl(){
//
//    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User>user= userRepository.findByEmail(username);

        if(user.isPresent()){

            return new AuthUser(user.get());

        }else{
            System.out.println("not found");
            throw new UsernameNotFoundException("User not found");
        }


    }
}
