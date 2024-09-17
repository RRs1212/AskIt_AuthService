package com.AskIt.AuthService.Controllers;

import com.AskIt.AuthService.Dtos.AccountCreateionDetail;
import com.AskIt.AuthService.Dtos.SignInRequestDto;
import com.AskIt.AuthService.Dtos.SignUpRequestDto;
import com.AskIt.AuthService.Dtos.UserDto;
import com.AskIt.AuthService.Repository.UserRepository;
import com.AskIt.AuthService.Services.IAuthService;
import com.AskIt.AuthService.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/AskItAuth")
public class AuthController {

    private IAuthService authService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    AuthController(IAuthService authService){
        this.authService=authService;
    }
    @PostMapping("/signUp/User")
    public ResponseEntity<?>signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        System.out.println("hello");

        AccountCreateionDetail accountCrationDetail =authService.singnUpUser(signUpRequestDto);

        return new ResponseEntity<>(accountCrationDetail, HttpStatus.OK);


    }
    @GetMapping("/Home")
    public ResponseEntity<?>Home(){
        return new ResponseEntity<>("AskIt....Login or sign up",HttpStatus.OK);
    }

    @PostMapping("/signIn/User")
    public ResponseEntity<?>SignIn(@RequestBody SignInRequestDto signInRequestDto){


        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(signInRequestDto.getEmail(),signInRequestDto.getPassword());


        Authentication authenticate =authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(authenticate.isAuthenticated()){
            System.out.println("authenticated");
            String toekn=jwtService.createToken(signInRequestDto.getEmail());
            return new ResponseEntity<>(toekn,HttpStatus.OK);
        }else{
            System.out.println("Not yet");
            return new ResponseEntity<>("email or password is not correct",HttpStatus.NOT_FOUND);
        }



    }

    @GetMapping("/private")
    public ResponseEntity<?> Private(){

        return new ResponseEntity<>("private",HttpStatus.OK);


    }
}
