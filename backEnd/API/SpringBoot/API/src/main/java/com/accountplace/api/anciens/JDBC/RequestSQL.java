package com.accountplace.api.anciens.JDBC;


import com.accountplace.api.dto.EmailDto;
import com.accountplace.api.dto.Privilege;
import com.accountplace.api.anciens.items.UserAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class RequestSQL {
    ConnexionDB thisConn;
    Statement stmt;

    public RequestSQL(ConnexionDB con) throws SQLException {this.thisConn = con;}

    public void insertAccountPlateforme(String name, String url, String imgRef) throws SQLException {
        String request = "INSERT INTO PLATEFORME VALUES (?,?,?,?)";
        PreparedStatement stmt = this.thisConn.prepareStatement(request);
        stmt.setInt(1, 1);
        stmt.setString(2, name);
        stmt.setString(3, url);
        stmt.setString(4, imgRef);
        stmt.executeUpdate();
    }

    public UserAccount getUserAccount(EmailDto mail) throws Exception {
        String request =  "SELECT * FROM ACCOUNT WHERE mail=?";
        PreparedStatement stmt = this.thisConn.prepareStatement(request);
        stmt.setString(1, mail.toString());
        ResultSet res = stmt.executeQuery();
        UserAccount acc = null;
        while (res.next()) {
            Privilege priv = Privilege.USER;
           if (res.getString("privilges").equals(Privilege.ADMIN.getPrivilege())) {
               priv = Privilege.ADMIN;
           }
           acc = new UserAccount(
                   res.getInt("id"),
                   res.getString("username"),
                   mail,
                   res.getString("password"),
                   priv
           );
       }
        if (acc != null) {return acc;}
        else {throw new Exception("No account");}
    }

}
