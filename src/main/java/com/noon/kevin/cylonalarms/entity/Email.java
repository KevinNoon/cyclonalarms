package com.noon.kevin.cylonalarms.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String emailAddress;
    private String siteName;
    private Integer siteNumber;
    private Integer startPriority;
    private Integer endPriority;

    public Email() {
    }

    public Email(Integer id, String emailAddress, String siteName, Integer siteNumber, Integer startPriority, Integer endPriority) {
        Id = id;
        this.emailAddress = emailAddress;
        this.siteName = siteName;
        this.siteNumber = siteNumber;
        this.startPriority = startPriority;
        this.endPriority = endPriority;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public Integer getStartPriority() {
        return startPriority;
    }

    public void setStartPriority(Integer startPriority) {
        this.startPriority = startPriority;
    }

    public Integer getEndPriority() {
        return endPriority;
    }

    public void setEndPriority(Integer endPriority) {
        this.endPriority = endPriority;
    }

    @Override
    public String toString() {
        return "Email{" +
                "Id=" + Id +
                ", emailAddress='" + emailAddress + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteNumber=" + siteNumber +
                ", startPriority=" + startPriority +
                ", endPriority=" + endPriority +
                '}';
    }
}
