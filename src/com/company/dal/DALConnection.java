package com.company.dal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DALConnection {

    private Connection connection;
    private static DALConnection dalConnection;
    private static final String configName = "db.properties";

    private DALConnection(){};

    public static DALConnection getInstance() {
        if (dalConnection == null)
            dalConnection = new DALConnection();

        return dalConnection;
    }

    public boolean connect() throws SQLException, FileNotFoundException, IOException {
        if (connection == null) {
            Properties props = new Properties();
            props.load(new FileInputStream(DALConnection.configName));
            connection = DriverManager.getConnection(props.getProperty("DB_URL"),
                    props.getProperty("DB_USERNAME"),
                    props.getProperty("DB_PASSWORD"));
        }

        return true;
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        }
        catch (SQLException ex) {
        }
    }
}
