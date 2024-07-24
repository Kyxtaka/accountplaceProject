package com.accountplace.api.JDBC;


import com.accountplace.api.Items.Email;
import com.accountplace.api.Items.Privilege;
import com.accountplace.api.Items.UserAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class RequestSQL {
    ConnexionDB thisConn;
    Statement stmt;

    public RequestSQL(ConnexionDB con) throws SQLException {
        this.thisConn = con;
    }

    public void insertAccountPlateforme(String name, String url, String imgRef) throws SQLException {
        String request = "INSERT INTO PLATEFORME VALUES (?,?,?,?)";
        PreparedStatement stmt = this.thisConn.prepareStatement(request);
        stmt.setInt(1, 1);
        stmt.setString(2, name);
        stmt.setString(3, url);
        stmt.setString(4, imgRef);
        stmt.executeUpdate();
    }

    private UserAccount createUser(String username, Email mail, UserAccount user, PreparedStatement stmt) throws SQLException {
        stmt.setString(1, username);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            Privilege priv = Privilege.USER;
            if (res.getString("privilges").equals(Privilege.ADMIN.getPrivilege())) {
                priv = Privilege.ADMIN;
            }
            user =  new UserAccount(
                    res.getInt("id"),
                    res.getString("username"),
                    res.getString("password"),
                    mail,
                    priv
            );
        }
        return user;
    }

    public UserAccount getUserAccount(String username, Email mail) throws Exception {
        UserAccount user = null;
        if (!(mail == null)) {
            String request = "SELECT * FROM ACCOUNT WHERE MAIL=?";
            PreparedStatement stmt = this.thisConn.prepareStatement(request);
            String email = mail.getMailAddress();
            user = createUser(email, mail, user, stmt);
        } else {
            String request = "SELECT * FROM ACCOUNT WHERE USERNAME=?";
            PreparedStatement stmt = this.thisConn.prepareStatement(request);
            user = createUser(username, mail, user, stmt);
        }
        if (user == null) {
            throw new Exception();
        }else {
            return user;
        }
    }
}
