/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 *
 * @author mdsaadlaoui
 */
public class PageCreateClaim extends VBox {

    public PageCreateClaim() {

        HBox outils = new HBox(); // la division de notre ecran totlae
        VBox bu = new VBox();
        /**
         * *************************************************
         */
        Label login = new Label("Aidez nous a connaitre la raison de reclamation ! ");
        login.setStyle("-fx-font-size:29px;-fx-text-fill:#CAD3C8");
        RadioButton r1 = new RadioButton("RACISM");
        RadioButton r2 = new RadioButton("SCAM");
        RadioButton r3 = new RadioButton("SCAM");
        RadioButton r4 = new RadioButton("FAKE USER");
        RadioButton r5 = new RadioButton("POLICYVIOLATION");
        RadioButton r6 = new RadioButton("HARASSEMENT");
        RadioButton r7 = new RadioButton("VIOLENCE");
        r1.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
        r2.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
        r3.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
        r4.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
        r5.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
         r6.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
          r7.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");
        TextArea textArea = new TextArea();

        textArea.setPromptText("Ajoutez une petite description (Pas Obligatoire) ! ");
        ImageView im = new ImageView(new Image(getClass().getResourceAsStream("/resources/icons/ancient.png")));
        //    ImageView im1 = new ImageView(new Image(getClass().getResourceAsStream("/resources/icons/writer.png")));
        im.setFitHeight(100);
        im.setFitWidth(150);
        //   im1.setFitHeight(80);
        //   im1.setFitWidth(80);
        // textArea.setPromptText("entrez une petite description si vous voulez ");
        textArea.setFont(new Font(15));
        Button s = new Button("Submit");
        s.setPrefWidth(150);
        s.setPrefHeight(43);
        s.setAlignment(Pos.CENTER);
        s.setStyle("-fx-background-color:#218c74;-fx-text-fill:#ecf0f1");
        textArea.setPadding(new Insets(40));
        textArea.setStyle("-fx-background-color:#dcdde1");
        textArea.setStyle("-fx-background-image: url(\"/resources/icons/writer.png\");-fx-background-size: auto;-fx-background-repeat: no-repeat;");
        Button c = new Button("Cancel");
        c.setOnMouseClicked(e -> {
            ((Stage) c.getScene().getWindow()).close();
        });
          s.setOnMouseClicked(e -> {
            ((Stage) s.getScene().getWindow()).close();
            
            Notifications.create()
        .darkStyle()
         .title("Notificaiton")
         .text("Votre reclamation a éte ajouté avec succée !  ")
        .hideAfter(Duration.seconds(5))
        .showInformation();
            
            
        });
        c.setPrefWidth(150);
        c.setPrefHeight(43);
        c.setAlignment(Pos.CENTER);
        c.setStyle("-fx-background-color:#c44569;-fx-text-fill:#ecf0f1");

        setPadding(new Insets(20));
        setSpacing(10);
        setStyle("-fx-background-color:#192a56");
        //    main.setStyle("-fx-background-image: url(\"/resources/images/alert.gif\");-fx-background-size: cover;");

        bu.setSpacing(15);

        bu.getChildren().addAll(s, c);
        bu.setAlignment(Pos.CENTER);
        outils.setSpacing(30);
        outils.setAlignment(Pos.CENTER);
        outils.getChildren().addAll(textArea, bu);

        HBox hBox = new HBox();
        hBox.setSpacing(560);
        VBox vBox = new VBox();
        vBox.setSpacing(7);

        ToggleGroup group = new ToggleGroup();
        r1.setToggleGroup(group);
        r2.setToggleGroup(group);
        r3.setToggleGroup(group);
        r4.setToggleGroup(group);
        r5.setToggleGroup(group);
        r6.setToggleGroup(group);
        r7.setToggleGroup(group);
      

        vBox.getChildren().addAll(r1, r2, r3, r4, r5 ,r6 , r7);
        
        hBox.getChildren().addAll(vBox,im);
        getChildren().addAll(login, hBox, outils);

    }

}
