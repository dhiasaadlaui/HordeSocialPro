/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.ui;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;
import tn.esprit.gui.pages.PageAdminProcessJobs;
import tn.esprit.gui.pages.PageCreateJob;

import tn.esprit.gui.pages.PageJobsBase;

/**
 *
 * @author Dhia
 */
public class DhiaApp extends Application {

    public DhiaApp() {
    }

    @Override
    public void start(Stage primaryStage) {
        //--------initialisation-----------

        PageAdminProcessJobs main = new PageAdminProcessJobs();

        Scene GLOBAL_SCENE = new Scene(new PageCreateJob());

        //-----------styling----------------
        //------------logic-----------------
        primaryStage.setScene(GLOBAL_SCENE);
        primaryStage.show();

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
