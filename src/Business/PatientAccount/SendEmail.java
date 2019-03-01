/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientAccount;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 *
 * @author Srikanth Reddy
 */
public class SendEmail {
    
    
    final String senderEmailID;
    final String senderPassword;
    final String emailSMTPserver = "smtp.gmail.com";
    final String emailServerPort = "465";
    String receiverEmailID = null;
    static String emailSubject = "Test Mail";
    static String emailBody = ":)";
    
    public SendEmail(String senderEmailID,String senderPassword,String receiverEmailID,String Subject,String Body){
   
        this.senderEmailID = senderEmailID;
        this.senderPassword = senderPassword;
        // Receiver Email Address
        this.receiverEmailID=receiverEmailID; 
        // Subject
        this.emailSubject=Subject;
        // Body
        this.emailBody=Body;
        Properties props = new Properties();
        props.put("mail.smtp.user",senderEmailID);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SecurityManager security = System.getSecurityManager();
        try{  
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, new GMailAuthenticator(senderEmailID, senderPassword));
            MimeMessage msg = new MimeMessage(session);
            msg.setText(emailBody);
            msg.setSubject(emailSubject);
            msg.setFrom(new InternetAddress(senderEmailID));
            msg.addRecipient(Message.RecipientType.TO,
            new InternetAddress(receiverEmailID));
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com" , 465 , senderEmailID, senderPassword);
            transport.send(msg);
            System.out.println("Message send Successfully:)"); 
        }

        catch (Exception mex){
            mex.printStackTrace();
            return;
        }

    }

        public SendEmail(String senderEmailID,String senderPassword,String receiverEmailID,String Subject,String Body,String fileName){
   
        this.senderEmailID = senderEmailID;
        this.senderPassword = senderPassword;
        // Receiver Email Address
        this.receiverEmailID=receiverEmailID; 
        // Subject
        this.emailSubject=Subject;
        // Body
        this.emailBody=Body;
        Properties props = new Properties();
        props.put("mail.smtp.user",senderEmailID);
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", emailServerPort);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        SecurityManager security = System.getSecurityManager();
        try{  
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, new GMailAuthenticator(senderEmailID, senderPassword));
            MimeMessage msg = new MimeMessage(session);
            //msg.setText(emailBody);
            msg.setSubject(emailSubject);
            msg.setFrom(new InternetAddress(senderEmailID));
            msg.addRecipient(Message.RecipientType.TO,
            new InternetAddress(receiverEmailID));
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(emailBody);
            Multipart multiPart = new MimeMultipart();
            multiPart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String filename1 = fileName;
            DataSource dataSource = new FileDataSource(filename1);
            messageBodyPart.setDataHandler(new DataHandler(dataSource));
            messageBodyPart.setFileName(filename1);
            multiPart.addBodyPart(messageBodyPart);
            msg.setContent(multiPart);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com" , 465 , senderEmailID, senderPassword);
            transport.send(msg);
            System.out.println("Message send Successfully:)"); 
        }

        catch (MessagingException mex){
            mex.printStackTrace();
            return;
        }

    }

    public class SMTPAuthenticator extends javax.mail.Authenticator{
        public PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication(senderEmailID, senderPassword);
        }
    }
    
}
