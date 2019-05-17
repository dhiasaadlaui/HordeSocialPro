/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import eu.hansolo.medusa.Gauge;
import eu.hansolo.medusa.Gauge.SkinType;
import eu.hansolo.medusa.GaugeBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import static tn.esprit.gui.pages.PageModeratorProcessJobsLeft.jobsList;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author mdsaadlaoui
 */
public class PageModeratorProcessJobsRight extends VBox {

    static Label jobTitle;
    static Label jobCategory;
    static Label salary;
    static Text jobDescription;
    static Gauge gauge;

    Button btnAccept;
    Button btnReject;
    IServiceJob serviceJob;
    static Predicate<Job> countPredicate = e -> e.getStatus().equals("PENDING");

    public PageModeratorProcessJobsRight() {
        serviceJob = new SerivceJobImpl();

        gauge = GaugeBuilder.create().skinType(SkinType.MODERN)
                .decimals(0)
                .minValue(0)
                .maxValue(20)
                .autoScale(false)
                .unit("Pending")
                .value(0)
                .animated(true)
                .build();

        this.getStylesheets().add("/resources/css/theme.css");
        jobTitle = new Label("Job Title");
        jobTitle.setStyle("-fx-text-fill: white;");
        jobCategory = new Label("Job Categorie");
        jobCategory.setStyle("-fx-text-fill: white;");
        salary = new Label("2500 EUR");
        salary.setStyle("-fx-text-fill: white;");
        jobDescription = new Text("description");
        jobDescription.setFill(Color.WHITE);
        setStyle("-fx-background-color:#34495e");

        btnAccept = new Button("Accept");
        btnAccept.setPrefWidth(150);
        btnReject = new Button("Reject");
        btnReject.setPrefWidth(150);

        jobDescription.wrappingWidthProperty().set(300);
        try {

            List<Job> allJobs = serviceJob.findAll();
            gauge.setValue(allJobs.stream().filter(countPredicate).count());

        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.setTitle(ex.getMessage());
            alert.show();
        }
        this.setSpacing(15);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        btnAccept.getStyleClass().add("success");
        btnAccept.setOnMouseClicked(e -> {
            try {
                Alert alert = new Alert(AlertType.CONFIRMATION, "Confirm selected job " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    serviceJob.jobActivation(PageModeratorProcessJobsLeft.SELECTED_JOB);
                    List<Job> allJobs = serviceJob.findAll();
                    gauge.setValue(allJobs.stream().filter(countPredicate).count());
                    jobsList.removeAll(allJobs);
                    jobsList = FXCollections.observableArrayList(allJobs);
                    PageModeratorProcessJobsLeft.table.setItems(jobsList);

                }
            } catch (ConstraintViolationException | DataBaseException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ex.getMessage());
                alert.setTitle(ex.getMessage());
                alert.show();
            }
        });
        btnReject.getStyleClass().add("danger");
        btnReject.setOnMouseClicked(e -> {
            try {
                Alert alert = new Alert(AlertType.CONFIRMATION, "Disable selected job " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {

                    serviceJob.jobDisable(PageModeratorProcessJobsLeft.SELECTED_JOB);
                    List<Job> allJobs = serviceJob.findAll();
                    gauge.setValue(allJobs.stream().filter(countPredicate).count());
                    jobsList.removeAll(allJobs);
                    jobsList = FXCollections.observableArrayList(allJobs);
                    PageModeratorProcessJobsLeft.table.setItems(jobsList);
                }

            } catch (ConstraintViolationException | DataBaseException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ex.getMessage());
                alert.setTitle(ex.getMessage());
                alert.show();
            }
        });
        Region spacer = new Region();
        spacer.setPrefHeight(200);
        getChildren().addAll(jobTitle, jobCategory, salary, jobDescription, spacer, btnAccept, btnReject, gauge);
    }

}
