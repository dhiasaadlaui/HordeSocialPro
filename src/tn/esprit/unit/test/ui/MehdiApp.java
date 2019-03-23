package tn.esprit.unit.test.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import tn.esprit.gui.login.LoginGUI;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

import tn.esprit.entities.User;

/**
 *
 * @author Dhia
 */
public class MehdiApp extends Application {

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
