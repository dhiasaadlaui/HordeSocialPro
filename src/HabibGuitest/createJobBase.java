package HabibGuitest;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public abstract class createJobBase extends AnchorPane {

    protected final VBox vBox;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Button button;
    protected final Button button0;
    protected final VBox vBox0;
    protected final Label label5;
    protected final TextField textField;
    protected final Label label6;
    protected final TextField textField0;
    protected final Label label7;
    protected final TextField textField1;
    protected final Label label8;
    protected final TextArea textArea;
    protected final Label label9;
    protected final TextField textField2;
    protected final Label label10;
    protected final DatePicker datePicker;

    public createJobBase() {

        vBox = new VBox();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        button = new Button();
        button0 = new Button();
        vBox0 = new VBox();
        label5 = new Label();
        textField = new TextField();
        label6 = new Label();
        textField0 = new TextField();
        label7 = new Label();
        textField1 = new TextField();
        label8 = new Label();
        textArea = new TextArea();
        label9 = new Label();
        textField2 = new TextField();
        label10 = new Label();
        datePicker = new DatePicker();

        setId("AnchorPane");
        setPrefHeight(788.0);
        setPrefWidth(808.0);

        vBox.setLayoutX(137.0);
        vBox.setLayoutY(24.0);
        vBox.setPrefHeight(612.0);
        vBox.setPrefWidth(267.0);

        label.setPrefHeight(100.0);
        label.setPrefWidth(250.0);
        label.setText("Job title : ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(15.0));

        label0.setPrefHeight(100.0);
        label0.setPrefWidth(250.0);
        label0.setText("Category :");
        label0.setFont(new Font(15.0));

        label1.setPrefHeight(100.0);
        label1.setPrefWidth(250.0);
        label1.setText("Salary :");
        label1.setFont(new Font(15.0));

        label2.setPrefHeight(100.0);
        label2.setPrefWidth(250.0);
        label2.setText("Description :");
        label2.setFont(new Font(15.0));

        label3.setPrefHeight(100.0);
        label3.setPrefWidth(249.0);
        label3.setText("Location : ");
        label3.setFont(new Font(15.0));

        label4.setPrefHeight(100.0);
        label4.setPrefWidth(250.0);
        label4.setText("Expire date :");
        label4.setFont(new Font(15.0));

        button.setLayoutX(449.0);
        button.setLayoutY(668.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(88.0);
        button.getStyleClass().add("primary");
        button.getStylesheets().add("/HabibGuitest/../resources/css/theme.css");
        button.setText("Cancel");

        button0.setLayoutX(281.0);
        button0.setLayoutY(668.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(88.0);
        button0.getStyleClass().add("primary");
        button0.getStylesheets().add("/HabibGuitest/../resources/css/theme.css");
        button0.setText("Post");

        vBox0.setLayoutX(384.0);
        vBox0.setLayoutY(24.0);
        vBox0.setPrefHeight(612.0);
        vBox0.setPrefWidth(321.0);

        label5.setPrefHeight(31.0);
        label5.setPrefWidth(98.0);

        textField.setPrefHeight(31.0);
        textField.setPrefWidth(267.0);

        label6.setPrefHeight(73.0);
        label6.setPrefWidth(65.0);

        label7.setPrefHeight(68.0);
        label7.setPrefWidth(56.0);

        label8.setPrefHeight(66.0);
        label8.setPrefWidth(71.0);

        textArea.setPrefHeight(90.0);
        textArea.setPrefWidth(290.0);

        label9.setPrefHeight(39.0);
        label9.setPrefWidth(76.0);

        label10.setPrefHeight(63.0);
        label10.setPrefWidth(70.0);

        vBox.getChildren().add(label);
        vBox.getChildren().add(label0);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(label3);
        vBox.getChildren().add(label4);
        getChildren().add(vBox);
        getChildren().add(button);
        getChildren().add(button0);
        vBox0.getChildren().add(label5);
        vBox0.getChildren().add(textField);
        vBox0.getChildren().add(label6);
        vBox0.getChildren().add(textField0);
        vBox0.getChildren().add(label7);
        vBox0.getChildren().add(textField1);
        vBox0.getChildren().add(label8);
        vBox0.getChildren().add(textArea);
        vBox0.getChildren().add(label9);
        vBox0.getChildren().add(textField2);
        vBox0.getChildren().add(label10);
        vBox0.getChildren().add(datePicker);
        getChildren().add(vBox0);

    }
}
