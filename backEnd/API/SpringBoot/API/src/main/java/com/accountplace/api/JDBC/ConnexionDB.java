package com.accountplace.api.JDBC;

import java.sql.*;
import java.util.Properties;

public class ConnexionDB {
    private Connection conn;
    private boolean connected = false;

    //
    public ConnexionDB() throws ClassNotFoundException {
        this.connected = false;
        this.conn = null;
        Class.forName("org.postgresql.Driver");
    }

    //DB connection Init
    public void getConnection(String host, int port, String database, String userName, String password) throws SQLException {
        this.connected = false;
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        Properties props = new Properties();
        props.setProperty("user", userName);
        props.setProperty("password", password);
        //props.setProperty("ssl", "true");
        this.conn = DriverManager.getConnection(url, props);
        this.connected = true;
    }

    /**
     * Return le status de la connection a la BD
     * @return boolean true or False
     */
    public boolean isConnected() {
        return this.connected;
    }

    /**
     * Ferme le connection a la BD
     * @throws SQLException Exception
     */
    public void close() throws SQLException {
        this.conn.close();
        this.connected = false;
    }

    /**
     * Permet d'initialiser un Statement
     * @return Un Statement
     * @throws SQLException Exception
     */
    public Statement createStatement() throws SQLException {
        return this.conn.createStatement();
    }

    /**
     *
     * @param request Requete prepare
     * @return un Prepared Statement
     * @throws SQLException Exception
     */
    public PreparedStatement prepareStatement(String request) throws SQLException{
        return this.conn.prepareStatement(request);
    }
}
