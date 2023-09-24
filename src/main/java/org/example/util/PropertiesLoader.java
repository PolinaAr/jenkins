package org.example.util;

import java.io.IOException;
import java.io.InputStream;
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

    public String getProperty(String key){
        return loadProperties().getProperty(key);
    }
}