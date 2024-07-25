package com.accountplace.api.Items;

public class SharedAccount extends Account {
    private String encryptedPassword;
    private String DecryptedPassword;
    private boolean A2F;

    public SharedAccount(int id, Email email, String username, String password, String encryptedPassword, boolean A2F) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.DecryptedPassword = "Hidden";
        this.A2F = A2F;
    }

    public String getEncryptedPassword() {return encryptedPassword;}
    public boolean getA2F() {return A2F;}

    public String getDecryptedPassword() {
        return DecryptedPassword;
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
