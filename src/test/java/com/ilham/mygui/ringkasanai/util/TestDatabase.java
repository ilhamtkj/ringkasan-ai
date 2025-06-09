package com.ilham.mygui.ringkasanai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabase {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/uas_pbo_test", "uas_app_test", "test123"
        );
    }
}
