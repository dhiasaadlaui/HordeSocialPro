package tn.esprit.gui.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tn.esprit.entities.User;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

public abstract class PageAccountActivationBase extends AnchorPane {

    protected final TextField textField;
    protected final Label label;
    protected final Button button;
    IServiceUser serviceUser;

    public PageAccountActivationBase(User user) {
        serviceUser = new ServiceUserImpl();
        textField = new TextField();
        label = new Label();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(631.0);
        setPrefWidth(967.0);
        getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");

        textField.setLayoutX(335.0);
        textField.setLayoutY(290.0);
        textField.setPrefHeight(4.0);
        textField.setPrefWidth(274.0);

        label.setLayoutX(335.0);
        label.setLayoutY(221.0);
        label.setPrefHeight(58.0);
        label.setPrefWidth(319.0);
        label.setText("Activation code");
        label.setFont(new Font("Berlin Sans FB Demi Bold", 40.0));

        button.setLayoutX(432.0);
        button.setLayoutY(338.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("primary");
        button.setText("Submit");
        button.setOnMouseClicked(e -> {
            try {
                serviceUser.accountActivation(user, textField.getText());
                Alerts.displaySuccess("success","success d'activation please log in again");
            } catch (ConstraintViolationException ex) {
                Alerts.displayError("Error activation", ex.getMessage());
            }
        });
        getChildren().add(textField);
        getChildren().add(label);
        getChildren().add(button);

    }
}
