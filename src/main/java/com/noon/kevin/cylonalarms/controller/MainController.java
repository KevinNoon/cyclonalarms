package com.noon.kevin.cylonalarms.controller;

import com.noon.kevin.cylonalarms.data.SQLDatabaseConnection;
import com.noon.kevin.cylonalarms.entity.Alarm;

import java.util.Collections;
import java.util.List;

import static com.noon.kevin.cylonalarms.configuration.DBProperties.getAlarmIndex;
import static com.noon.kevin.cylonalarms.configuration.DBProperties.setAlarmIndex;
import static com.noon.kevin.cylonalarms.data.SQLDatabaseConnection.getAlarms;

public class MainController {
    private static long lastIndex =  getAlarmIndex();
    public static void main(String[] args) {
        System.out.println(lastIndex);
        List<Alarm> alarms = getAlarms(lastIndex + 1);
        Collections.sort(alarms);
        if (alarms.size() > 0){
        System.out.println(alarms.get(alarms.size()-1));
            if (lastIndex != alarms.get(alarms.size()-1).getAlarmID()){
                lastIndex = alarms.get(alarms.size()-1).getAlarmID();
                setAlarmIndex("alarm.lastIndex",""+lastIndex);
                System.out.println(lastIndex);
            }
        }
    }
}
