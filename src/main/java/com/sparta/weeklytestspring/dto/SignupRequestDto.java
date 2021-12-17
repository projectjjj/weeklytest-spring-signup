package com.sparta.weeklytestspring.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequestDto {
    private String userid;
    private String password;
}
