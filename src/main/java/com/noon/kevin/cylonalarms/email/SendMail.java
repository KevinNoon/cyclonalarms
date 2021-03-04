package com.noon.kevin.cylonalarms.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {
        String to = "kevin.noon@ntlworld.com";
        String from = "data@optimisedbuildings.com";
        String username = "data@optimisedbuildings.com";

        String password = "Gog69010";
        String host = "smtp.office365.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.office365.com");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setSubject("Test");
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            message.setText("message");
            Transport.send(message);
            System.out.println("Message sent");
        } catch (MessagingException e){
            System.out.println(e.toString());
        }
    }
}
