package com.accountplace.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GroupDto implements IGroup{
    private int id;
    private String name;
    private String description;
    private String password;
}
