package com.accountplace.api.Items;

public class UserAccount extends Account{
    private String hashedPassword;
    private final Privilege privilege;

    public UserAccount(int id, String username, Email email, String hashedPassword, Privilege privilege ) {
        this.id = id;
        this.username = username;
        this.email = email;
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
        return "UserId: "+this.getId()+System.lineSeparator()
                +"username: "+this.getUsername()+System.lineSeparator()
                +"email: "+this.getEmail().getMailAddress()+System.lineSeparator()
                +"hashedPassword: "+this.getHashedPassword()+System.lineSeparator()
                +"privilege: "+this.privilege.toString()+System.lineSeparator();
        //return "fsafas";
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
