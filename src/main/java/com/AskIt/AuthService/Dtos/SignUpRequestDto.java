package com.AskIt.AuthService.Dtos;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {

    private String name;

    private String email;

    private String password;
}
