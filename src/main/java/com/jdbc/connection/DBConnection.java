package com.jdbc.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private String url;
    private String user;
    private String password;

    private Connection connection;

    public Connection getConnection() {
        loadConnectionProperties();
        connect();
        return connection;
    }

    private void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                System.out.println("Successful connection to DB");
            }
        } catch (SQLException e) {
            System.out.println("Exception while getting connection to db");
        }
    }
    private void loadConnectionProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/db-connection.properties"));
            url = properties.getProperty("DB_URL");
            user = properties.getProperty("USER");
            password = properties.getProperty("PASSWORD");
            //System.out.println(url + "\n" + user + "\n" + password);
        } catch (IOException e) {
            System.out.println("Exception while getting db connection properties from file" +  e);
        }

    }
}
