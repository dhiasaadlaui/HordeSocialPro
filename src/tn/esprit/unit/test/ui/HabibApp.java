/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.ui;

import tn.esprit.gui.login.LoginGUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import tn.esprit.entities.User;

/**
 *
 * @author Dhia
 */
public class HabibApp extends Application {

    /**
     *
     */
    public static User USER_ONLINE = null;

    /**
     *
     */
    public static LoginGUI LOGIN_GUI;

    /**
     *
     */
    public static Scene GLOBAL_SCENE;

    /**
     *
     */
    public static Stage GLOBAL_STAGE;

    /**
     *
     */
    public static BorderPane GLOBAL_PANE_BORDER;

    @Override
    public void start(Stage primaryStage) {
        //--------initialisation-----------
      

        GLOBAL_STAGE = new Stage();
        LOGIN_GUI = new LoginGUI();

        GLOBAL_PANE_BORDER = new BorderPane();
        GLOBAL_SCENE = new Scene(GLOBAL_PANE_BORDER);

        //-----------styling----------------
  
        GLOBAL_PANE_BORDER.setStyle("-fx-background-color: #7f8c8d;");
        GLOBAL_PANE_BORDER.setCenter(LOGIN_GUI);

        //------------logic-----------------
        GLOBAL_STAGE.setScene(GLOBAL_SCENE);
        GLOBAL_STAGE.show();

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
