package com.noon.kevin.cylonalarms.controller;

import com.noon.kevin.cylonalarms.entity.Alarm;

public class EmailController {
    public static void main(String[] args) {

    }
    private static String formatText(Alarm alarm){
        String alarmBody = "";
        switch (alarm.getAlarmType()) {
            case 1:
                alarmBody = alarmBody +
        }
        return "";
    }
}
