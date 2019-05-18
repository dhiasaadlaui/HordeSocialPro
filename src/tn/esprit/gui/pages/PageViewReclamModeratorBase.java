package tn.esprit.gui.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import tn.esprit.entities.Reclamation;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.launch.App;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.HandleReclamationModerator;
import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.interfaces.IServiceReclamation;

public abstract class PageViewReclamModeratorBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    IServiceReclamation serviceReclamation;

    public PageViewReclamModeratorBase(Reclamation reclamation) {
        serviceReclamation = new ServiceReclamationImpl();

        imageView = new ImageView();
        label = new Label();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();

        setId("AnchorPane");
        setPrefHeight(701.0);
        setPrefWidth(986.0);
        setStyle("-fx-background-color: #2C3A47;");

        imageView.setFitHeight(209.0);
        imageView.setFitWidth(269.0);
        imageView.setLayoutX(24.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/images/defaultcompany.jpg").toExternalForm()));

        label.setLayoutX(529.0);
        label.setLayoutY(27.0);
        label.setPrefHeight(94.0);
        label.setPrefWidth(398.0);
        label.setText("Status: " + reclamation.getStatus());
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));
        label.setFont(new Font(53.0));

        button.setLayoutX(506.0);
        button.setLayoutY(619.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(171.0);
        button.getStyleClass().add("danger");
        button.getStylesheets().add("/resources/css/theme.css");
        button.setText("DisableJob");
        button.setOnMouseClicked(e -> {
            try {
                serviceReclamation.handleModerator(reclamation, HandleReclamationModerator.DISABLE_JOB);
                Alerts.displaySuccess("Succes", "Job has been disabled");
                 ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageReclamationsBase() {
                });
            } catch (ConstraintViolationException ex) {
                Alerts.displayError("Error", ex.getMessage());
            }
        });
        button0.setLayoutX(281.0);
        button0.setLayoutY(619.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(171.0);
        button0.getStyleClass().add("success");
        button0.getStylesheets().add("/resources/css/theme.css");
        button0.setText("Reject");
        button0.setOnMouseClicked(e -> {
            try {
                serviceReclamation.handleModerator(reclamation, HandleReclamationModerator.REJECT);
                Alerts.displaySuccess("Succes", "Reclamation has been rejected");
                 ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageReclamationsBase() {
                });
            } catch (ConstraintViolationException ex) {
                Alerts.displayError("Error", ex.getMessage());
            }
        });

        button1.setLayoutX(506.0);
        button1.setLayoutY(550.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(32.0);
        button1.setPrefWidth(171.0);
        button1.getStyleClass().add("danger");
        button1.getStylesheets().add("/resources/css/theme.css");
        button1.setText("RemoveComment");

        button2.setLayoutX(281.0);
        button2.setLayoutY(549.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(32.0);
        button2.setPrefWidth(171.0);
        button2.getStyleClass().add("primary");
        button2.getStylesheets().add("/resources/css/theme.css");
        button2.setText("Redirect");
        button2.setOnMouseClicked(e -> {
            try {
                serviceReclamation.handleModerator(reclamation, HandleReclamationModerator.REDIRECT);
                Alerts.displaySuccess("Succes", "Reclamation has been redirected to administrators");
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageReclamationsBase() {
                });
            } catch (ConstraintViolationException ex) {
                Alerts.displayError("Error", ex.getMessage());
            }
        });
        label0.setLayoutX(330.0);
        label0.setLayoutY(99.0);
        label0.setPrefHeight(22.0);
        label0.setPrefWidth(398.0);
        label0.setText("Job: " + reclamation.getJob().getTitle());
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));
        label0.setFont(new Font(28.0));

        label1.setLayoutX(330.0);
        label1.setLayoutY(150.0);
        label1.setPrefHeight(22.0);
        label1.setPrefWidth(398.0);
        label1.setText("Company: " + reclamation.getJob().getCompanyName());
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));
        label1.setFont(new Font(28.0));

        label2.setLayoutX(53.0);
        label2.setLayoutY(248.0);
        label2.setPrefHeight(22.0);
        label2.setPrefWidth(398.0);
        label2.setText("Reclamation Type: " + reclamation.getType());
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));
        label2.setFont(new Font(28.0));

        label3.setLayoutX(53.0);
        label3.setLayoutY(295.0);
        label3.setPrefHeight(40.0);
        label3.setPrefWidth(833.0);
        label3.setText("Reclamation Details : " + reclamation.getDetails());
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));
        label3.setFont(new Font(28.0));

        label4.setLayoutX(330.0);
        label4.setLayoutY(190.0);
        label4.setPrefHeight(22.0);
        label4.setPrefWidth(398.0);
        label4.setText("Recruiter: " + reclamation.getJob().getCompany().getRecruiter().getFirstName() + " " + reclamation.getJob().getCompany().getRecruiter().getLastName());
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));
        label4.setFont(new Font(18.0));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);

    }
}
