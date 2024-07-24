package com.accountplace.api.Items;

public enum Privilege {
    ADMIN("admin"),
    USER("user");

    private String privilege;

    private Privilege(String privilege) {
        this.privilege = privilege;
    }


}
