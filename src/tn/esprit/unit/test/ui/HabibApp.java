/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.ui;

import HabibGuitest.CountdonwJob;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.tools.Helper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.esprit.gui.login.LoginGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import tn.esprit.entities.Job;

import tn.esprit.entities.User;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author Dhia
 */
public class HabibApp extends Application {

    /**
     *
     */
    @Override
    public void start(Stage primaryStage) {
        //--------initialisation-----------
        String pattern = "yyyy-MM-dd";
        IServiceJob serviceJob;
        serviceJob = new SerivceJobImpl();

        Job job;
        try {
            job = serviceJob.findByID(1);

         

              CountdonwJob countdonwJob = new CountdonwJob(job.getExpireDate());
              Scene scene = new Scene(countdonwJob);
            primaryStage.setScene(scene);
             primaryStage.show();
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(HabibApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stop() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
