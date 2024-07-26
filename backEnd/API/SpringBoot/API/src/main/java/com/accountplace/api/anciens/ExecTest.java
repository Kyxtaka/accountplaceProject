package com.accountplace.api.anciens;

import com.accountplace.api.anciens.JDBC.ConnexionDB;
import com.accountplace.api.dto.Email;
import com.accountplace.api.anciens.items.UserAccount;
import com.accountplace.api.anciens.JDBC.RequestSQL;

public class ExecTest {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello World");
        Email testE = new Email("akiizsan@gmail.com");
        Email testE2 = new Email("nathangamersession@gmail.com");
        ConnexionDB laConn = new ConnexionDB();
        laConn.getConnection(
                "localhost",
                5432,
                "accountplace",
                "appsuperuser",
                "@dmIn"
        );
        System.out.println(laConn.isConnected());
        System.out.println(testE);
        RequestSQL dbAPI = new RequestSQL(laConn);
        UserAccount testUser =  dbAPI.getUserAccount(testE);
        UserAccount testUserA = dbAPI.getUserAccount(testE2);
        System.out.println(testUser);
        System.out.println("--------------------------------------------------------");
        System.out.println(testUserA);
    }
}
