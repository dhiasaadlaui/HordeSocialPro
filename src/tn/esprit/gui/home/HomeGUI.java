/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.home;

import HabibGuitest.ItemJob;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import tn.esprit.gui.login.SignupGUI;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author Dhia
 */
public class HomeGUI extends VBox {

    /**
     *
     */
    IServiceJob serviceJob;

    public HomeGUI() {

        // ------------initialisation------------
        serviceJob = new SerivceJobImpl();
        FlowPane flowpane = new FlowPane();

        try {
            List<Job> jobs = serviceJob.findAll();

            for (Job job : jobs) {
                flowpane.getChildren().add(new ItemJob(job) {
                });

            }

            //-------------Styling-------------------
            flowpane.setHgap(10);
            flowpane.setVgap(10);
            

            //-------------logic--------------------
        } catch (DataBaseException ex) {
            Alert errorWindow = new Alert(Alert.AlertType.ERROR);
            errorWindow.setTitle("fail");
            errorWindow.setContentText(ex.getMessage());
        }

        getChildren().add(flowpane);
    }

}
