/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import eu.hansolo.tilesfx.Tile;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.entities.UserRole;
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

    public static Button BTN_SIGNUP_CANDIDATE;
    public static Button BTN_SIGNUP_RECRUITER;
    public static Button BTN_EXIT;

    /**
     *
     */
    public static TextField TXT_USER;

    /**
     *
     */
    public static PasswordField TXT_PASSWORD;
    public static Label LABEL_SIGNUP;

    /**
     *
     */
    public static LanguageToolBar LANGUAGE_BOX;
    public static TilesInitilizer TILES;
    public static WorldMap map = new WorldMap(800, 600);

    /**
     *
     */
    public LoginGUI() {

        // ------------initialisation------------
        IServiceUser serviceUser = new ServiceUserImpl();
        BTN_LOGIN = new Button(LanguageToolBar.BUNDLE.getString("login"));
        BTN_SIGNUP_CANDIDATE = new Button(LanguageToolBar.BUNDLE.getString("signupcandidate"));
        BTN_SIGNUP_RECRUITER = new Button(LanguageToolBar.BUNDLE.getString("signuprecruiter"));
        BTN_EXIT = new Button(LanguageToolBar.BUNDLE.getString("exit"));
        LABEL_SIGNUP = new Label(LanguageToolBar.BUNDLE.getString("loginquestion"));
        TXT_USER = new TextField();
        TXT_PASSWORD = new PasswordField();
        LANGUAGE_BOX = new LanguageToolBar();
        VBox rightPane = new VBox();
        VBox leftPane = new VBox();
        TILES = new TilesInitilizer();

        // ------------Styling------------ 
        rightPane.getStylesheets().add("/resources/css/theme.css");
        rightPane.setPrefWidth(leftPane.getPrefWidth() / 4);
        rightPane.setPadding(new Insets(50, 20, 50, 20));
        rightPane.setSpacing(10);
        rightPane.setAlignment(Pos.BOTTOM_CENTER);
        rightPane.setStyle("-fx-background-color:#34495e");
        rightPane.setPrefSize(300, 800);
        leftPane.setPrefSize(rightPane.getPrefWidth() * 4, rightPane.getPrefHeight());
        leftPane.setSpacing(15);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        leftPane.setAlignment(Pos.CENTER);
        BTN_LOGIN.getStyleClass().add("primary");
        BTN_LOGIN.setPrefWidth(150);
        BTN_SIGNUP_CANDIDATE.getStyleClass().add("primary");
        BTN_SIGNUP_CANDIDATE.setPrefWidth(150);

        BTN_SIGNUP_RECRUITER.getStyleClass().add("primary");
        BTN_SIGNUP_RECRUITER.setPrefWidth(150);
        BTN_EXIT.getStyleClass().add("danger");
        BTN_EXIT.setPrefWidth(150);

        TXT_USER.setFont(new Font(20));
        TXT_PASSWORD.setFont(new Font(20));
        LABEL_SIGNUP.setStyle("-fx-text-fill: white;");

        loadLoginGuiLang();

        // ------------Logic------------
        Alert alert = new Alert(AlertType.WARNING);

        BTN_LOGIN.setOnMouseClicked(e -> {

            try {
                App.USER_ONLINE = serviceUser.authentication(TXT_USER.getText(), TXT_PASSWORD.getText());
                HomeGUI home = new HomeGUI();
                App.GLOBAL_PANE_BORDER.setCenter(home);
                // traitement
            } catch (ObjectNotFoundException ex) {

                alert.setTitle(ex.getMessage());
                alert.setHeaderText(ex.getMessage());
                alert.setContentText(ex.getMessage());
                alert.showAndWait();

            }
        });
        BTN_SIGNUP_CANDIDATE.setOnMouseClicked(e -> {

            SignupGUI signUp = new SignupGUI(UserRole.CANDIDATE);
            App.GLOBAL_PANE_BORDER.setCenter(signUp);
        });
        BTN_SIGNUP_RECRUITER.setOnMouseClicked(e -> {

            SignupGUI signUp = new SignupGUI(UserRole.RECRUITER);
            App.GLOBAL_PANE_BORDER.setCenter(signUp);
        });
        BTN_EXIT.setOnAction(e -> {
            Platform.exit();
        });
        map = new WorldMap(400, 1000);
        leftPane.getChildren().addAll(LANGUAGE_BOX, map.worldMap);
        ImageView logoLarge = new ImageView(new Image(getClass().getResourceAsStream("/resources/images/horde_xlarge.png")));
        logoLarge.setFitHeight(289);
        logoLarge.setFitWidth(187);
        Region spacer = new Region();
        spacer.setPrefHeight(200);
        Region spacer2 = new Region();
        spacer2.setPrefHeight(50);
        rightPane.getChildren().addAll(logoLarge, TXT_USER, TXT_PASSWORD, BTN_LOGIN, spacer, LABEL_SIGNUP, BTN_SIGNUP_CANDIDATE, BTN_SIGNUP_RECRUITER, spacer2, BTN_EXIT);
        this.getChildren().addAll(leftPane, rightPane);

    }

    /**
     *
     */
    public static void loadLoginGuiLang() {
        BTN_LOGIN.setText(BUNDLE.getString("login"));
        TXT_USER.setPromptText(LanguageToolBar.BUNDLE.getString("username"));
        TXT_PASSWORD.setPromptText(LanguageToolBar.BUNDLE.getString("password"));
        
        BTN_EXIT.setText(LanguageToolBar.BUNDLE.getString("exit"));
        BTN_SIGNUP_CANDIDATE.setText(LanguageToolBar.BUNDLE.getString("signupcandidate"));
        BTN_SIGNUP_RECRUITER.setText(LanguageToolBar.BUNDLE.getString("signuprecruiter"));
        LABEL_SIGNUP.setText(LanguageToolBar.BUNDLE.getString("loginquestion"));
        map.worldMap.setTitle(LanguageToolBar.BUNDLE.getString("loginmaptitle"));
        map.worldMap.setText(LanguageToolBar.BUNDLE.getString("loginmaptext"));
    }

}
