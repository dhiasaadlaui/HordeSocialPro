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
import tn.esprit.entities.Reclamation;
import static tn.esprit.gui.pages.PageTicketsManagementsRight.countPredicate;
import static tn.esprit.gui.pages.PageTicketsManagementsRight.gauge;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.interfaces.IServiceJob;
import tn.esprit.services.interfaces.IServiceReclamation;

/**
 *
 * @author mdsaadlaoui
 */
public class PageTicketsManagementsLeft extends VBox {
    
    static HBox searchPane;
    static TextField txtSearch;
    static Button btnSearch;
    static TableView<Reclamation> table;
    IServiceReclamation serviceReclamation;
    static ObservableList<Reclamation> reclamationList;
    static Reclamation SELECTED_RECLAMATION;
    
    public PageTicketsManagementsLeft() {
        this.getStylesheets().add("/resources/css/theme.css");
        txtSearch = new TextField();
        btnSearch = new Button("search");
        btnSearch.getStyleClass().add("primary");
        table = new TableView();
        serviceReclamation = new ServiceReclamationImpl();
        searchPane = new HBox();
        reclamationList = FXCollections.observableArrayList();
        searchPane.setStyle("-fx-background-color:#34495e");
        setStyle("-fx-background-color:#34495e");
        this.setSpacing(15);
        this.setPadding(new Insets(15));
        this.setAlignment(Pos.CENTER);
        
        TableColumn<Reclamation, String> columnType = new TableColumn("Type");
        columnType.setCellValueFactory(new PropertyValueFactory<>("type"));
        
        TableColumn<Reclamation, String> columnStatus = new TableColumn("Status");
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        TableColumn<Reclamation, String> columnFeedback = new TableColumn("FeedBack");
        columnFeedback.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        
        table.getColumns().addAll(columnType, columnStatus, columnFeedback);
        
        try {
            reclamationList = FXCollections.observableArrayList(serviceReclamation.findAll());
        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data error");
            alert.setContentText(ex.getMessage());
        }
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                SELECTED_RECLAMATION = newSelection;
                PageTicketsManagementsRight.reclamationTitle.setText(SELECTED_RECLAMATION.getJob().getTitle());
                PageTicketsManagementsRight.reclamationCategory.setText(SELECTED_RECLAMATION.getJob().getCategory().getLabel());
                PageTicketsManagementsRight.reclamationDescription.setText(SELECTED_RECLAMATION.getDetails());
                PageTicketsManagementsRight.salary.setText(SELECTED_RECLAMATION.getJob().getSalary().toString());
                try {
                    gauge.setValue(serviceReclamation.findAll().stream().filter(countPredicate).count());
                } catch (DataBaseException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(ex.getMessage());
                    alert.setTitle(ex.getMessage());
                    alert.show();
                }
            }
        });
        
        table.setItems(reclamationList);
        table.setPrefWidth(800);
        table.setPrefHeight(800);
        columnType.setPrefWidth(300);
        columnFeedback.setPrefWidth(400);
        
        searchPane.getChildren().addAll(txtSearch, btnSearch);
        getChildren().addAll(searchPane, table);
        
    }
    
}
