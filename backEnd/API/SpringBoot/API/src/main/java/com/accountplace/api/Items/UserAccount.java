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
        if (!(hashedPassword.equals(oldPassword))) {return false;}
        this.hashedPassword = newPassword;
        return true;
    }

    @Override
    public String toString() {
        return "UserId: "+this.getId()+System.lineSeparator()
                +"username: "+this.getUsername()+System.lineSeparator()
                +"email: "+this.getEmail().getMailAddress()+System.lineSeparator()
                +"hashedPassword: "+this.getHashedPassword()+System.lineSeparator()
                +"privilege: "+this.privilege.toString()+System.lineSeparator();
    }

    @Override
    public int hashCode() {
        return this.id
                +this.username.hashCode()
                +this.email.hashCode()
                +this.hashedPassword.hashCode()
                +this.privilege.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof UserAccount)) return false;
        UserAccount other = (UserAccount) obj;
        return (this.id == other.id)
                && (this.username.equals(other.username))
                && this.email.equals(other.email)
                && this.hashedPassword.equals(other.hashedPassword)
                && this.privilege.equals(other.privilege);
    }
}
