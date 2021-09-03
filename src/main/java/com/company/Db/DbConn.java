package com.company.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/hospital", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
