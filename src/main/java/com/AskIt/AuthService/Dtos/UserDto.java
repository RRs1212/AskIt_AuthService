package com.AskIt.AuthService.Dtos;

import com.AskIt.EntityService.Models.User;
import lombok.*;

import javax.xml.crypto.Data;
import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;

    private String name;
    private String email;
    private String password;

    private Date createdAt;



    public static  UserDto from(User u){
        return UserDto.builder().name(u.getName())
                .email(u.getEmail())
                .id(u.getId().toString())
                .password(u.getPassword())
                .createdAt(u.getCreatedAt()).build();
    }


}
