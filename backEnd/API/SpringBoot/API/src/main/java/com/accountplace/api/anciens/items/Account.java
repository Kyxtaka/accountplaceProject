package com.accountplace.api.anciens.items;

import com.accountplace.api.dto.EmailDto;

public abstract class  Account {
    protected int id;
    protected String username;
    protected EmailDto email;

    private void Account() {};

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}
    public EmailDto getEmail() {return email;}
    public void setEmail(EmailDto email) {this.email = email;}

    public abstract boolean changePassword(String oldPassword, String newPassword);

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);


}
