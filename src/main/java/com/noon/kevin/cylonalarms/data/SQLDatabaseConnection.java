package com.noon.kevin.cylonalarms.data;

import com.noon.kevin.cylonalarms.entity.Alarm;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.noon.kevin.cylonalarms.configuration.DBProperties.getProperties;


public class SQLDatabaseConnection {

    public static List<Alarm> getAlarms(){
        String getAll = "SELECT * FROM dbo.Alarm";
        return getAlarms(getAll);
    }
    public static List<Alarm> getAlarms(Long startIndex){
        System.out.println(startIndex);
        String getFromIndex = "SELECT * FROM dbo.Alarm WHERE AlarmID >= " + startIndex;
        return getAlarms(getFromIndex);
    }

    private static List<Alarm> getAlarms(String query){
        String dbURL = getProperties("db.ServerURL");
        String dbUser = getProperties("db.user");
        String dbPassword = getProperties("db.password");
        String connectionUrl =
                "jdbc:sqlserver:"+ dbURL + ";"
                        + "database=WN3000SL;"
                        + "user=" + dbUser + ";"
                        + "password=" + dbPassword + ";"
                        + "encrypt=false;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";


        ResultSet resultSet = null;
        List<Alarm> alarms = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(connectionUrl);Statement
                statement = connection.createStatement();) {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Alarm alarm = new Alarm();
                alarm.setAlarmID(resultSet.getLong("AlarmID"));
                alarm.setSiteName(resultSet.getString("SiteName"));
                alarm.setNetCtrlName(resultSet.getString("Ucc4Name"));
                alarm.setSubNetName(resultSet.getString("UC16Name"));
                alarm.setPriority(resultSet.getInt("Priority"));
                alarm.setStartTime(strToDate(resultSet.getString("StartedAt")));
                alarm.setEndTime(strToDate(resultSet.getString("EndedAt")));
                alarm.setAlarmType(resultSet.getInt("AlarmType"));
                alarm.setPointName(resultSet.getString("TriggerPointName"));
                alarm.setPointValue(resultSet.getDouble("TriggerPointValue"));
                alarm.setPointUnit(resultSet.getString("TriggerPointUnit"));
                alarm.setAlarmMessage(resultSet.getString("AlarmMessage"));
                alarm.setAcknowledgedBy(resultSet.getString("AcknowledgedBy"));
                alarm.setAcknowledgedAt(strToDate(resultSet.getString("AcknowledgedAt")));
                alarm.setAlarmCount(resultSet.getInt("ExtraInteger"));
                alarms.add(alarm);
            }
            return alarms;
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
        return alarms;
        }

    static LocalDateTime strToDate(String dateTimeStr){
        if (dateTimeStr != null) {
            String dateTimeStrFormat = dateTimeStr.substring(0, 19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStrFormat, formatter);
        return dateTime;
    } else {
        return null;}
    }
}
