/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import static tn.esprit.gui.pages.PageAdminProcessJobsRight.countPredicate;
import static tn.esprit.gui.pages.PageAdminProcessJobsRight.gauge;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author mdsaadlaoui
 */
public class PageAdminProcessJobsLeft extends VBox {

    static HBox searchPane;
    static TextField txtSearch;
    static Button btnSearch;
    static TableView<Job> table;
    IServiceJob serviceJob;
    static ObservableList<Job> jobsList;
    static Job SELECTED_JOB;

    public PageAdminProcessJobsLeft() {
        this.getStylesheets().add("/resources/css/theme.css");
        txtSearch = new TextField();
        btnSearch = new Button("search");
        btnSearch.getStyleClass().add("primary");
        table = new TableView();
        serviceJob = new SerivceJobImpl();
        searchPane = new HBox();
        jobsList = FXCollections.observableArrayList();
        searchPane.setStyle("-fx-background-color:#34495e");
        setStyle("-fx-background-color:#34495e");
        this.setSpacing(15);
        this.setPadding(new Insets(15));
        this.setAlignment(Pos.CENTER);

        TableColumn<Job, String> columnTitle = new TableColumn("Title");
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Job, String> columnCompany = new TableColumn("Company");
        columnCompany.setCellValueFactory(new PropertyValueFactory<>("companyName"));

        TableColumn<Job, String> columnStatus = new TableColumn("Status");
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.getColumns().addAll(columnTitle, columnCompany, columnStatus);

        try {
            jobsList = FXCollections.observableArrayList(serviceJob.findAll());
        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data error");
            alert.setContentText(ex.getMessage());
        }
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                SELECTED_JOB = newSelection;
                PageAdminProcessJobsRight.jobTitle.setText(SELECTED_JOB.getTitle());
                PageAdminProcessJobsRight.jobCategory.setText(SELECTED_JOB.getTitle());
                PageAdminProcessJobsRight.jobDescription.setText(SELECTED_JOB.getTitle());
                PageAdminProcessJobsRight.salary.setText(SELECTED_JOB.getSalary().toString());
                try {
                    gauge.setValue(serviceJob.findAll().stream().filter(countPredicate).count());
                } catch (DataBaseException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(ex.getMessage());
                    alert.setTitle(ex.getMessage());
                    alert.show();
                }
            }
        });

        table.setItems(jobsList);
        table.setPrefWidth(800);
        table.setPrefHeight(800);
        columnTitle.setPrefWidth(500);
        searchPane.getChildren().addAll(txtSearch, btnSearch);
        getChildren().addAll(searchPane, table);

    }

}
