package com.hand.ln.jdbc.template;

import java.util.Properties;

public class PropertiesUtil {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(Properties.class.getResourceAsStream("/jdbc.properties"));
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
