package tn.esprit.gui.pages;

import java.net.URL;
import java.text.SimpleDateFormat;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import tn.esprit.entities.Apply;

public class PageViewApplication extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final AnchorPane anchorPane;
    protected final TilePane tilePane;
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
    protected final ScrollPane scrollPane;
    protected final AnchorPane anchorPane0;
    protected final WebView webView;

    public PageViewApplication(Apply application) {

        imageView = new ImageView();
        label = new Label();
        anchorPane = new AnchorPane();
        tilePane = new TilePane();
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
        scrollPane = new ScrollPane();
        anchorPane0 = new AnchorPane();
        webView = new WebView();

        setId("AnchorPane");
        setPrefHeight(628.0);
        setPrefWidth(736.0);
        setStyle("-fx-background-color: #192a56;");
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/resources/css/theme.css");

        imageView.setFitHeight(77.0);
        imageView.setFitWidth(72.0);
        imageView.setLayoutX(259.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/icons/check-mark.png").toExternalForm()));

        label.setLayoutX(338.0);
        label.setLayoutY(43.0);
        label.setPrefHeight(27.0);
        label.setPrefWidth(127.0);
        label.setText(application.getJob().getTitle());
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e7e7e7"));
        label.setFont(new Font(18.0));

        anchorPane.setLayoutX(11.0);
        anchorPane.setLayoutY(103.0);
        anchorPane.setPrefHeight(510.0);
        anchorPane.setPrefWidth(713.0);
        anchorPane.setStyle("-fx-background-color: E7E7E7; -fx-background-radius: 10;");

        tilePane.setLayoutX(8.0);
        tilePane.setLayoutY(10.0);
        tilePane.setPrefColumns(2);
        tilePane.setPrefHeight(372.0);
        tilePane.setPrefWidth(689.0);
        tilePane.setTileAlignment(javafx.geometry.Pos.TOP_LEFT);

        imageView0.setFitHeight(41.0);
        imageView0.setFitWidth(51.0);
        imageView0.setImage(new Image(getClass().getResource("/resources/icons/network.png").toExternalForm()));

        label0.setPrefHeight(38.0);
        label0.setPrefWidth(231.0);
        label0.setStyle("-fx-background-color: D5D5D5; -fx-background-radius: 10;");

        label0.setText("Candidate : " + application.getCandidate().getFirstName() + " " + application.getCandidate().getLastName());
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label0.setFont(new Font(18.0));

        imageView1.setFitHeight(46.0);
        imageView1.setFitWidth(46.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/resources/icons/administrator.png").toExternalForm()));

        label1.setPrefHeight(27.0);
        label1.setPrefWidth(232.0);
        label1.setStyle("-fx-background-color: D5D5D5; -fx-background-radius: 10;");

        label1.setText("Email: " + application.getCandidate().getEmail());
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label1.setFont(new Font(18.0));

        imageView2.setFitHeight(31.0);
        imageView2.setFitWidth(47.0);
        imageView2.setImage(new Image(getClass().getResource("/resources/icons/wall-calendar.png").toExternalForm()));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        label2.setPrefHeight(33.0);
        label2.setPrefWidth(236.0);
        label2.setStyle("-fx-background-color: D5D5D5; -fx-background-radius: 10;");

        label2.setText("Expiration Date: " + sdf.format(application.getJob().getExpireDate()));
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label2.setFont(new Font(18.0));

        imageView3.setFitHeight(48.0);
        imageView3.setFitWidth(41.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/resources/icons/banker.png").toExternalForm()));

        label3.setPrefHeight(38.0);
        label3.setPrefWidth(242.0);
        label3.setStyle("-fx-background-color: D5D5D5; -fx-background-radius: 10;");

        label3.setText("Salary : " + application.getJob().getSalary() + "DT");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label3.setFont(new Font(18.0));

        imageView4.setFitHeight(39.0);
        imageView4.setFitWidth(89.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("/resources/icons/boss-2.png").toExternalForm()));

        label4.setPrefHeight(32.0);
        label4.setPrefWidth(245.0);
        label4.setStyle("-fx-background-color: D5D5D5; -fx-background-radius: 10;");
        label4.setText("Category : JEE");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label4.setFont(new Font(18.0));

        label5.setLayoutX(8.0);
        label5.setLayoutY(382.0);
        label5.setPrefHeight(27.0);
        label5.setPrefWidth(141.0);
        label5.setText("Motivation Letter :");
        label5.setFont(new Font("Franklin Gothic Medium", 18.0));

        scrollPane.setLayoutX(165.0);
        scrollPane.setLayoutY(239.0);
        scrollPane.setPrefHeight(264.0);
        scrollPane.setPrefWidth(536.0);

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(336.0);
        anchorPane0.setPrefWidth(520.0);

        webView.setLayoutX(6.0);
        webView.setLayoutY(6.0);
        webView.setPrefHeight(325.0);
        webView.setPrefWidth(510.0);

        WebEngine webEngine = webView.getEngine();
        webEngine.loadContent(application.getLetter());

        scrollPane.setContent(anchorPane0);

        getChildren().add(imageView);
        getChildren().add(label);
        tilePane.getChildren().add(imageView0);
        tilePane.getChildren().add(label0);
        tilePane.getChildren().add(imageView1);
        tilePane.getChildren().add(label1);
        tilePane.getChildren().add(imageView2);
        tilePane.getChildren().add(label2);
        tilePane.getChildren().add(imageView3);
        tilePane.getChildren().add(label3);
        tilePane.getChildren().add(imageView4);
        tilePane.getChildren().add(label4);
        anchorPane.getChildren().add(tilePane);
        anchorPane.getChildren().add(label5);
        anchorPane0.getChildren().add(webView);
        anchorPane.getChildren().add(scrollPane);
        getChildren().add(anchorPane);

    }
}
