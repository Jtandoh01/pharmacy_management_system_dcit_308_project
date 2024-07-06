package com.pharmacy.utils;

import io.github.cdimascio.dotenv.Dotenv;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

public class Database {
    private static HikariDataSource dataSource;
    //private static Connection connection;
    private static Dotenv dotenv = Dotenv.load();

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dotenv.get("DB_URL"));
        config.setUsername(dotenv.get("DB_USER"));
        config.setPassword(dotenv.get("DB_PASSWORD"));
        config.setMaximumPoolSize(10);
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }


    // public static Connection getConnection() {
    //     if (connection == null) {
    //         try {
    //             String url = dotenv.get("DB_URL");
    //             String user = dotenv.get("DB_USER");
    //             String password = dotenv.get("DB_PASSWORD");
    //             connection = DriverManager.getConnection(url, user, password);
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return connection;
    // }
}
