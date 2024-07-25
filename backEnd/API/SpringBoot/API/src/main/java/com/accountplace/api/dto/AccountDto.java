package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto implements IAccount{
    private Integer id;
    private String username;
    private EmailDto email;
    private String password;
    private Privilege privilege;
    private List<GroupDto> groups;

}
