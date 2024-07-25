package com.accountplace.api.dto;

import java.util.List;

public interface IAccount {
    Integer getId();
    String getUsername();
    String getPassword();
    EmailDto getEmail();
    Privilege getPrivilege();
    List<GroupDto> getGroups();
}
