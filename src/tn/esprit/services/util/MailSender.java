/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Alai Zid
 */
public class MailSender {
    public static void SendEmail(String recepient) throws Exception {
       
    
    Properties properties =new Properties();
    
    
  properties.put("mail.smtp.auth","true");
  properties.put("mail.smtp.starttls.enable","true");
  properties.put("mail.smtp.host","smtp.gmail.com");
  properties.put("mail.smtp.port","578");
  
  String emailAccount ="alai.zid@esprit.tn";
  
  String emailPassWord ="183JMT3397";
  
 Session session =Session.getDefaultInstance(properties,new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
           
       return new PasswordAuthentication(emailAccount,emailPassWord);
        }
     
});
 Message message = prepareMessage(session,emailAccount,recepient);
        Transport.send(message);
 

  
}

    private static Message prepareMessage(Session session, String emailAccount,String recepient) {
        
        
        try {
            Message message =new MimeMessage(session);
            message.setFrom(new InternetAddress(emailAccount) );
            
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("Votre entreprise vien de lancé une demande d'emploi");
            message.setText("working :D");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(MailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /*https://www.youtube.com/watch?v=A7HAB5whD6I*/
}
