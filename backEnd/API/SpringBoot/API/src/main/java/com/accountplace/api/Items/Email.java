package com.accountplace.api.Items;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    String mailAddress;

    public Email(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public boolean isValid() {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(this.mailAddress);
        return m.matches();
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public int hashCode() {
        return this.mailAddress.hashCode();
    }

    @Override
    public String toString() {
        return mailAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Email)) return false;
        return this.mailAddress.equals(((Email)obj).mailAddress);
    }
}
