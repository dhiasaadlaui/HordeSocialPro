/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Dhia
 */
public class ServiceMail {

    /**
     *
     */
    private static final String FROM = "hordesocialho@gmail.com";

    /**
     *
     */
    private static final String PASSWORD = "dhiasaadlaui";

    /**
     *
     * @param toMail
     * @param subject
     * @param message
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendMail(
            String toMail, String subject, String message) throws AddressException, MessagingException {

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getDefaultInstance(props, null);
        
        //enable the comment below to activate console debug
       // mailSession.setDebug(true);

        Message mailMessage = new MimeMessage(mailSession);

        mailMessage.setFrom(new InternetAddress(FROM));
        mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
        mailMessage.setContent(message, "text/html; charset=utf-8");
        mailMessage.setSubject(subject);
        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", FROM, PASSWORD);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

    }
    
    /**
     *
     * @param adresses
     * @param subject
     * @param message
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendMailToAll(
            String[] adresses, String subject, String message) throws AddressException, MessagingException {

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session mailSession = Session.getDefaultInstance(props, null);
        
        //enable the comment below to activate console debug
       // mailSession.setDebug(true);

        Message mailMessage = new MimeMessage(mailSession);

        mailMessage.setFrom(new InternetAddress(FROM));
            for (String adresse : adresses) {
                mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(adresse));
            }
    
        mailMessage.setContent(message, "text/html; charset=utf-8");
        mailMessage.setSubject(subject);
        Transport transport = mailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", FROM, PASSWORD);
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());

    }
    
    

}
