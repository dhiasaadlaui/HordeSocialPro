package tn.esprit.gui.pages;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class PageAccountSettingsBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final VBox vBox;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final VBox vBox0;
    protected final TextField textField;
    protected final TextField textField0;
    protected final TextField textField1;
    protected final TextField textField2;
    protected final TextField textField3;
    protected final TextField textField4;
    protected final Button button;
    protected final Button button0;
    protected final AnchorPane anchorPane0;
    protected final ImageView imageView0;
    protected final VBox vBox1;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final VBox vBox2;
    protected final TextField textField5;
    protected final TextField textField6;
    protected final TextField textField7;
    protected final TextField textField8;
    protected final Button button1;
    protected final Button button2;

    public PageAccountSettingsBase() {

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        vBox = new VBox();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        vBox0 = new VBox();
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();
        textField2 = new TextField();
        textField3 = new TextField();
        textField4 = new TextField();
        button = new Button();
        button0 = new Button();
        anchorPane0 = new AnchorPane();
        imageView0 = new ImageView();
        vBox1 = new VBox();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        vBox2 = new VBox();
        textField5 = new TextField();
        textField6 = new TextField();
        textField7 = new TextField();
        textField8 = new TextField();
        button1 = new Button();
        button2 = new Button();

        setId("AnchorPane");
        setPrefHeight(554.0);
        setPrefWidth(984.0);
        setStyle("-fx-background-color: #34495e;");
        getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");

        anchorPane.setId("userpane");
        anchorPane.setLayoutX(-1.0);
        anchorPane.setPrefHeight(554.0);
        anchorPane.setPrefWidth(442.0);

        imageView.setFitHeight(88.0);
        imageView.setFitWidth(88.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../../resources/icons/boss-1.png").toExternalForm()));

        vBox.setLayoutX(34.0);
        vBox.setLayoutY(113.0);
        vBox.setPrefHeight(239.0);
        vBox.setPrefWidth(119.0);
        vBox.setSpacing(15.0);

        label.setPrefHeight(22.0);
        label.setPrefWidth(60.0);
        label.setText("nom :");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(18.0));

        label0.setPrefHeight(27.0);
        label0.setPrefWidth(82.0);
        label0.setText("prenom :");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(18.0));

        label1.setPrefHeight(27.0);
        label1.setPrefWidth(110.0);
        label1.setText("old password");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(18.0));

        label2.setPrefHeight(27.0);
        label2.setPrefWidth(118.0);
        label2.setText("new password");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font(18.0));

        label3.setPrefHeight(27.0);
        label3.setPrefWidth(82.0);
        label3.setText("email :");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font(18.0));

        label4.setPrefHeight(27.0);
        label4.setPrefWidth(82.0);
        label4.setText("Adress:");
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setFont(new Font(18.0));

        vBox0.setLayoutX(181.0);
        vBox0.setLayoutY(112.0);
        vBox0.setSpacing(10.0);

        textField.setText("firstName");

        textField0.setText("lastname");

        textField1.setText("passs");

        textField2.setText("pass");

        textField3.setText("mail");

        textField4.setText("adress");

        button.setLayoutX(245.0);
        button.setLayoutY(433.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("danger");
        button.setText("Cancel");

        button0.setLayoutX(120.0);
        button0.setLayoutY(433.0);
        button0.setMnemonicParsing(false);
        button0.getStyleClass().add("success");
        button0.setText("Submit");

        anchorPane0.setId("companyPane");
        anchorPane0.setLayoutX(422.0);
        anchorPane0.setLayoutY(14.0);

        imageView0.setFitHeight(110.0);
        imageView0.setFitWidth(88.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../../../resources/icons/flats.png").toExternalForm()));

        vBox1.setLayoutX(63.0);
        vBox1.setLayoutY(102.0);
        vBox1.setPrefHeight(234.0);
        vBox1.setPrefWidth(101.0);
        vBox1.setSpacing(15.0);

        label5.setPrefHeight(22.0);
        label5.setPrefWidth(60.0);
        label5.setText("nom :");
        label5.setTextFill(javafx.scene.paint.Color.WHITE);
        label5.setFont(new Font(18.0));

        label6.setPrefHeight(27.0);
        label6.setPrefWidth(107.0);
        label6.setText("description :");
        label6.setTextFill(javafx.scene.paint.Color.WHITE);
        label6.setFont(new Font(18.0));

        label7.setPrefHeight(27.0);
        label7.setPrefWidth(88.0);
        label7.setText("domain :");
        label7.setTextFill(javafx.scene.paint.Color.WHITE);
        label7.setFont(new Font(18.0));

        label8.setPrefHeight(27.0);
        label8.setPrefWidth(82.0);
        label8.setText("adress :");
        label8.setTextFill(javafx.scene.paint.Color.WHITE);
        label8.setFont(new Font(18.0));

        vBox2.setLayoutX(216.0);
        vBox2.setLayoutY(102.0);
        vBox2.setSpacing(10.0);

        textField5.setText("companyName");

        textField6.setText("Description");

        textField7.setText("domain");

        textField8.setText("adress");

        button1.setLayoutX(174.0);
        button1.setLayoutY(418.0);
        button1.setMnemonicParsing(false);
        button1.getStyleClass().add("success");
        button1.setText("Submit");

        button2.setLayoutX(292.0);
        button2.setLayoutY(418.0);
        button2.setMnemonicParsing(false);
        button2.getStyleClass().add("danger");
        button2.setText("Cancel");

        anchorPane.getChildren().add(imageView);
        vBox.getChildren().add(label);
        vBox.getChildren().add(label0);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(label3);
        vBox.getChildren().add(label4);
        anchorPane.getChildren().add(vBox);
        vBox0.getChildren().add(textField);
        vBox0.getChildren().add(textField0);
        vBox0.getChildren().add(textField1);
        vBox0.getChildren().add(textField2);
        vBox0.getChildren().add(textField3);
        vBox0.getChildren().add(textField4);
        anchorPane.getChildren().add(vBox0);
        anchorPane.getChildren().add(button);
        anchorPane.getChildren().add(button0);
        getChildren().add(anchorPane);
        anchorPane0.getChildren().add(imageView0);
        vBox1.getChildren().add(label5);
        vBox1.getChildren().add(label6);
        vBox1.getChildren().add(label7);
        vBox1.getChildren().add(label8);
        anchorPane0.getChildren().add(vBox1);
        vBox2.getChildren().add(textField5);
        vBox2.getChildren().add(textField6);
        vBox2.getChildren().add(textField7);
        vBox2.getChildren().add(textField8);
        anchorPane0.getChildren().add(vBox2);
        anchorPane0.getChildren().add(button1);
        anchorPane0.getChildren().add(button2);
        getChildren().add(anchorPane0);

    }
}
