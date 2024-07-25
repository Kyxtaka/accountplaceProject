package com.accountplace.api.dto;

import lombok.Getter;

@Getter
public enum Privilege {
    ADMIN("admin"),
    USER("user");

    private final String privilege;

    private Privilege(String privilege) {this.privilege = privilege;}

}
