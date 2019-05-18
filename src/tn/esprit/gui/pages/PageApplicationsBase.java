package tn.esprit.gui.pages;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Apply;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.items.generic.ItemApplicationBase;
import tn.esprit.gui.launch.App;
import tn.esprit.services.implementation.ServiceApplyImpl;
import tn.esprit.services.interfaces.IServiceApply;

public abstract class PageApplicationsBase extends AnchorPane {

    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final ImageView imageView;
    protected final Label label;
    protected final ImageView imageView0;
    protected final Label label0;
    protected final ImageView imageView1;
    protected final Label label1;
    protected final ImageView imageView2;
    protected final Label label2;
    protected final ImageView imageView3;
    protected final Label label3;
    protected final ImageView imageView4;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final ImageView imageView5;
    IServiceApply serviceApply;
    List<Apply> applications;

    public PageApplicationsBase() {
        serviceApply = new ServiceApplyImpl();
        applications = new ArrayList<>();
       

        if (App.USER_ONLINE.getAuthorization().equalsIgnoreCase("CANDIDATE")) {
            try {
                applications = serviceApply.findAll()
                        .stream()
                        .filter(e -> e.getCandidate().equals(App.USER_ONLINE))
                        .collect(Collectors.toList());
            } catch (DataBaseException ex) {
                Alerts.displayError("Database Error", ex.getMessage());
            }

        } else if (App.USER_ONLINE.getAuthorization().equalsIgnoreCase("RECRUITER")) {
            try {
                applications = serviceApply.findAll()
                        .stream()
                        .filter(e -> e.getJob().getCompany().getRecruiter().equals(App.USER_ONLINE))
                        .collect(Collectors.toList());
            } catch (DataBaseException ex) {
                Alerts.displayError("Database Error", ex.getMessage());
            }

        }

        scrollPane = new ScrollPane();
        vBox = new VBox();
        hBox = new HBox();
        imageView = new ImageView();
        label = new Label();
        imageView0 = new ImageView();
        label0 = new Label();
        imageView1 = new ImageView();
        label1 = new Label();
        imageView2 = new ImageView();
        label2 = new Label();
        imageView3 = new ImageView();
        label3 = new Label();
        imageView4 = new ImageView();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        imageView5 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(582.0);
        setPrefWidth(855.0);
        setStyle("-fx-background-color: #192a56;");
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/resources/css/theme.css");

        scrollPane.setLayoutX(11.0);
        scrollPane.setLayoutY(136.0);

        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setId("applyList");
        vBox.setPrefHeight(424.0);
        vBox.setPrefWidth(828.0);
        vBox.setSpacing(20.0);
        vBox.setStyle("-fx-background-color: E7E7E7; -fx-background-radius: 10;");
        vBox.getStyleClass().add("s");

        hBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hBox.setPrefHeight(54.0);
        hBox.setPrefWidth(776.0);
        hBox.setSpacing(1.0);
        hBox.setStyle("-fx-background-color: #A4A4A4; -fx-background-radius: 10;");

        imageView.setFitHeight(30.0);
        imageView.setFitWidth(40.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/icons/boss.png").toExternalForm()));

        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setPrefHeight(54.0);
        label.setPrefWidth(70.0);
        label.setText("Candidate");
        label.setFont(new Font("Constantia Bold Italic", 14.0));

        imageView0.setFitHeight(30.0);
        imageView0.setFitWidth(40.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/icons/luggage.png").toExternalForm()));

        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setPrefHeight(54.0);
        label0.setPrefWidth(56.0);
        label0.setText("job ");
        label0.setFont(new Font("Constantia Bold Italic", 14.0));

        imageView1.setFitHeight(30.0);
        imageView1.setFitWidth(40.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/resources/icons/boss-2.png").toExternalForm()));

        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setPrefHeight(54.0);
        label1.setPrefWidth(70.0);
        label1.setText("categorie");
        label1.setFont(new Font("Constantia Bold Italic", 14.0));

        imageView2.setFitHeight(30.0);
        imageView2.setFitWidth(40.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/resources/icons/wall-calendar.png").toExternalForm()));

        label2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label2.setPrefHeight(65.0);
        label2.setPrefWidth(100.0);
        label2.setText("Start Date");
        label2.setFont(new Font("Constantia Bold Italic", 14.0));

        imageView3.setFitHeight(30.0);
        imageView3.setFitWidth(40.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/resources/icons/wall-calendar.png").toExternalForm()));

        label3.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label3.setPrefHeight(65.0);
        label3.setPrefWidth(100.0);
        label3.setText("End Date");
        label3.setFont(new Font("Constantia Bold Italic", 14.0));

        imageView4.setFitHeight(29.0);
        imageView4.setFitWidth(40.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("/resources/icons/banker.png").toExternalForm()));

        label4.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label4.setPrefHeight(65.0);
        label4.setPrefWidth(100.0);
        label4.setText("Salary");
        label4.setFont(new Font("Constantia Bold Italic", 14.0));

        label5.setPrefHeight(65.0);
        label5.setPrefWidth(70.0);
        scrollPane.setContent(vBox);

        label6.setLayoutX(300.0);
        label6.setLayoutY(44.0);
        label6.setPrefHeight(36.0);
        label6.setPrefWidth(201.0);

        label6.setText("Applications List");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#d3d3d3"));
        label6.setFont(new Font("Yu Gothic Medium", 24.0));

        imageView5.setFitHeight(81.0);
        imageView5.setFitWidth(93.0);
        imageView5.setLayoutX(221.0);
        imageView5.setLayoutY(21.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("/resources/icons/contract.png").toExternalForm()));
     
        hBox.getChildren().add(imageView);
        hBox.getChildren().add(label);
        hBox.getChildren().add(imageView0);
        hBox.getChildren().add(label0);
        hBox.getChildren().add(imageView1);
        hBox.getChildren().add(label1);
        hBox.getChildren().add(imageView2);
        hBox.getChildren().add(label2);
        hBox.getChildren().add(imageView3);
        hBox.getChildren().add(label3);
        hBox.getChildren().add(imageView4);
        hBox.getChildren().add(label4);
        hBox.getChildren().add(label5);
        vBox.getChildren().add(hBox);
        getChildren().add(scrollPane);
        getChildren().add(label6);
        getChildren().add(imageView5);
           for (Apply application : applications) {
            vBox.getChildren().add(new ItemApplicationBase(application));
        }
       App.GLOBAL_PANE_BORDER.setStyle("-fx-background-image: url(\"/resources/images/background_1.jpg\");-fx-background-repeat: stretch;   \n"
                + "    -fx-background-position: center center;\n"
                + " -fx-background-size: cover, auto;");
    }
}
