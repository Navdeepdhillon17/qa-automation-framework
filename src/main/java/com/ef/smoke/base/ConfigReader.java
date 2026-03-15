package com.ef.smoke.base;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties prop;

    public ConfigReader() {
//        try{
//            FileInputStream fis = new FileInputStream("config.properties");
//        } catch (FileNotFoundException e) {
//            System.out.println("Configuration file not found: " + e.getMessage());
//        }
        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties not found on classpath");
            }

            prop = new Properties();
            prop.load(is);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties: " + e.getMessage(), e);
        }
    }
    public String getProperty(String key) {
        return prop.getProperty(key);
    }
}
