package tn.esprit.gui.pages;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Job;
import tn.esprit.entities.JobStatus;
import tn.esprit.gui.launch.App;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceCategoryImpl;
import tn.esprit.services.interfaces.IServiceCategory;
import tn.esprit.services.interfaces.IServiceJob;

public class PageEditJob extends AnchorPane {

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
    protected final TextField textField;
    protected final TextField textField0;
    protected final TextField textField1;
    protected final TextArea textArea;
    protected final TextField textField2;
    protected final DatePicker datePicker;
    protected final Label label5;

    IServiceJob serviceJob;
    IServiceCategory serviceCategory;
    ICompanyDao serviceCompany;

    public PageEditJob(Job jobToEdit) {
        serviceJob = new SerivceJobImpl();
        serviceCategory = new ServiceCategoryImpl();
        serviceCompany = new CompanyDaoImpl();
        getStylesheets().add("/resources/css/theme.css");
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
        textField = new TextField();
        textField0 = new TextField();
        textField1 = new TextField();
        textArea = new TextArea();
        textField2 = new TextField();
        datePicker = new DatePicker();
        label5 = new Label();

        setId("AnchorPane");
        setPrefHeight(582.0);
        setPrefWidth(1300.0);
        setStyle("-fx-background-color: #34495e;");

        vBox.setLayoutX(137.0);
        vBox.setLayoutY(115.0);
        vBox.setPrefHeight(521.0);
        vBox.setPrefWidth(267.0);
        vBox.setSpacing(40.0);

        label.setPrefHeight(4.0);
        label.setPrefWidth(250.0);
        label.setText("Job title : ");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font(15.0));

        label0.setPrefHeight(0.0);
        label0.setPrefWidth(250.0);
        label0.setText("Category :");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font(15.0));

        label1.setPrefHeight(3.0);
        label1.setPrefWidth(250.0);
        label1.setText("Salary :");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(15.0));

        label2.setPrefHeight(0.0);
        label2.setPrefWidth(250.0);
        label2.setText("Description :");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font(15.0));

        label3.setPrefHeight(0.0);
        label3.setPrefWidth(249.0);
        label3.setText("Location : ");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font(15.0));

        label4.setPrefHeight(0.0);
        label4.setPrefWidth(250.0);
        label4.setText("Expire date :");
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setFont(new Font(15.0));

        button.setLayoutX(816.0);
        button.setLayoutY(302.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(88.0);
        button.getStyleClass().add("danger");

        button.setText("Cancel");
        button.setOnMouseClicked(e -> {
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewJob(jobToEdit));
        });
        button0.setLayoutX(816.0);
        button0.setLayoutY(216.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(88.0);
        button0.getStyleClass().add("success");

        button0.setText("Submit");

        textField.setText(jobToEdit.getTitle());
        textField0.setText(jobToEdit.getCategory().getLabel());
        textField1.setText(String.valueOf(jobToEdit.getSalary()));
        textArea.setText(jobToEdit.getDescription());
        textField2.setText(jobToEdit.getLocation());

        button0.setOnMouseClicked(e -> {
            if (datePicker != null) {
                try {
                    //                   Date date = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
//                    System.out.println(datePicker.getValue());
//                    System.out.println(serviceCategory.findByLabel(textField0.getText()));
                    jobToEdit.setTitle(textField.getText());
                    jobToEdit.setCategory(serviceCategory.findByLabel(textField0.getText()));
                    jobToEdit.setSalary(Double.valueOf(textField1.getText()));
                    jobToEdit.setDescription(textArea.getText());
                    jobToEdit.setLocation(textField2.getText());

                    serviceJob.edit(jobToEdit);
                    ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                    ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewJob(serviceJob.findByID(jobToEdit.getId())));
                } catch (DataBaseException | ObjectNotFoundException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Business ERROR");
                    alert.setContentText(ex.getMessage());
                    alert.show();

                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Business ERROR");
                alert.setContentText("cannot submit empty fields");
            }

        }
        );
//        vBox0.getChildren().add(textField);
//        vBox0.getChildren().add(textField0);
//        vBox0.getChildren().add(textField1);
//        vBox0.getChildren().add(textArea);
//        vBox0.getChildren().add(textField2);
//        vBox0.getChildren().add(datePicker);

        vBox0.setLayoutX(
                384.0);
        vBox0.setLayoutY(
                115.0);
        vBox0.setPrefHeight(
                521.0);
        vBox0.setPrefWidth(
                321.0);
        vBox0.setSpacing(
                22.0);

        textField.setPrefHeight(
                2.0);
        textField.setPrefWidth(
                321.0);

        textField0.setPrefHeight(
                2.0);
        textField0.setPrefWidth(
                321.0);

        textArea.setPrefHeight(
                76.0);
        textArea.setPrefWidth(
                321.0);

        label5.setLayoutX(82.0);
        label5.setLayoutY(
                51.0);
        label5.setStyle(
                "-fx-border-color: #4B515D;");
        label5.getStyleClass()
                .add("primary");

        label5.setText(
                "Create new job offer");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#c1cdfc"));
        label5.setFont(
                new Font(30.0));

        vBox.getChildren()
                .add(label);
        vBox.getChildren()
                .add(label0);
        vBox.getChildren()
                .add(label1);
        vBox.getChildren()
                .add(label2);
        vBox.getChildren()
                .add(label3);
        vBox.getChildren()
                .add(label4);
        getChildren()
                .add(vBox);
        getChildren()
                .add(button);
        getChildren()
                .add(button0);
        vBox0.getChildren()
                .add(textField);
        vBox0.getChildren()
                .add(textField0);
        vBox0.getChildren()
                .add(textField1);
        vBox0.getChildren()
                .add(textArea);
        vBox0.getChildren()
                .add(textField2);
        vBox0.getChildren()
                .add(datePicker);
        getChildren()
                .add(vBox0);
        getChildren()
                .add(label5);

    }
}
