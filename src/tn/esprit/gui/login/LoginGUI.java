/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import static tn.esprit.gui.login.LanguageToolBar.BUNDLE;
import tn.esprit.gui.launch.App;

import tn.esprit.gui.home.HomeGUI;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author Dhia
 */
public class LoginGUI extends HBox {

    /**
     *
     */
    public static Button BTN_LOGIN;

    /**
     *
     */
    public static TextField TXT_USER;

    /**
     *
     */
    public static PasswordField TXT_PASSWORD;

    /**
     *
     */
    public static LanguageToolBar LANGUAGE_BOX;

    /**
     *
     */
    public LoginGUI() {

        // ------------initialisation------------
        IServiceUser serviceUser = new ServiceUserImpl();
        BTN_LOGIN = new Button(LanguageToolBar.BUNDLE.getString("login"));
        TXT_USER = new TextField();
        TXT_PASSWORD = new PasswordField();
        LANGUAGE_BOX = new LanguageToolBar();
        VBox rightPane = new VBox();
        VBox leftPane = new VBox();


        // ------------Styling------------ 
        rightPane.getStylesheets().add("/resources/css/theme.css");
        rightPane.setPadding(new Insets(20));
        rightPane.setSpacing(10);
        rightPane.setAlignment(Pos.CENTER);
        rightPane.setStyle("-fx-background-color:#34495e");
        rightPane.setPrefSize(300, 600);
        leftPane.setPrefSize(rightPane.getPrefWidth() * 3, rightPane.getPrefHeight());
        leftPane.setSpacing(15);
        leftPane.setPadding(new Insets(20, 10, 10, 20));
        BTN_LOGIN.getStyleClass().add("primary");
        BTN_LOGIN.setPrefWidth(150);
        TXT_USER.setFont(new Font(20));
        TXT_PASSWORD.setFont(new Font(20));

        loadLoginGuiLang();

        // ------------Logic------------
        Alert alert = new Alert(AlertType.WARNING);

        BTN_LOGIN.setOnMouseClicked(e -> {

            try {
                App.USER_ONLINE = serviceUser.authentication(TXT_USER.getText(), TXT_PASSWORD.getText());
                HomeGUI webmasterGui = new HomeGUI();
                App.GLOBAL_PANE_BORDER.setCenter(webmasterGui);
                // traitement
            } catch (ObjectNotFoundException ex) {

                alert.setTitle(ex.getMessage());
                alert.setHeaderText(ex.getMessage());
                alert.setContentText(ex.getMessage());
                alert.showAndWait();

            }
        });
        leftPane.getChildren().addAll(LANGUAGE_BOX);
        rightPane.getChildren().addAll(TXT_USER, TXT_PASSWORD, BTN_LOGIN);
        this.getChildren().addAll(leftPane, rightPane);

    }

    /**
     *
     */
    public static void loadLoginGuiLang() {
        LoginGUI.BTN_LOGIN.setText(BUNDLE.getString("login"));
        LoginGUI.TXT_USER.setPromptText(LanguageToolBar.BUNDLE.getString("username"));
        LoginGUI.TXT_PASSWORD.setPromptText(LanguageToolBar.BUNDLE.getString("password"));
    }

}
