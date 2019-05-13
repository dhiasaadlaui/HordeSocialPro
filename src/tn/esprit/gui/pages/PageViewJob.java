package tn.esprit.gui.pages;

import tn.esprit.gui.items.generic.ItemCommentBase;
import java.lang.String;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class PageViewJob extends VBox {
    
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
    protected final Label label10;
    protected final Label label11;
    protected final Label label12;
    protected final TextArea textArea;
    protected final VBox vBox;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final TitledPane titledPane;
    protected final ScrollPane scrollPane;
    protected final VBox commentsList;
    
    public PageViewJob() {
        
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        label10 = new Label();
        label11 = new Label();
        label12 = new Label();
        textArea = new TextArea();
        vBox = new VBox();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        titledPane = new TitledPane();
        scrollPane = new ScrollPane();
        commentsList = new VBox();
        
        setPrefHeight(478.0);
        setPrefWidth(1200.0);
        setStyle("-fx-background-color: #34495e;");
        getStylesheets().add("/resources/css/theme.css");
        setPadding(new Insets(20));
        
        anchorPane.setPrefHeight(231.0);
        anchorPane.setPrefWidth(618.0);
        
        imageView.setFitHeight(100.0);
        imageView.setFitWidth(100.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResourceAsStream("/resources/images/defaultcompany.jpg")));
        
        label.setLayoutX(131.0);
        label.setLayoutY(14.0);
        label.setStyle("-fx-text-fill: #FFFF;");
        label.setText("Vermeg");
        label.setFont(new Font(35.0));
        
        label0.setLayoutX(131.0);
        label0.setLayoutY(65.0);
        label0.setStyle("-fx-text-fill: #FFFF;");
        label0.setText("Job Title: Software developer");
        
        label1.setLayoutX(659.0);
        label1.setLayoutY(14.0);
        label1.setText("Salary : 3000 EUR");
        label1.getStyleClass().add("danger");
        label1.getStyleClass().add("button");
        
        label2.setLayoutX(131.0);
        label2.setLayoutY(100.0);
        label2.setStyle("-fx-text-fill: #FFFF;");
        label2.setText("Recruiter:");
        
        label3.setLayoutX(131.0);
        label3.setLayoutY(137.0);
        label3.setStyle("-fx-text-fill: #FFFF;");
        label3.setText("Creation date:");
        
        label4.setLayoutX(131.0);
        label4.setLayoutY(119.0);
        label4.setStyle("-fx-text-fill: #FFFF;");
        label4.setText("Category:");
        
        label5.setLayoutX(131.0);
        label5.setLayoutY(155.0);
        label5.setStyle("-fx-text-fill: #FFFF;");
        label5.setText("Expire date:");
        
        label6.setLayoutX(131.0);
        label6.setLayoutY(173.0);
        label6.setStyle("-fx-text-fill: #FFFF;");
        label6.setText("Location:");
        
        label7.setLayoutX(131.0);
        label7.setLayoutY(191.0);
        label7.setStyle("-fx-text-fill: #FFFF;");
        label7.setText("Description:");
        
        label8.setLayoutX(227.0);
        label8.setLayoutY(100.0);
        label8.setStyle("-fx-text-fill: #FFFF;");
        label8.setText("Chiraz Fellah");
        
        label9.setLayoutX(227.0);
        label9.setLayoutY(119.0);
        label9.setStyle("-fx-text-fill: #FFFF;");
        label9.setText("Informatique");
        
        label10.setLayoutX(227.0);
        label10.setLayoutY(137.0);
        label10.setStyle("-fx-text-fill: #FFFF;");
        label10.setText("01/05/2019");
        
        label11.setLayoutX(227.0);
        label11.setLayoutY(155.0);
        label11.setStyle("-fx-text-fill: #FFFF;");
        label11.setText("02/06/2019");
        
        label12.setLayoutX(227.0);
        label12.setLayoutY(173.0);
        label12.setStyle("-fx-text-fill: #FFFF;");
        label12.setText("Tunis, Tunisia");
        
        textArea.setEditable(false);
        textArea.setLayoutX(227.0);
        textArea.setLayoutY(200.0);
        textArea.setPrefHeight(51.0);
        textArea.setPrefWidth(346.0);
        textArea.setText("Vermeg looking for software developer with 2 years experience , with java entreprise edition");
        
        vBox.setLayoutX(609.0);
        vBox.setLayoutY(84.0);
        vBox.setSpacing(5.0);
        
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(150.0);
        button.getStyleClass().add("primary");
        button.setText("Appy");
        
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(150.0);
        button0.getStyleClass().add("primary");
        button0.setText("Edit");
        
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(32.0);
        button1.setPrefWidth(76.0);
        button1.getStyleClass().add("warning");
        button1.setText("Repport");
        button1.setOnMouseClicked(e -> {
            Stage claimStage = new Stage();
            Scene claimScene = new Scene(new PageCreateClaim());
            claimStage.setScene(claimScene);
            claimStage.show();
        });
        
        titledPane.setAnimated(false);
        titledPane.setExpanded(false);
        titledPane.setPrefHeight(500.0);
        titledPane.setPrefWidth(582.0);
        titledPane.getStyleClass().add("warning");
        titledPane.setText("Comments (5)");
        
        commentsList.setPrefHeight(500.0);
        commentsList.setPrefWidth(785.0);
        
        TextArea textNewComment = new TextArea();
        textNewComment.setEditable(true);
        textNewComment.setLayoutX(72.0);
        textNewComment.setLayoutY(17.0);
        textNewComment.setPrefHeight(59.0);
        textNewComment.setPrefWidth(600.0);
        textNewComment.setPromptText("Say some thing ...");
        
        Button btnComment = new Button("Send");
        btnComment.getStyleClass().add("primary");
        
        HBox newCommentBox = new HBox(20, textNewComment, btnComment);
        newCommentBox.setPadding(new Insets(10));
        newCommentBox.setAlignment(Pos.BASELINE_LEFT);
        
        commentsList.getChildren().add(newCommentBox);
        for (int i = 0; i < 5; i++) {
            commentsList.getChildren().add(new ItemCommentBase() {
            });
        }
        scrollPane.setContent(commentsList);
        titledPane.setContent(scrollPane);
        
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        anchorPane.getChildren().add(label5);
        anchorPane.getChildren().add(label6);
        anchorPane.getChildren().add(label7);
        anchorPane.getChildren().add(label8);
        anchorPane.getChildren().add(label9);
        anchorPane.getChildren().add(label10);
        anchorPane.getChildren().add(label11);
        anchorPane.getChildren().add(label12);
        anchorPane.getChildren().add(textArea);
        vBox.getChildren().add(button);
        vBox.getChildren().add(button0);
        vBox.getChildren().add(button1);
        anchorPane.getChildren().add(vBox);
        getChildren().add(anchorPane);
        getChildren().add(titledPane);
        
    }
}
