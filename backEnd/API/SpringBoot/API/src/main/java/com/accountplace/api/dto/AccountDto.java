package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto implements IAccount{
    private int id;
    private String username;
    private String email;
    private String password;
    private Privilege privilege;
    private List<GroupDto> groups;
}
