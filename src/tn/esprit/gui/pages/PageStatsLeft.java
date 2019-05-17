/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import javafx.scene.control.TableColumn;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.gui.graphic.StatsPerCompany;
import tn.esprit.gui.graphic.TopCompaniesPieChart;

/**
 *
 * @author mdsaadlaoui
 */
public class PageStatsLeft extends VBox {

    static HBox searchPane;
    static TextField txtSearch;
    static Button btnSearch;
    static TableView<Company> table;
    ICompanyDao companyDao;
    static ObservableList<Company> companyList;
    static Company SELECTED_COMPANY;
    static TopCompaniesPieChart topCompaniesPieChart;

    public PageStatsLeft() {
        topCompaniesPieChart = new TopCompaniesPieChart();
        Label labelTitle = new Label("Companies overview");

        labelTitle.setStyle("-fx-font-size:20px;-fx-text-fill:#FFF");
        setAlignment(Pos.CENTER);
        companyDao = new CompanyDaoImpl();
        getStylesheets().add("/resources/css/theme.css");
        
        txtSearch = new TextField();
        btnSearch = new Button("search");
        btnSearch.getStyleClass().add("primary");
        table = new TableView();

        searchPane = new HBox();
        companyList = FXCollections.observableArrayList();
        searchPane.setStyle("-fx-background-color:#34495e");
        setStyle("-fx-background-color:#34495e");
        this.setSpacing(15);
        this.setPadding(new Insets(15));
        this.setAlignment(Pos.CENTER);

        TableColumn<Company, String> columnTitle = new TableColumn("Name");
        columnTitle.setCellValueFactory(new PropertyValueFactory<>("name"));

        table.getColumns().addAll(columnTitle);

        try {
            companyList = FXCollections.observableArrayList(companyDao.findAll());
        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data error");
            alert.setContentText(ex.getMessage());
        }
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {

                PageStats.statsPerCompany.refresh(newSelection);
            }
        });

        table.setItems(companyList);
        table.setPrefWidth(800);
        table.setPrefHeight(800);
        columnTitle.setPrefWidth(500);
        searchPane.getChildren().addAll(txtSearch, btnSearch);
        getChildren().add(labelTitle);
        getChildren().addAll(searchPane, table,topCompaniesPieChart);

    }

}
