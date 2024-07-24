package com.accountplace.api.Items;

public abstract class  Account {
    private int id;
    private String username;
    private Email email;

    private void Account() { };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public abstract boolean changePassword(String oldPassword, String newPassword);

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);


}
