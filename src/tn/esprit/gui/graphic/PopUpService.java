/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.graphic;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
/**
 *
 * @author mdsaadlaoui
 */
public class PopUpService {
    
      
    public static void CreatePopup (int number ){
        
        if ( number != 0 ) {
            
            Notifications notif = Notifications.create();
               
            notif.title("Apply Creation");
            notif.text("Apply was created successfully");
            notif.graphic(null);
            notif.position(Pos.TOP_RIGHT);
            notif.darkStyle();
            notif.hideAfter(Duration.seconds(5));
            notif.showInformation();
            
        }
        else {
            Notifications notif = Notifications.create();
               
            notif.title("Apply creation");
            notif.text("Apply creation Failed");
            notif.graphic(null);
            notif.position(Pos.TOP_RIGHT);
            notif.darkStyle();
            notif.hideAfter(Duration.seconds(5));
            notif.showError();
            
        }
        
    }
    
}
