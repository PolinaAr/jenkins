package org.example.util;

import org.example.exception.DatabaseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {

    public Properties loadProperties() {
        Properties properties = new Properties();
        ClassLoader classLoader = getClass().getClassLoader();
        String pathToProperties = "application.properties";

        try (InputStream inputStream = classLoader.getResourceAsStream(pathToProperties)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.err.println("Файл свойств '" + pathToProperties + "' не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public String getDbUser() {
        return loadProperties().getProperty("db.user");
    }

    public String getDbPassword() {
        return loadProperties().getProperty("db.password");
    }

    public String getDbUrl() {
        return loadProperties().getProperty("db.url");
    }
}