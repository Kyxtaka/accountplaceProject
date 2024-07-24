package com.accountplace.api.Items;

public class UserAccount extends Account{
    private String hashedPassword;
    private Privilege privilege;

    public UserAccount(int id, String username, String hashedPassword, Email email, Privilege privilege ) {
        super();
        this.hashedPassword = hashedPassword;
        this.privilege = privilege;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public boolean changePassword(String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}
