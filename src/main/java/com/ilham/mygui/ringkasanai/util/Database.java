package com.ilham.mygui.ringkasanai.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/uas_pbo";
    private static final String USER = "uas_app";
    private static final String PASSWORD = "ilovejava123";

    // buat koneksi
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected.");
            } catch (SQLException e) {
                System.err.println("Database connection failed.");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // tutup koneksi
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
