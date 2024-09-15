package com.AskIt.AuthService.Dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequestDto {
    private String email;

    private String password;
}
