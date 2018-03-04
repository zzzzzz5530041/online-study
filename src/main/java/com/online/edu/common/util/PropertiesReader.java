package com.online.edu.common.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesReader {
    public PropertiesReader() {
    }

    public static String getValue(String file_name, String key) throws MissingResourceException {
        ResourceBundle res = ResourceBundle.getBundle(file_name);
        String value = res.getString(key);
        return value.trim();
    }

    public static Properties fillProperties(String file_name) throws MissingResourceException {
        Properties properties = new Properties();
        ResourceBundle res = ResourceBundle.getBundle(file_name);
        Enumeration<String> en = res.getKeys();
        String key = null;
        String value = null;

        while(en.hasMoreElements()) {
            key = ((String)en.nextElement()).trim();
            value = res.getString(key);
            properties.setProperty(key, value.trim());
        }

        return properties;
    }

    public static void setValue(String file_name, String key, String value) {
        try {
            Properties properties = new Properties();
            PropertiesReader propertiesReader = new PropertiesReader();
            String staticPath = propertiesReader.getClass().getClassLoader().getResource("").getPath();
            if (file_name.indexOf(".properties") < 0) {
                file_name = file_name + ".properties";
            }

            String file_name_path = staticPath + file_name;
            FileInputStream in = new FileInputStream(file_name_path);
            properties.load(in);
            FileOutputStream fis = new FileOutputStream(file_name_path);
            properties.setProperty(key, value);
            properties.store(fis, file_name);
            in.close();
            fis.close();
        } catch (Exception var9) {
            var9.printStackTrace();
            System.exit(0);
        }

    }
}
