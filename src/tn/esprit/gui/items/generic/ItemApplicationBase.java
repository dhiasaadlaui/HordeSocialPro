package tn.esprit.gui.items.generic;

import java.text.SimpleDateFormat;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import tn.esprit.gui.pages.PageViewApplication;
import tn.esprit.entities.Apply;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.pages.PageApplicationsBase;

public  class ItemApplicationBase extends HBox {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Button button;

    public ItemApplicationBase(Apply apply) {

        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        button = new Button();

        setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        setPrefHeight(54.0);
        setPrefWidth(776.0);
        setSpacing(10.0);
        setStyle("-fx-background-color: #A4A4A4; -fx-border-color: #6492db; -fx-border-width: 5px; -fx-background-radius: 25 0 0 25; -fx-border-radius: 25 0 0 25;");
        getStylesheets().add("/resources/css/theme.css");

        label.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setPrefHeight(54.0);
        label.setPrefWidth(118.0);
        label.setText(apply.getCandidate().getFirstName()+" "+apply.getCandidate().getLastName());
        label.setFont(new Font("Constantia", 14.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setPrefHeight(54.0);
        label0.setPrefWidth(67.0);
        label0.setText(apply.getJob().getTitle());
        label0.setFont(new Font("Constantia", 14.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setPrefHeight(54.0);
        label1.setPrefWidth(99.0);
        label1.setText(apply.getJob().getCategory().getLabel());
        label1.setFont(new Font("Constantia", 14.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label2.setPrefHeight(54.0);
        label2.setPrefWidth(123.0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        label2.setText(sdf.format(apply.getJob().getCreationDate()));
        label2.setFont(new Font("Constantia", 14.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label3.setPrefHeight(54.0);
        label3.setPrefWidth(118.0);
        label3.setText(sdf.format(apply.getJob().getExpireDate()));
        label3.setFont(new Font("Constantia", 14.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label4.setPrefHeight(54.0);
        label4.setPrefWidth(110.0);
        label4.setText(apply.getJob().getSalary()+" EUR");
        label4.setFont(new Font("Constantia", 14.0));

        button.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        button.setLineSpacing(1.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("success");
   
        button.setText("Details");
        button.setOnMouseClicked(e->{
              ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewApplication(apply));
        });

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(button);

    }
}
