/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.tools.Country;
import java.io.File;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
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
import tn.esprit.services.util.ServiceInputValidator;

/**
 *
 * @author mdsaadlaoui
 */
public class SignupGUI extends HBox {

    /**
     *
     */
    public static VBox LEFT_PANE;

    /**
     *
     */
    public static VBox RIGHT_PANE;

    /**
     *
     */
    public static Label USERNAME_LABEL;

    /**
     *
     */
    public static Label FIRST_NAME_LABEL;

    /**
     *
     */
    public static Label LAST_NAME_LABEL;

    /**
     *
     */
    public static Label EMAIL_LABEL;

    /**
     *
     */
    public static Label ADRESS_LABEL;

    /**
     *
     */
    public static Label PASSWORD_LABEL;

    /**
     *
     */
    public static Label PASSWORD_CONFIRM_LABEL;

    /**
     *
     */
    public static Label SEXE_LABEL;

    /**
     *
     */
    public static TextField USERNAME_TXT;

    /**
     *
     */
    public static TextField FIRST_NAME_TXT;

    /**
     *
     */
    public static TextField LAST_NAME_TXT;

    /**
     *
     */
    public static TextField EMAIL_TXT;

    /**
     *
     */
    public static TextField ADRESS_TXT;

    /**
     *
     */
    public static PasswordField PASSWORD_TXT;

    /**
     *
     */
    public static PasswordField PASSWORD_CONFIRM_TXT;

    /**
     *
     */
    public static TextField COMPANY_NAME_TXT;

    /**
     *
     */
    public static TextField COMPANY_DESCRIPTION_TXT;

    /**
     *
     */
    public static TextField COMPANY_ADRESS_TXT;

    /**
     *
     */
    public static TextField COMPANY_DOMAIN_TXT;

    /**
     *
     */
    public static TextField COMPANY_IMAGE_TXT;

    /**
     *
     */
    public static TextField COMPANY_PHONE_TXT;

    /**
     *
     */
    public static Label COMPANY_NAME_LABEL;

    /**
     *
     */
    public static Label COMPANY_DESCRIPTION_LABEL;

    /**
     *
     */
    public static Label COMPANY_ADRESS_LABEL;

    /**
     *
     */
    public static Label COMPANY_DOMAIN_LABEL;

    /**
     *
     */
    public static Label COMPANY_IMAGE_LABEL;

    /**
     *
     */
    public static Label COMPANY_PHONE_LABEL;

    /**
     *
     */
    public static Button BTN_BACK;

    /**
     *
     */
    public static Button BTN_SUBMIT;

    /**
     *
     */
    public static Button BTN_PHOTO_CHOSE;

    /**
     *
     */
    public static Button BTN_PHOTO_CHOSE_COMPANY;

    private Tile PHOTO;
    private Tile PHOTO_COMPANY;
    private Tile COUNTRY_TILE;

    /**
     *
     */
    public static File filePhotoProfil;
    private IServiceUser serviceUser;

