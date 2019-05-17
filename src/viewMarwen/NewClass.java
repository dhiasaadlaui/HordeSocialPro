/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewMarwen;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import tn.esprit.services.util.ServiceMail;

/**
 *
 * @author mghozzi
 */
public class NewClass {
     
    
    
    public static void main(String[] args) throws AddressException, MessagingException {
//        SendMailWithAttachments s = new SendMailWithAttachments() ;
//        s.send();
//  

        ServiceMail.sendMailWithFile("marouen.ghozzi@esprit.tn", "test", new File("C:/Users/mghozzi/Desktop/plll.pdf"));
    }
}
