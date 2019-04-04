/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import eu.hansolo.tilesfx.Demo;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.tools.Country;
import java.io.File;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import tn.esprit.entities.User;
import tn.esprit.entities.UserRole;
import tn.esprit.gui.launch.App;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author mdsaadlaoui
 */
public class SignupGUI extends HBox {

    public static VBox LEFT_PANE;
    public static VBox RIGHT_PANE;

    public static Label USERNAME_LABEL;
    public static Label FIRST_NAME_LABEL;
    public static Label LAST_NAME_LABEL;
    public static Label EMAIL_LABEL;
    public static Label ADRESS_LABEL;
    public static Label PASSWORD_LABEL;
    public static Label PASSWORD_CONFIRM_LABEL;

    public static TextField USERNAME_TXT;
    public static TextField FIRST_NAME_TXT;
    public static TextField LAST_NAME_TXT;
    public static TextField EMAIL_TXT;
    public static TextField ADRESS_TXT;
    public static PasswordField PASSWORD_TXT;
    public static PasswordField PASSWORD_CONFIRM_TXT;

    public static Button BTN_BACK;
    public static Button BTN_SUBMIT;
    public static Button BTN_PHOTO_CHOSE;

    private Tile PHOTO;
    public static File filePhotoProfil;
private IServiceUser serviceUser;
    public SignupGUI(UserRole useRole) {

        getStylesheets().add("/resources/css/theme.css");

        // ---------initialization -----------
        serviceUser = new ServiceUserImpl();
        
        LEFT_PANE = new VBox();
        RIGHT_PANE = new VBox();

        TitledPane formCandidate = new TitledPane();
        GridPane gridCandidate = new GridPane();

        filePhotoProfil = new File("/resources/images/default.jpg");
        FileChooser fileChooser = new FileChooser();

        ComboBox countries = new ComboBox(FXCollections.observableList(Arrays.asList(Country.values())));
        countries.getSelectionModel().selectFirst();

        PHOTO = TileBuilder.create()
                .skinType(Tile.SkinType.IMAGE)
                .prefSize(300, 300)
                .title("Candidate")
                .image(new Image(this.getClass().getResourceAsStream("/resources/images/default.jpg")))
                .imageMask(Tile.ImageMask.ROUND)
                .text("Photo")
                .textAlignment(TextAlignment.CENTER)
                .build();

        USERNAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("username"));
        FIRST_NAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("firstname"));
        LAST_NAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("lastname"));
        EMAIL_LABEL = new Label(LanguageToolBar.BUNDLE.getString("email"));
        ADRESS_LABEL = new Label(LanguageToolBar.BUNDLE.getString("adress"));
        PASSWORD_LABEL = new Label(LanguageToolBar.BUNDLE.getString("password"));
        PASSWORD_CONFIRM_LABEL = new Label(LanguageToolBar.BUNDLE.getString("confirmpassword"));
        USERNAME_TXT = new TextField();
        FIRST_NAME_TXT = new TextField();
        LAST_NAME_TXT = new TextField();
        EMAIL_TXT = new TextField();
        ADRESS_TXT = new TextField();
        PASSWORD_TXT = new PasswordField();
        PASSWORD_CONFIRM_TXT = new PasswordField();
        BTN_PHOTO_CHOSE = new Button("Chose file");
        BTN_BACK = new Button(LanguageToolBar.BUNDLE.getString("back"));
        BTN_SUBMIT = new Button(LanguageToolBar.BUNDLE.getString("submit"));

        // ---------- styling --------------
        
        BTN_BACK.getStyleClass().add("danger");
        BTN_BACK.setPrefWidth(200);
        
       
        BTN_SUBMIT.getStyleClass().add("primary");
        BTN_SUBMIT.setPrefWidth(200);
        countries.setStyle("primary");
        LEFT_PANE.setStyle("-fx-background-color:#34495e");
        LEFT_PANE.setSpacing(15);
        LEFT_PANE.setPadding(new Insets(20));
        LEFT_PANE.setAlignment(Pos.BOTTOM_CENTER);
        LEFT_PANE.setSpacing(15);
        LEFT_PANE.setPrefWidth(500);
        String labelsStyle = "-fx-font-size:20px";

        USERNAME_LABEL.setStyle(labelsStyle);
        FIRST_NAME_LABEL.setStyle(labelsStyle);
        LAST_NAME_LABEL.setStyle(labelsStyle);
        EMAIL_LABEL.setStyle(labelsStyle);
        ADRESS_LABEL.setStyle(labelsStyle);
        PASSWORD_LABEL.setStyle(labelsStyle);
        PASSWORD_CONFIRM_LABEL.setStyle(labelsStyle);

        gridCandidate.setVgap(4);

        gridCandidate.setPadding(new Insets(5, 5, 5, 5));

        formCandidate.setText(LanguageToolBar.BUNDLE.getString("userform"));
        formCandidate.getStyleClass().add("primary");
        fileChooser.setTitle("Photo de profil");

        // ---------- logic ----------------
        BTN_SUBMIT.setOnAction(e->{
            try {
                serviceUser.signUp(new User.Builder().build());
            } catch (ConstraintViolationException ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(ex.getMessage());
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        });
        countries.setOnAction(e -> {
            System.out.println(countries.getValue().toString());
        });

        gridCandidate.add(USERNAME_LABEL, 0, 0);
        gridCandidate.add(USERNAME_TXT, 1, 0);
        gridCandidate.add(FIRST_NAME_LABEL, 0, 1);
        gridCandidate.add(FIRST_NAME_TXT, 1, 1);
        gridCandidate.add(LAST_NAME_LABEL, 0, 2);
        gridCandidate.add(LAST_NAME_TXT, 1, 2);
        gridCandidate.add(EMAIL_LABEL, 0, 3);
        gridCandidate.add(EMAIL_TXT, 1, 3);
        gridCandidate.add(ADRESS_LABEL, 0, 4);
        gridCandidate.add(ADRESS_TXT, 1, 4);
        gridCandidate.add(PASSWORD_LABEL, 0, 5);
        gridCandidate.add(PASSWORD_TXT, 1, 5);
        gridCandidate.add(PASSWORD_CONFIRM_LABEL, 0, 6);
        gridCandidate.add(PASSWORD_CONFIRM_TXT, 1, 6);
        formCandidate.setContent(gridCandidate);
        BTN_BACK.setOnMouseClicked(e -> {

            App.GLOBAL_PANE_BORDER.setCenter(new LoginGUI());

        });

        BTN_PHOTO_CHOSE.setOnMouseClicked(e -> {

            filePhotoProfil = fileChooser.showOpenDialog(new Stage());

            PHOTO.setImage(new Image(filePhotoProfil.toURI().toString()));
            System.out.println(filePhotoProfil.getName());

        });

        formCandidate.setAlignment(Pos.BASELINE_LEFT);

        Region spacer = new Region();
       spacer.setPrefHeight(200);
        LEFT_PANE.getChildren().addAll(formCandidate, BTN_SUBMIT,spacer,BTN_BACK,countries);
        RIGHT_PANE.getChildren().addAll(PHOTO, BTN_PHOTO_CHOSE);
        this.getChildren().addAll(LEFT_PANE, RIGHT_PANE);
    }

}
