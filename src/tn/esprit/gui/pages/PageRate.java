/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import tn.esprit.entities.Rate;
import tn.esprit.gui.launch.App;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.ServiceRateImpl;
import tn.esprit.services.interfaces.IServiceRate;

/**
 *
 * @author mmsarray
 */
public class PageRate extends VBox {

    private boolean flag = true;
    private TitledPane scrate;
    private ImageView img;
    private ImageView Starimg;
    private HBox rateHbox;
    private List<Rate> rateList;

    public PageRate(Job job) {
        HBox outils = new HBox(); // la division de notre ecran totlae
        VBox bu = new VBox();
        Rating rt = new Rating();
        rateList = new ArrayList();
        scrate = new TitledPane();
        IServiceRate rateServ = new ServiceRateImpl();;

        Alert alert2 = new Alert(AlertType.INFORMATION);
        /**
         * *************************************************
         */
        Label login = new Label("Rate this job !" + job.getTitle());
        login.setStyle("-fx-font-size:29px;-fx-text-fill:#CAD3C8");

        try {
            rateList = rateServ.findByJob(job);
            // prepareTitlePane(rateList);
        } catch (ObjectNotFoundException ex) {
            Logger.getLogger(PageRate.class.getName()).log(Level.SEVERE, null, ex);
        }
        rt.setStyle("-fx-font-size:15px;-fx-text-fill:#d2dae2");

        TextArea textArea = new TextArea();

        textArea.setPromptText("Ajoutez un feedback ! ");
        ImageView im = new ImageView(new Image(getClass().getResourceAsStream("/resources/icons/ancient.png")));

        im.setFitHeight(100);
        im.setFitWidth(100);
        prepareTitlePane(rateList);
        textArea.setFont(new Font(15));
        Button s = new Button("Submit");
        s.setPrefWidth(150);
        s.setPrefHeight(43);
        s.setAlignment(Pos.CENTER);
        s.setStyle("-fx-background-color:#218c74;-fx-text-fill:#ecf0f1");
        s.setOnMouseClicked(e -> {
            Rate rat = new Rate.Builder().job(job).candidate(App.USER_ONLINE).feedback(textArea.getText()).note(rt.getRating()).build();
            try {
                rateServ.create(rat);
                try {
                    rateList = rateServ.findByJob(job);
                } catch (ObjectNotFoundException ex) {
                    Logger.getLogger(PageRate.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (DataBaseException ex) {
                Logger.getLogger(PageRate.class.getName()).log(Level.SEVERE, null, ex);

                alert2.setAlertType(AlertType.ERROR);
                alert2.setTitle("Rating");
                String addedContent = "Sorry you already rated this job. ";
                alert2.setContentText(addedContent);
                alert2.showAndWait();
                flag = false;

            }

            if (flag) {
                alert2.setTitle("Rating");
                String addedContent = "Thanks your rate has been submitted. ";
                alert2.setContentText(addedContent);
                alert2.showAndWait();

            }

        });

        textArea.setPadding(new Insets(40));
        textArea.setStyle("-fx-background-color:#dcdde1");
        textArea.setStyle("-fx-background-image: url(\"/resources/icons/writer.png\");-fx-background-size: auto;-fx-background-repeat: no-repeat;");
        Button c = new Button("Cancel");
        c.setOnMouseClicked(e -> {
            ((Stage) c.getScene().getWindow()).close();
        });
        c.setPrefWidth(150);
        c.setPrefHeight(43);
        c.setAlignment(Pos.CENTER);
        c.setStyle("-fx-background-color:#c44569;-fx-text-fill:#ecf0f1");

        setPadding(new Insets(20));
        setSpacing(10);
        setStyle("-fx-background-color:#192a56");

        bu.setSpacing(15);

        bu.getChildren().addAll(s, c);
        bu.setAlignment(Pos.CENTER);
        outils.setSpacing(30);
        outils.setAlignment(Pos.CENTER);

        outils.getChildren().addAll(scrate, textArea, bu);

        HBox hBox = new HBox();
        hBox.setSpacing(560);
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        rt.setPartialRating(true);
        vBox.getChildren().addAll(rt);
        hBox.getChildren().addAll(vBox, im);
        getChildren().addAll(login, hBox, outils);
    }

    public void prepareTitlePane(List<Rate> rateList) {

        scrate.setStyle(".titled-pane > .title\n"
                + "{\n"
                + "    -fx-background-color: rgba(0, 60, 136, 0.5);\n"
                + "    -fx-border-color: rgba(0, 60, 136, 0.8);\n"
                + "    -fx-font-family: 'Lucida Grande',Verdana,Geneva,Lucida,Arial,Helvetica,sans-serif;\n"
                + "    -fx-font-size: 16px;\n"
                + "    -fx-font-weight: bold;\n"
                + "}\n"
                + "\n"
                + "\n"
                + ".titled-pane > .title > .text\n"
                + "{\n"
                + "    -fx-fill: WHITE;\n"
                + "}");
        if (!rateList.isEmpty()) {
            rateHbox = new HBox();
            scrate.setText(rateList.get(0).getJob().getTitle());
            scrate.setPrefWidth(370);
            ImageView im = new ImageView(new Image(getClass().getResourceAsStream("/resources/images/icons8_star_512px.png")));
            im.setFitWidth(60);
            im.setFitHeight(65);
            rateHbox.getChildren().add(im);
            VBox hachvox = new VBox();
            Label rateScore = new Label(Math.round(rateList.stream().mapToDouble(e -> e.getNote()).sum()) + " Stars!!");
            hachvox.getChildren().add(rateScore);
            Label rateTimes = new Label("This Job Has Been rated " + rateList.size() + " times.");
            hachvox.getChildren().add(rateTimes);
            rateHbox.getChildren().add(hachvox);

        } else {
            rateHbox = new HBox();
            HBox hachbox = new HBox();
            hachbox.getChildren().add(new Label("This job has no rate"));
            rateHbox.getChildren().add(hachbox);
        }
        scrate.setContent(rateHbox);

    }

}
