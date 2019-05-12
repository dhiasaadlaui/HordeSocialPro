/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.ui;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import tn.esprit.gui.home.HomeGUI;
import tn.esprit.gui.home.SideBarBase;
import tn.esprit.gui.items.generic.ItemJobBase;
import tn.esprit.gui.items.generic.ItemReclamationBase;
import tn.esprit.gui.pages.PageCreateClaim;
import tn.esprit.gui.pages.PageJobsBase;

/**
 *
 * @author Dhia
 */
public class DhiaApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        //--------initialisation-----------
        Button btn = new Button("print");
        VBox vb = new VBox();
        vb.setSpacing(50);
        vb.getChildren().addAll(btn,new ItemReclamationBase() {
        }, new ItemReclamationBase() {
        }, new ItemReclamationBase() {
        });

           btn.setOnMouseClicked(e -> {
            PrinterJob job = PrinterJob.createPrinterJob();
            if (job != null) {
                job.showPrintDialog(primaryStage); // Window must be your main Stage
                job.printPage(vb);
                job.endJob();
            }
        });
        
        Scene GLOBAL_SCENE = new Scene(vb);

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
