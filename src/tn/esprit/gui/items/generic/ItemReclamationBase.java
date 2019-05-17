package tn.esprit.gui.items.generic;

import java.lang.String;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import tn.esprit.entities.Reclamation;

public class ItemReclamationBase extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final MenuButton menuButton;

    protected final Separator separator;
    protected final Label label3;

    public ItemReclamationBase(Reclamation reclamation) {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        menuButton = new MenuButton();

        separator = new Separator();
        label3 = new Label();
        getStylesheets().add("/resources/css/theme.css");

        setPrefHeight(50.0);
        setPrefWidth(781.0);
        setMaxWidth(781);
        setStyle("-fx-background-color: #f7f1e3; -fx-border-width: 5; -fx-border-color: #2980b9; -fx-border-radius: 25 0 25 0; -fx-background-radius: 25 0 25 0;");

        label.setLayoutX(278.0);
        label.setLayoutY(28.0);
        label.setPrefHeight(18.0);
        label.setPrefWidth(48.0);
        label.setText(reclamation.getJob().getTitle());
        label.setFont(new Font("Gill Sans MT", 15.0));

        label0.setLayoutX(483.0);
        label0.setLayoutY(28.0);
        label0.setText(reclamation.getType());
        label0.setFont(new Font("Gill Sans MT", 15.0));

        label1.setLayoutX(367.0);
        label1.setLayoutY(28.0);
        if (reclamation.getJob() != null) {
            label1.setText(reclamation.getJob().getTitle());
        }
        if (reclamation.getComment() != null) {
            label1.setText(reclamation.getComment().getJob().getTitle());
        }

        label1.setFont(new Font("Gill Sans MT", 15.0));

        label2.setLayoutX(22.0);
        label2.setLayoutY(23.0);
        label2.setPrefHeight(32.0);
        label2.setPrefWidth(109.0);

        label2.setText(reclamation.getStatus());

        if (reclamation.getStatus().equals("OPEN")) {
            label2.getStyleClass().add("success");
        }

        if (reclamation.getStatus().equals("CLOSED")) {
            label2.getStyleClass().add("primary");
        }

        if (reclamation.getStatus().equals("PENDING")) {
            label2.getStyleClass().add("warning");
        }

        if (reclamation.getStatus().equals("REDIRECTED")) {
            label2.getStyleClass().add("danger");
        }

        if (reclamation.getStatus().equals("CANCELED")) {
            label2.getStyleClass().add("default");
        }

        label2.getStyleClass().add("button");
        menuButton.setLayoutX(631.0);
        menuButton.setLayoutY(21.0);
        menuButton.setMnemonicParsing(false);
        menuButton.setPrefHeight(32.0);
        menuButton.setPrefWidth(109.0);
        menuButton.getStyleClass().add("primary");

        menuButton.setText("Action");

        MenuItem menuItem = new MenuItem();
        menuItem.setMnemonicParsing(false);
        menuItem.setText("Inspect");

        MenuItem menuItem1 = new MenuItem();
        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Discard");

        separator.setLayoutX(579.0);
        separator.setOrientation(javafx.geometry.Orientation.VERTICAL);
        separator.setPrefHeight(68.0);
        separator.setPrefWidth(32.0);

        label3.setLayoutX(150.0);
        label3.setLayoutY(28.0);
        label3.setPrefHeight(18.0);
        label3.setPrefWidth(116.0);
        label3.setText(reclamation.getClaimer().getFirstName() + " " + reclamation.getClaimer().getLastName());
        label3.setFont(new Font("Gill Sans MT", 15.0));

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        menuButton.getItems().add(menuItem);
        menuButton.getItems().add(menuItem1);
        getChildren().add(menuButton);
        getChildren().add(separator);
        getChildren().add(label3);

    }
}
