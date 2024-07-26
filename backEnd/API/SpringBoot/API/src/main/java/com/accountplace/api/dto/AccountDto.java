package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AccountDto{
    private int id;
    private String username;
    private Email email;
    private String password;
    private Privilege privilege;
    private List<GroupDto> groups;
}
