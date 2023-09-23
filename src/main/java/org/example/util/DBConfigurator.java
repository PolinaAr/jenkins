package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigurator {

    private static volatile Connection connection;
//    private static ResourceReader reader = new ResourceReader();
//    private static String url = reader.getDbUrl();
//    private static String user = reader.getDbUser();
//    private static String password = reader.getDbPassword();

    private static String url = "jdbc:postgresql://127.0.0.1:5432/andersen";
    private static String user = "postgres";
    private static String password = "root";
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
