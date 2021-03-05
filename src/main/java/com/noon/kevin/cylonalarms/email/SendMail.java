package com.noon.kevin.cylonalarms.email;

import com.noon.kevin.cylonalarms.entity.Alarm;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) {
        sendMail("Test");
    }
    public static void sendMail(String body){
            String to = "kevin.noon@ntlworld.com";
        String from = "data@optimisedbuildings.com";
        String username = "data@optimisedbuildings.com";
        String password = "Optimised1234";
        String host = "smtp.office365.com";

 //       String from = "knoon1959@gmail.com";
 //       String username = "knoon1959@gmail.com";

 //           String password = "Ne108da@";
 //          String host = "smtp.gmail.com";
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
         //   props.put("mail.smtp.port", "587");
            props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.office365.com");
  //      props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
                message.setText(body);
                Transport.send(message);
                System.out.println("Message sent");
            } catch (MessagingException e){
                System.out.println(e.toString());
            }
        }
}
