package tn.esprit.gui.pages;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public abstract class PageViewReclamModeratorBase extends AnchorPane {

    protected final ImageView imageView;
    protected final TitledPane titledPane;
    protected final AnchorPane anchorPane;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;

    public PageViewReclamModeratorBase() {

        imageView = new ImageView();
        titledPane = new TitledPane();
        anchorPane = new AnchorPane();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();

        setId("AnchorPane");
        setPrefHeight(701.0);
        setPrefWidth(986.0);
        setStyle("-fx-background-color: #2C3A47;");

        imageView.setFitHeight(87.0);
        imageView.setFitWidth(129.0);
        imageView.setLayoutX(116.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../../resources/images/defaultcompany.jpg").toExternalForm()));

        titledPane.setAnimated(false);
        titledPane.setLayoutX(248.0);
        titledPane.setLayoutY(14.0);
        titledPane.setPrefHeight(294.0);
        titledPane.setPrefWidth(711.0);
        titledPane.setText("Comments");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(262.0);
        anchorPane.setPrefWidth(402.0);

        scrollPane.setLayoutX(-1.0);
        scrollPane.setLayoutY(7.0);
        scrollPane.setPrefHeight(263.0);
        scrollPane.setPrefWidth(711.0);

        vBox.setPrefHeight(474.0);
        vBox.setPrefWidth(689.0);
        scrollPane.setContent(vBox);
        titledPane.setContent(anchorPane);

        label.setLayoutX(23.0);
        label.setLayoutY(132.0);
        label.setText("Status");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label0.setLayoutX(123.0);
        label0.setLayoutY(132.0);
        label0.setText("OPEN");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label1.setLayoutX(23.0);
        label1.setLayoutY(169.0);
        label1.setText("Company");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label2.setLayoutX(123.0);
        label2.setLayoutY(169.0);
        label2.setText("companyName");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label3.setLayoutX(25.0);
        label3.setLayoutY(209.0);
        label3.setText("Recruiter");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label4.setLayoutX(123.0);
        label4.setLayoutY(209.0);
        label4.setText("recruiterName");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label5.setLayoutX(25.0);
        label5.setLayoutY(253.0);
        label5.setText("Title");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label6.setLayoutX(123.0);
        label6.setLayoutY(253.0);
        label6.setText("JobTitle");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        button.setLayoutX(506.0);
        button.setLayoutY(619.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(171.0);
        button.getStyleClass().add("danger");
        button.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button.setText("DisableJob");
          button.setOnMouseClicked(e -> {
            ((Stage) button.getScene().getWindow()).close();
            
            Notifications.create()
        .darkStyle()
         .title("Notificaiton")
         .text("La publication a été désactivé avec succées !  ")
        .hideAfter(Duration.seconds(5))
        .showConfirm();
            
            
        });
        
        
        
        
        
        
        button0.setLayoutX(281.0);
        button0.setLayoutY(619.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(171.0);
        button0.getStyleClass().add("success");
        button0.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button0.setText("Reject");
   button0.setOnMouseClicked(e -> {
            ((Stage) button0.getScene().getWindow()).close();
            
            Notifications.create()
        .darkStyle()
         .title("Notificaiton")
         .text("la reclamation est rejecté !  ")
        .hideAfter(Duration.seconds(5))
        .showError();
            
            
        });
        button1.setLayoutX(506.0);
        button1.setLayoutY(550.0);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(32.0);
        button1.setPrefWidth(171.0);
        button1.getStyleClass().add("danger");
        button1.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button1.setText("RemoveComment");
          button1.setOnMouseClicked(e -> {
            ((Stage) button1.getScene().getWindow()).close();
            
            Notifications.create()
        .darkStyle()
         .title("Notificaiton")
         .text("Le commentaire a été désactivé avec succées !  ")
        .hideAfter(Duration.seconds(5))
        .showWarning();
            
            
        });
        
        
        
        
        
        
        button2.setLayoutX(281.0);
        button2.setLayoutY(549.0);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(32.0);
        button2.setPrefWidth(171.0);
        button2.getStyleClass().add("primary");
        button2.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button2.setText("Redirect");
           button2.setOnMouseClicked(e -> {
            ((Stage) button2.getScene().getWindow()).close();
            
            Notifications.create()
        .darkStyle()
         .title("Notificaiton")
         .text("Le reclamation est redirigé vers l'administrateur !  ")
        .hideAfter(Duration.seconds(5))
        .showError();
            
            
        });
        getChildren().add(imageView);
        anchorPane.getChildren().add(scrollPane);
        getChildren().add(titledPane);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(label6);
        getChildren().add(button);
        getChildren().add(button0);
        getChildren().add(button1);
        getChildren().add(button2);

    }
}