    /**
     *
     * @param useRole
     */
    public SignupGUI(UserRole useRole) {

        getStylesheets().add("/resources/css/theme.css");

        // ---------initialization -----------
        serviceUser = new ServiceUserImpl();

        LEFT_PANE = new VBox();
        RIGHT_PANE = new VBox();

        TitledPane formCandidate = new TitledPane();
        GridPane gridUser = new GridPane();

        TitledPane formCompany = new TitledPane();
        GridPane gridCompany = new GridPane();

        filePhotoProfil = new File("/resources/images/default.jpg");
        FileChooser fileChooser = new FileChooser();

        ComboBox countries = new ComboBox(FXCollections.observableList(Arrays.asList(Country.values())));
        countries.getSelectionModel().selectFirst();
        COUNTRY_TILE = TileBuilder.create().skinType(Tile.SkinType.COUNTRY)
                .minValue(0)
                .maxValue(40)
                .title("Country")
                .unit("Unit")
                .country(Country.valueOf(countries.getValue().toString()))
                .tooltipText("")
                .animated(true)
                .build();

        PHOTO = TileBuilder.create()
                .skinType(Tile.SkinType.IMAGE)
                .image(new Image(this.getClass().getResourceAsStream("/resources/images/default.jpg")))
                .imageMask(Tile.ImageMask.ROUND)
                .backgroundColor(Color.TRANSPARENT)
                .textAlignment(TextAlignment.CENTER)
                .build();

        PHOTO_COMPANY = TileBuilder.create()
                .skinType(Tile.SkinType.IMAGE)
                .image(new Image(this.getClass().getResourceAsStream("/resources/images/defaultcompany.jpg")))
                .prefSize(400, 400)
                .imageMask(Tile.ImageMask.NONE)
                .backgroundColor(Color.TRANSPARENT)
                .textAlignment(TextAlignment.CENTER)
                .build();

        USERNAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("username"));
        FIRST_NAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("firstname"));
        LAST_NAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("lastname"));
        EMAIL_LABEL = new Label(LanguageToolBar.BUNDLE.getString("email"));
        ADRESS_LABEL = new Label(LanguageToolBar.BUNDLE.getString("adress"));
        PASSWORD_LABEL = new Label(LanguageToolBar.BUNDLE.getString("password"));
        PASSWORD_CONFIRM_LABEL = new Label(LanguageToolBar.BUNDLE.getString("confirmpassword"));
        RadioButton rb2 = new RadioButton(LanguageToolBar.BUNDLE.getString("women"));
        RadioButton rb1 = new RadioButton(LanguageToolBar.BUNDLE.getString("man"));
        SEXE_LABEL = new Label(LanguageToolBar.BUNDLE.getString("gender"));
        USERNAME_TXT = new TextField();
        FIRST_NAME_TXT = new TextField();
        LAST_NAME_TXT = new TextField();
        EMAIL_TXT = new TextField();
        ADRESS_TXT = new TextField();
        PASSWORD_TXT = new PasswordField();
        PASSWORD_CONFIRM_TXT = new PasswordField();
        BTN_PHOTO_CHOSE = new Button(LanguageToolBar.BUNDLE.getString("photo"));

        COMPANY_NAME_TXT = new TextField();
        COMPANY_DESCRIPTION_TXT = new TextField();
        COMPANY_ADRESS_TXT = new TextField();
        COMPANY_DOMAIN_TXT = new TextField();
        COMPANY_IMAGE_TXT = new TextField();
        COMPANY_PHONE_TXT = new TextField();
        COMPANY_NAME_LABEL = new Label(LanguageToolBar.BUNDLE.getString("companyname"));
        COMPANY_DESCRIPTION_LABEL = new Label(LanguageToolBar.BUNDLE.getString("description"));
        COMPANY_ADRESS_LABEL = new Label(LanguageToolBar.BUNDLE.getString("companyadress"));
        COMPANY_DOMAIN_LABEL = new Label(LanguageToolBar.BUNDLE.getString("domain"));
        COMPANY_IMAGE_LABEL = new Label(LanguageToolBar.BUNDLE.getString("image"));
        COMPANY_PHONE_LABEL = new Label(LanguageToolBar.BUNDLE.getString("phone"));

        BTN_PHOTO_CHOSE_COMPANY = new Button("Chose file");

        BTN_BACK = new Button(LanguageToolBar.BUNDLE.getString("back"));
        BTN_SUBMIT = new Button(LanguageToolBar.BUNDLE.getString("submit"));

        // ---------- styling --------------
        App.GLOBAL_PANE_BORDER.setStyle("-fx-background-image: url(\"/resources/images/background_1.jpg\");-fx-background-repeat: stretch;   \n"
                + "    -fx-background-position: center center;\n"
                + " -fx-background-size: cover, auto;");
        BTN_BACK.getStyleClass().add("danger");
        BTN_BACK.setPrefWidth(200);

        BTN_SUBMIT.getStyleClass().add("primary");
        BTN_SUBMIT.setPrefWidth(200);

        LEFT_PANE.setStyle("-fx-background-color:#34495e");
        LEFT_PANE.setSpacing(15);
        LEFT_PANE.setPadding(new Insets(20));
        LEFT_PANE.setAlignment(Pos.BOTTOM_CENTER);
        LEFT_PANE.setSpacing(15);
        LEFT_PANE.setPrefWidth(500);
        String labelsStyle = "-fx-font-size:20px";
        String textInvalidStyle = "-fx-font-size:15px;-fx-text-inner-color: red;";
        String textValid = "-fx-font-size:15px;-fx-text-inner-color: black;";
        USERNAME_LABEL.setStyle(labelsStyle);
        FIRST_NAME_LABEL.setStyle(labelsStyle);
        LAST_NAME_LABEL.setStyle(labelsStyle);
        EMAIL_LABEL.setStyle(labelsStyle);
        ADRESS_LABEL.setStyle(labelsStyle);
        PASSWORD_LABEL.setStyle(labelsStyle);
        PASSWORD_CONFIRM_LABEL.setStyle(labelsStyle);
        SEXE_LABEL.setStyle(labelsStyle);
        BTN_PHOTO_CHOSE.getStyleClass().add("default");
        gridUser.setVgap(4);
        BTN_PHOTO_CHOSE.setPrefWidth(250);

        gridUser.setPadding(new Insets(5, 5, 5, 5));

        formCandidate.setText(LanguageToolBar.BUNDLE.getString("userform"));
        formCandidate.getStyleClass().add("primary");
        formCompany.setText(LanguageToolBar.BUNDLE.getString("company"));
        formCompany.getStyleClass().add("danger");
        fileChooser.setTitle("Photo de profil");

        // ---------- logic ----------------
        BTN_SUBMIT.setOnAction(e -> {
            try {
                serviceUser.signUp(new User.Builder()
                        .firstName(FIRST_NAME_TXT.getText())
                        .lastName(LAST_NAME_TXT.getText())
                        .userName(USERNAME_TXT.getText())
                        .email(EMAIL_TXT.getText())
                        .adress(ADRESS_TXT.getText())
                        .password(PASSWORD_TXT.getText())
                        .build());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("success d'inscription");
                alert.show();
                App.GLOBAL_PANE_BORDER.setCenter(new LoginGUI());

            } catch (ConstraintViolationException ex) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(ex.getMessage());
                alert.setContentText(ex.getMessage());
                alert.show();
            }
        });
        countries.setOnAction(e -> {
            COUNTRY_TILE.setCountry(Country.valueOf(countries.getValue().toString()));
            System.out.println(countries.getValue().toString());
        });

        ToggleGroup rbgroup = new ToggleGroup();

        rb1.setToggleGroup(rbgroup);
        rb1.setSelected(true);

        rb2.setToggleGroup(rbgroup);
        HBox sexeRadioGroup = new HBox(rb1, rb2);
        sexeRadioGroup.setSpacing(10);

        gridUser.add(USERNAME_LABEL, 0, 0);
        gridUser.add(USERNAME_TXT, 1, 0);
        gridUser.add(FIRST_NAME_LABEL, 0, 1);
        gridUser.add(FIRST_NAME_TXT, 1, 1);
        gridUser.add(LAST_NAME_LABEL, 0, 2);
        gridUser.add(LAST_NAME_TXT, 1, 2);
        gridUser.add(SEXE_LABEL, 0, 3);
        gridUser.add(sexeRadioGroup, 1, 3);
        gridUser.add(EMAIL_LABEL, 0, 4);
        gridUser.add(EMAIL_TXT, 1, 4);
        gridUser.add(ADRESS_LABEL, 0, 5);
        gridUser.add(ADRESS_TXT, 1, 5);
        gridUser.add(PASSWORD_LABEL, 0, 6);
        gridUser.add(PASSWORD_TXT, 1, 6);
        gridUser.add(PASSWORD_CONFIRM_LABEL, 0, 7);
        gridUser.add(PASSWORD_CONFIRM_TXT, 1, 7);
        gridUser.add(BTN_PHOTO_CHOSE, 0, 8);

        formCandidate.setContent(gridUser);

        HBox companyadress = new HBox(countries, COMPANY_ADRESS_TXT);
        gridCompany.add(COMPANY_NAME_LABEL, 0, 0);
        gridCompany.add(COMPANY_NAME_TXT, 1, 0);
        gridCompany.add(COMPANY_DESCRIPTION_LABEL, 0, 1);
        gridCompany.add(COMPANY_DESCRIPTION_TXT, 1, 1);
        gridCompany.add(COMPANY_PHONE_LABEL, 0, 2);
        gridCompany.add(COMPANY_PHONE_TXT, 1, 2);
        gridCompany.add(COMPANY_ADRESS_LABEL, 0, 3);
        gridCompany.add(companyadress, 1, 3);
        gridCompany.add(COMPANY_DOMAIN_LABEL, 0, 4);
        gridCompany.add(COMPANY_DOMAIN_TXT, 1, 4);
        gridCompany.add(COMPANY_IMAGE_LABEL, 0, 5);
        gridCompany.add(BTN_PHOTO_CHOSE_COMPANY, 1, 5);

        formCompany.setContent(gridCompany);

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

        //--------fields controlls -------------
        PASSWORD_CONFIRM_TXT.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!oldV) {
                PASSWORD_CONFIRM_TXT.setStyle(textValid);
            }
            if (!newV) {
                try {
                    PASSWORD_CONFIRM_TXT.setStyle(textValid);
                    ServiceInputValidator.sameText(PASSWORD_CONFIRM_TXT.getText(), PASSWORD_TXT.getText());
                    BTN_SUBMIT.setDisable(false);
                } catch (ConstraintViolationException ex) {
                    PASSWORD_CONFIRM_TXT.setStyle(textInvalidStyle);
                    BTN_SUBMIT.setDisable(true);
                }
            }
        });

        EMAIL_TXT.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!oldV) {
                EMAIL_TXT.setStyle(textValid);
            }
            if (!newV) {
                try {
                    EMAIL_TXT.setStyle(textValid);
                    ServiceInputValidator.mail(EMAIL_TXT.getText());
                    BTN_SUBMIT.setDisable(false);
                } catch (ConstraintViolationException ex) {
                    EMAIL_TXT.setStyle(textInvalidStyle);
                    BTN_SUBMIT.setDisable(true);
                }
            }
        });
        USERNAME_TXT.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!oldV) {
                USERNAME_TXT.setStyle(textValid);
            }
            if (!newV) {
                try {
                    USERNAME_TXT.setStyle(textValid);
                    ServiceInputValidator.username(USERNAME_TXT.getText());
                    BTN_SUBMIT.setDisable(false);
                } catch (ConstraintViolationException ex) {
                    USERNAME_TXT.setStyle(textInvalidStyle);
                    BTN_SUBMIT.setDisable(true);
                }
            }
        });
        formCompany.setExpanded(false);
        if (useRole.name().equals("CANDIDATE")) {
            //  LEFT_PANE.getChildren().removeAll(formCandidate, formCompany, BTN_SUBMIT, spacer, BTN_BACK);
            LEFT_PANE.getChildren().addAll(formCandidate, BTN_SUBMIT, spacer, BTN_BACK);
            RIGHT_PANE.getChildren().addAll(PHOTO);
        }
        if (useRole.name().equals("RECRUITER")) {
            //     LEFT_PANE.getChildren().removeAll(formCandidate, formCompany, BTN_SUBMIT, spacer, BTN_BACK);
            LEFT_PANE.getChildren().addAll(formCandidate, formCompany, BTN_SUBMIT, spacer, BTN_BACK);

            RIGHT_PANE.getChildren().addAll(PHOTO, PHOTO_COMPANY, COUNTRY_TILE);
        }

        this.getChildren().addAll(LEFT_PANE, RIGHT_PANE);
    }

}
