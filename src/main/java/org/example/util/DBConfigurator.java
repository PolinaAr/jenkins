package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigurator {

    private static volatile Connection connection;

    private static PropertiesLoader props = new PropertiesLoader();

    private static String url = props.getProperty("db.url");
    private static String user = props.getProperty("db.user");
    private static String password = props.getProperty("db.password");

//    private static String url = "jdbc:postgresql://192.168.43.142:5432/test";
//    private static String user = "dima";
//    private static String password = "dima";
    public static Connection getConnection (){
        if (connection == null){
            synchronized (DBConfigurator.class){
                if (connection == null){
                    initDbConnection();
                }
            }
        }
        return connection;
    }

    private static void initDbConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
