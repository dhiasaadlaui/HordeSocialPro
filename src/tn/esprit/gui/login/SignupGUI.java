/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import eu.hansolo.tilesfx.Demo;
import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import tn.esprit.entities.UserRole;
import tn.esprit.gui.launch.App;

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
    public static Button BTN_PHOTO_CHOSE;

    private Tile PHOTO;

    public SignupGUI(UserRole useRole) {

        // ---------initialization -----------
        PHOTO = TileBuilder.create()
                .skinType(Tile.SkinType.IMAGE)
                .prefSize(300, 300)
                .title("Candidate")
                .image(new Image(Demo.class.getResourceAsStream("/resources/images/default.jpg")))
                .imageMask(Tile.ImageMask.ROUND)
                .text("Photo")
                .textAlignment(TextAlignment.CENTER)
                .build();

        USERNAME_LABEL = new Label("username");
        FIRST_NAME_LABEL = new Label("first name");
        LAST_NAME_LABEL = new Label("last name");
        EMAIL_LABEL = new Label("E mail");
        ADRESS_LABEL = new Label("Adress");
        PASSWORD_LABEL = new Label("password");
        PASSWORD_CONFIRM_LABEL = new Label("confirm password");

        USERNAME_TXT = new TextField("usernam");
        FIRST_NAME_TXT = new TextField();
        LAST_NAME_TXT = new TextField();
        EMAIL_TXT = new TextField();
        ADRESS_TXT = new TextField();
        PASSWORD_TXT = new PasswordField();
        PASSWORD_CONFIRM_TXT = new PasswordField();
        BTN_PHOTO_CHOSE = new Button("Chose file");
        BTN_BACK = new Button("Back");
        LEFT_PANE = new VBox();

        RIGHT_PANE = new VBox();

        // ---------- styling --------------
        LEFT_PANE.setStyle("-fx-background-color:#34495e");
        LEFT_PANE.setSpacing(15);
        LEFT_PANE.setPadding(new Insets(20));
        LEFT_PANE.setAlignment(Pos.CENTER);
        LEFT_PANE.setSpacing(15);
        LEFT_PANE.setPrefWidth(500);
        String labelsStyle = "-fx-font-size:20px;-fx-text-fill:#FFF";

        USERNAME_LABEL.setStyle(labelsStyle);
        FIRST_NAME_LABEL.setStyle(labelsStyle);
        LAST_NAME_LABEL.setStyle(labelsStyle);
        EMAIL_LABEL.setStyle(labelsStyle);
        ADRESS_LABEL.setStyle(labelsStyle);
        PASSWORD_LABEL.setStyle(labelsStyle);
        PASSWORD_CONFIRM_LABEL.setStyle(labelsStyle);

        // ---------- logic ----------------
        BTN_BACK.setOnMouseClicked(e -> {

            App.GLOBAL_PANE_BORDER.setCenter(new LoginGUI());

        });

        TilePane form = new TilePane();
        
        TilePane userName = new TilePane();
        userName.setTileAlignment(Pos.BASELINE_LEFT);
        userName.getChildren().addAll(USERNAME_LABEL, USERNAME_TXT);
        
        TilePane firstName = new TilePane();
        firstName.setTileAlignment(Pos.BASELINE_LEFT);
        firstName.getChildren().addAll(FIRST_NAME_LABEL, FIRST_NAME_TXT);

        TilePane lastName = new TilePane();
        lastName.setTileAlignment(Pos.BASELINE_LEFT);
        lastName.getChildren().addAll(LAST_NAME_LABEL, LAST_NAME_TXT);

        TilePane eMail = new TilePane();
        eMail.setTileAlignment(Pos.BASELINE_LEFT);
        eMail.getChildren().addAll(EMAIL_LABEL, EMAIL_TXT);

        TilePane adress = new TilePane();
        adress.setTileAlignment(Pos.BASELINE_LEFT);
        adress.getChildren().addAll(ADRESS_LABEL, ADRESS_TXT);

        TilePane password = new TilePane();
        password.setTileAlignment(Pos.BASELINE_LEFT);
        password.getChildren().addAll(PASSWORD_LABEL, PASSWORD_TXT);

        TilePane confirmPassword = new TilePane();
        confirmPassword.setTileAlignment(Pos.BASELINE_LEFT);
        confirmPassword.getChildren().addAll(PASSWORD_CONFIRM_LABEL, PASSWORD_CONFIRM_TXT);

        LEFT_PANE.getChildren().addAll(userName, firstName, lastName, eMail, adress, password, confirmPassword, BTN_BACK);
        RIGHT_PANE.getChildren().addAll(PHOTO, BTN_PHOTO_CHOSE);
        this.getChildren().addAll(LEFT_PANE, RIGHT_PANE);
    }

}
