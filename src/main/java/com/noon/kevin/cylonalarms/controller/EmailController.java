package com.noon.kevin.cylonalarms.controller;

import com.noon.kevin.cylonalarms.entity.Alarm;

public class EmailController {
    public static String formatText(Alarm alarm){
        String sitePriority = alarm.getSiteName() + "\tPriority : " + alarm.getPriority();
        String ucc4ucc16 = "UCC4 name : " + alarm.getNetCtrlName() + " UCC16 name : " + alarm.getSubNetName();
        String point = "Point : " + alarm.getPointName();
        if (alarm.getPointType() == 0) {point = point + alarm.getPointUnit();}else{
            point = point + alarm.getPointValue();
        }
        String message = "Message : " + alarm.getAlarmMessage();
        String times = "Start time : " + alarm.getStartTime() + "\tEnd time : " + alarm.getEndTime();
        String acknowledged = "Acknowledge by : " + alarm.getAcknowledgedBy() + "\t at : " + alarm.getAcknowledgedAt();

        String alarmBody = sitePriority + "\n" + ucc4ucc16 + "\n" + point + "\n" + message + "\n" + times + "\n" + acknowledged;
        return alarmBody;
    }
}
