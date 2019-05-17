/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Notification;

/**
 *
 * @author Mehdi Sarray
 */
public class ListViewCell extends ListCell<Notification> {
    
    
    @Override
    public void updateItem(Notification string, boolean empty){
        super.updateItem(string,empty);
        if(string != null)
        {
            Data data = new Data();
             setGraphic(data.getBox(string));
            
           
        }

    }
  
    
}
