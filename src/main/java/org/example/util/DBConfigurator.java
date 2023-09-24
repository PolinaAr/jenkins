package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigurator {

    private static volatile Connection connection;

    private static final PropertiesLoader props = new PropertiesLoader();

    private static final String url = props.getProperty("db.url");
    private static final String user = props.getProperty("db.user");
    private static final String password = props.getProperty("db.password");

//    private static String url = "jdbc:postgresql://192.168.0.106:5432/andersen";
//    private static String user = "andersen";
//    private static String password = "andersen";
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
