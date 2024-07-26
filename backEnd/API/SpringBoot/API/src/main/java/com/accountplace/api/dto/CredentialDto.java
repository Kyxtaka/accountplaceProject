package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CredentialDto {
    private int id;
    private String username;
    private String password;
    private Email email;
    private boolean a2f;
    private Integer plateformId;
    private Integer groupId;
}
