package com.AskIt.AuthService.Services;

import com.AskIt.AuthService.Dtos.AccountCreateionDetail;
import com.AskIt.AuthService.Dtos.SignUpRequestDto;
import com.AskIt.AuthService.Dtos.UserDto;
import com.AskIt.AuthService.Repository.UserRepository;
import com.AskIt.EntityService.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();




    AuthService(UserRepository userRepository){
        this.userRepository=userRepository;

    }





    @Override
    public AccountCreateionDetail singnUpUser(SignUpRequestDto signUpRequestDto) {
        System.out.println("Useeeeeeeeeeeeeeeeeer");



        String email= signUpRequestDto.getEmail();
//        userRepository.checkUser(email);
        if(userRepository.existsByEmail(email)){
//            Box<String>b=new Box<>();
//            b.set("User is available with Email.Please sign  in");
//            return b;

            AccountCreateionDetail<String>details=new AccountCreateionDetail<>();
             details.set("User is available with Email.Please sign  in");
             return details;




        }else{
            AccountCreateionDetail<UserDto>details=new AccountCreateionDetail<>();
            User newUser=User.builder().name(signUpRequestDto.getName())
                    .email(signUpRequestDto.getEmail())
                    .password(bCryptPasswordEncoder.encode(signUpRequestDto.getPassword()))
                    .build();

            details.set(UserDto.from(userRepository.save(newUser)));
            return details;


        }

    }
}
