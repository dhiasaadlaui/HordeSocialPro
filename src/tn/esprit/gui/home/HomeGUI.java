/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.home;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 *
 * @author Dhia
 */
public class HomeGUI extends VBox {

    /**
     *
     */
    public HomeGUI() {

        // ------------initialisation------------
        Label label1 = new Label();

        //-------------Styling-------------------
        this.getStylesheets().add("/resources/css/theme.css");
        label1.getStyleClass().add("primary");

        //-------------logic--------------------

    }

}
