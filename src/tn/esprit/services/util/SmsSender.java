/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services.util;
import com.teknikindustries.bulksms.SMS;

/**
 *
 * @author Alai Zid
 */
public class SmsSender {
    
    
    String number;
    String societeName;
    
   /* public static void main(String[] args) 
    {
        SMS smsSender = new SMS();
        smsSender.SendSMS("alaizid","SHIPPUDEN22", "votre message est bien enregisté", "+21652386962", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
        
    }*/
    public void SmsSender(String societeName, String number)
    {
        SMS smsSender = new SMS();
        smsSender.SendSMS("alaizid","SHIPPUDEN22", "la spocieté" +societeName+ "vient d'ajouter une nouvel publication", number, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
        
    }
}
