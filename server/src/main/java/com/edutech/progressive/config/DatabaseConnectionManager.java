package com.edutech.progressive.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final String PROPERTIES_FILE = "application.properties";
    private static final Properties properties = new Properties();
    static {
        try (InputStream in = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (in == null) {
                throw new RuntimeException("Cannot find " + PROPERTIES_FILE + " in classpath");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        try {
            String url = properties.getProperty("spring.datasoure.url");
            String username = properties.getProperty("spring.datasoure.username");
            String password = properties.getProperty("spring.datasoure.password");
            String driverClass = properties.getProperty("spring.datasoure.driver-class-name");
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DB Connection", e);
        }
    }
}
