package com.noon.kevin.cylonalarms.entity;

import java.time.LocalDateTime;

public class Alarm implements Comparable{
    private Long alarmID;
    private String siteName;
    private Integer siteNumber;
    private String netCtrlName;
    private String subNetName;
    private Integer priority;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer alarmType;
    private String pointName;
    private Integer pointType;
    private Double pointValue;
    private String pointUnit;
    private String alarmMessage;
    private String acknowledgedBy;
    private LocalDateTime acknowledgedAt;
    private Integer alarmCount;

    public Alarm() {
    }

    @Override
    public int compareTo(Object alarmCmp) {
        long compareIndex = ((Alarm)alarmCmp).getAlarmID();
        if (compareIndex == this.alarmID) return 0;
        if (compareIndex <= compareIndex) return 1;
        return -1;
    }

    public Long getAlarmID() {
        return alarmID;
    }

    public void setAlarmID(Long alarmID) {
        this.alarmID = alarmID;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public Integer getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(Integer siteNumber) {
        this.siteNumber = siteNumber;
    }

    public String getNetCtrlName() {
        return netCtrlName;
    }

    public void setNetCtrlName(String netCtrlName) {
        this.netCtrlName = netCtrlName;
    }

    public String getSubNetName() {
        return subNetName;
    }

    public void setSubNetName(String subNetName) {
        this.subNetName = subNetName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public Double getPointValue() {
        return pointValue;
    }

    public Integer getPointType() {
        return pointType;
    }

    public void setPointType(Integer pointType) {
        this.pointType = pointType;
    }

    public void setPointValue(Double pointValue) {
        this.pointValue = pointValue;
    }

    public String getPointUnit() {
        return pointUnit;
    }

    public void setPointUnit(String pointUnit) {
        this.pointUnit = pointUnit;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public String getAcknowledgedBy() {
        return acknowledgedBy;
    }

    public void setAcknowledgedBy(String acknowledgedBy) {
        this.acknowledgedBy = acknowledgedBy;
    }

    public LocalDateTime getAcknowledgedAt() {
        return acknowledgedAt;
    }

    public void setAcknowledgedAt(LocalDateTime acknowledgedAt) {
        this.acknowledgedAt = acknowledgedAt;
    }

    public Integer getAlarmCount() {
        return alarmCount;
    }

    public void setAlarmCount(Integer alarmCount) {
        this.alarmCount = alarmCount;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "AlarmID='" + alarmID + '\'' +
                ", siteName='" + siteName + '\'' +
                ", netCtrlName='" + netCtrlName + '\'' +
                ", subNetName='" + subNetName + '\'' +
                ", priority=" + priority +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", alarmType=" + alarmType +
                ", pointName='" + pointName + '\'' +
                ", pointValue=" + pointValue +
                ", pointUnit='" + pointUnit + '\'' +
                ", alarmMessage='" + alarmMessage + '\'' +
                ", acknowledgedBy='" + acknowledgedBy + '\'' +
                ", acknowledgedAt=" + acknowledgedAt +
                ", alarmCount=" + alarmCount +
                '}';
    }

  }
