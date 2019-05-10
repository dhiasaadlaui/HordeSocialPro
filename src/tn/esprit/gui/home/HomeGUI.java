/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.home;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tn.esprit.gui.login.SignupGUI;
import tn.esprit.gui.pages.PageJobsBase;


/**
 *
 * @author Dhia
 */
public class HomeGUI extends HBox {

    /**
     *
     */
    public HomeGUI() {

        // ------------initialisation------------
   
   

        //-------------Styling-------------------
    //    this.getStylesheets().add("/resources/css/theme.css");

        getChildren().add(new SideBarBase() {
});
                getChildren().add(new PageJobsBase() {
}
                );
  
  
        //-------------logic--------------------

    }

}
