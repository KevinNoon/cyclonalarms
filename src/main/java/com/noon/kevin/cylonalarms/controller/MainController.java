package com.noon.kevin.cylonalarms.controller;

import com.noon.kevin.cylonalarms.data.SQLDatabaseConnection;
import com.noon.kevin.cylonalarms.email.SendMail;
import com.noon.kevin.cylonalarms.entity.Alarm;

import java.util.Collections;
import java.util.List;

import static com.noon.kevin.cylonalarms.configuration.DBProperties.getAlarmIndex;
import static com.noon.kevin.cylonalarms.configuration.DBProperties.setAlarmIndex;
import static com.noon.kevin.cylonalarms.controller.EmailController.formatText;
import static com.noon.kevin.cylonalarms.data.SQLDatabaseConnection.getAlarms;

public class MainController {
    private static long lastIndex =  getAlarmIndex();
    public static void main(String[] args) {

        String alarmBody = "";
        List<Alarm> alarms = getAlarms(lastIndex + 1);
        Collections.sort(alarms);

        System.out.println(EmailController.siteAlarms(alarms,"Test"));

        List<Alarm> Salarms = EmailController.siteAlarms(alarms,36);//EmailController.siteAlarms(alarms,"Primark Bur on Tre");

        List<Alarm> Palarms = EmailController.priorityAlarms(Salarms,1,31);

        for (Alarm alarm:Palarms) {
            String formattedAlarm = formatText(alarm);
            alarmBody = alarmBody + formattedAlarm;
        }
        System.out.println(alarmBody);
        if (alarms.size() > 0){
        System.out.println(alarms.get(alarms.size()-1));


    //////        SendMail.sendMail( alarmBody);
            if (lastIndex != alarms.get(alarms.size()-1).getAlarmID()){
                lastIndex = alarms.get(alarms.size()-1).getAlarmID();
        //        setAlarmIndex("alarm.lastIndex",""+lastIndex);
                System.out.println(lastIndex);
            }
        }
    }
}
