package com.accountplace.api.anciens.items;

public class Group {
    private int id;
    private String name;
    private String hashedPassword;
//    private String description;

    public Group(int id, String name, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getHashedPassword() {return hashedPassword;}
    public void setHashedPassword(String hashedPassword) {this.hashedPassword = hashedPassword;}

    public boolean changePassword(String oldPassword, String newPassword) {
        if (!(hashedPassword.equals(oldPassword))) {return false;}
        this.hashedPassword = newPassword;
        return true;
    }
}
