package com.AskIt.AuthService.Services;

import com.AskIt.AuthService.Dtos.AccountCreateionDetail;
import com.AskIt.AuthService.Dtos.SignUpRequestDto;
import com.AskIt.AuthService.Dtos.UserDto;

public interface IAuthService {

    AccountCreateionDetail<?> singnUpUser(SignUpRequestDto signUpRequestDto);
}
