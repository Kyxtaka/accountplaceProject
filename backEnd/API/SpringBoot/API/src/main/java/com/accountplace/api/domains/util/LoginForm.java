package com.accountplace.api.domains.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LoginForm {
    private String identifier;
    private String password;
}
