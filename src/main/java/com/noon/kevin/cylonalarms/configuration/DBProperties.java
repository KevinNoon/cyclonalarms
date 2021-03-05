package com.noon.kevin.cylonalarms.configuration;


import java.io.*;
import java.util.Properties;

public class DBProperties {
    public static String getProperties(String property) {
        try (
                InputStream inputStream = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            if (inputStream == null) {
                System.out.println("Config.Properties file not found");
                return null;
            }
            properties.load(inputStream);
            return (String) properties.get(property);
        } catch (IOException e) {
        }
        return null;
    }

    public static void setAlarmIndex(String property,String value){
        try (OutputStream outputStream = new FileOutputStream("alarmLastIndex.properties")) {
            Properties properties = new Properties();
            properties.setProperty(property,value);
            properties.store(outputStream,null);
        }catch (IOException io){
        }
    }
    public static Long getAlarmIndex() {
        try (
                InputStream inputStream = new FileInputStream("alarmLastIndex.properties")) {
            Properties properties = new Properties();
            if (inputStream == null) {
                System.out.println("Config.Properties file not found");
                return null;
            }
            properties.load(inputStream);
            return (Long.parseLong((String) properties.get("alarm.lastIndex")));
        } catch (IOException e) {
        }
        return 0l;
    }

}