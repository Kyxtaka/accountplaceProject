package com.accountplace.api.anciens.items;

public enum Privilege {
    ADMIN("admin"),
    USER("user");

    private String privilege;

    private Privilege(String privilege) {this.privilege = privilege;}

    public String getPrivilege() {return privilege;}
}
