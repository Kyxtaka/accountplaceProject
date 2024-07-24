package com.accountplace.api.others;

import com.accountplace.api.Items.Email;
import com.accountplace.api.Items.UserAccount;
import com.accountplace.api.JDBC.RequestSQL;
import com.accountplace.api.JDBC.ConnexionDB;

import java.sql.SQLException;

public class ExecTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        Email testE = new Email("akiizsan@gmail.com");
        ConnexionDB laConn = new ConnexionDB();
        laConn.getConnection(
                "localhost",
                5432,
                "accountplace",
                "appsuperuser",
                "@dmIn"
        );
        System.out.println(laConn.isConnected());
        RequestSQL dbAPI = new RequestSQL(laConn);
        UserAccount testUser =  dbAPI.getUserAccount(null,testE);
    }
}
