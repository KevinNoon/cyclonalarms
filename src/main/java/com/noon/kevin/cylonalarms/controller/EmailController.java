package com.noon.kevin.cylonalarms.controller;

import com.noon.kevin.cylonalarms.entity.Alarm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailController {

    public static List<Alarm> siteAlarms(List<Alarm> alarms,String siteName){
        List<Alarm> site = alarms.stream().filter(alarm -> siteName.equals(alarm.getSiteName())).collect(Collectors.toList());
        return site;
    }

    public static List<Alarm> siteAlarms(List<Alarm> alarms, Integer alarmSite){
        List<Alarm> siteNumber = alarms.stream().
                filter(alarm -> alarm.getSiteNumber() == alarmSite).
                collect(Collectors.toList());
        return siteNumber;
    }

    public static List<Alarm> priorityAlarms(List<Alarm> alarms, Integer alarmPriorityLow,Integer alarmPriorityHi){
        List<Alarm> priority = alarms.stream().
                filter(alarm -> alarm.getPriority() >= alarmPriorityLow).
                filter(alarm -> alarm.getPriority() <= alarmPriorityHi).
                collect(Collectors.toList());
        return priority;
    }

    public static String formatText(Alarm alarm){
        String sitePriority = alarm.getSiteName() + "\tPriority : " + alarm.getPriority();
        String ucc4ucc16 = "UCC4 name : " + alarm.getNetCtrlName() + " UCC16 name : " + alarm.getSubNetName();
        String point = "Point : " + alarm.getPointName();
        if (alarm.getPointType() == 0)
        {
            point = point + " : " + alarm.getPointUnit();
        }else
            {
            point = point + " : " + alarm.getPointValue();
        }
        String message = "Message : " + alarm.getAlarmMessage();
        String times = "Start time : " + alarm.getStartTime() + "\tEnd time : " + alarm.getEndTime();
        String acknowledged = "Acknowledge by : " + alarm.getAcknowledgedBy() + "\t at : " + alarm.getAcknowledgedAt();

        String alarmBody = sitePriority + "\n\r" + ucc4ucc16 + "\n\r" + point + "\n\r" + message + "\n\r" + times + "\n\r" + acknowledged;
        return alarmBody + "\n-----------------------------------------------------\n\n";
    }
}
