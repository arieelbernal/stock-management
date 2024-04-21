package com.arda.msauth.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterDto {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
}
