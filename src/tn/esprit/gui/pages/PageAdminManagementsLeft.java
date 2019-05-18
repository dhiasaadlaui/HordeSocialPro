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
import tn.esprit.entities.User;
import static tn.esprit.gui.pages.PageAdminManagementsRight.countPredicate;
import static tn.esprit.gui.pages.PageAdminManagementsRight.gauge;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceJob;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author mdsaadlaoui
 */
public class PageAdminManagementsLeft extends VBox {

    static HBox searchPane;
    static TextField txtSearch;
    static Button btnSearch;
    static TableView<User> table;
    IServiceUser serviceUser;
    static ObservableList<User> usersList;
    static User SELECTED_USER;

    public PageAdminManagementsLeft() {
        this.getStylesheets().add("/resources/css/theme.css");
        txtSearch = new TextField();
        btnSearch = new Button("search");
        btnSearch.getStyleClass().add("primary");
        table = new TableView();
        serviceUser = new ServiceUserImpl();
        searchPane = new HBox();
        usersList = FXCollections.observableArrayList();
        searchPane.setStyle("-fx-background-color:#34495e");
        setStyle("-fx-background-color:#34495e");
        this.setSpacing(15);
        this.setPadding(new Insets(15));
        this.setAlignment(Pos.CENTER);

        TableColumn<User, String> columnUsername = new TableColumn("Username");
        columnUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));

   

        table.getColumns().add(columnUsername);

        try {
            usersList = FXCollections.observableArrayList(serviceUser.findAll());
        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data error");
            alert.setContentText(ex.getMessage());
        }
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                SELECTED_USER = newSelection;
    
                try {
                    gauge.setValue(serviceUser.findAll().stream().filter(countPredicate).count());
                } catch (DataBaseException ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(ex.getMessage());
                    alert.setTitle(ex.getMessage());
                    alert.show();
                }
            }
        });

        table.setItems(usersList);
        table.setPrefWidth(800);
        table.setPrefHeight(800);
        columnUsername.setPrefWidth(500);
        searchPane.getChildren().addAll(txtSearch, btnSearch);
        getChildren().addAll(searchPane, table);

    }

}
