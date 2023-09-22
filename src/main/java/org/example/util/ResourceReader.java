package org.example.util;

import org.example.exception.DatabaseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ResourceReader {

    private static final String LOCAL_BASE = "src/main/resources/application.properties";
    private static Properties properties;

    public ResourceReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(LOCAL_BASE));
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            throw new DatabaseException("Can't read props for DB");
        }
    }

    public String getDbUser() {
        return properties.getProperty("db.user");
    }

    public String getDbPassword() {
        return properties.getProperty("db.password");
    }

    public String getBdUrl() {
        return properties.getProperty("db.url");
    }
}
