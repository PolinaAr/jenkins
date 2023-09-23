package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PropertiesLoader {
    private Map<String, String> properties = new HashMap<>();

    public PropertiesLoader() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\Study\\andersen\\database\\jenkins\\src\\main\\resources\\application.properties"));
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split("=");
                properties.put(split[0], split[1]);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getProperty(String key){
        return properties.get(key);
    }
}