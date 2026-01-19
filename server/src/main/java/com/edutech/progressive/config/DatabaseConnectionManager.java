package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();
    private static void loadProperties(){
        try (FileInputStream fs = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(fs);
        } catch (Exception e) {
            throw new RuntimeException("Properties file not found or cannot be read", e);
        }
    }
    public static Connection getConnection() {
        try {
            loadProperties();
            String url = properties.getProperty("spring.datasoure.url");
            String username = properties.getProperty("spring.datasoure.username");
            String password = properties.getProperty("spring.datasoure.password");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DB Connection", e);
        }
    }
}