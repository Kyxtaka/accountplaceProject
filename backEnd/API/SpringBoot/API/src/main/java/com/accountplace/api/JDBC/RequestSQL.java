package com.accountplace.api.JDBC;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RequestSQL {
    ConnexionDB thisConn;
    Statement stmt;

    public RequestSQL(ConnexionDB thisConn) throws SQLException {
        this.thisConn = thisConn;
    }

    public void insertAccountPlateforme(String name, String url, String imgRef) throws SQLException {}; {
        String request = "INSERT INTO PLATEFORME VALUES (?,?,?,?)";
        PreparedStatement stmt = this.thisConn.prepareStatement(request);
        String name="";
        String url="";
        String imgRef="";
        stmt.setInt(1, 1);
        stmt.setString(2, name);
        stmt.setString(3, url);
        stmt.setString(4, imgRef);
        stmt.executeUpdate();
    }
}
