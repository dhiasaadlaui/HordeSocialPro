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
import tn.esprit.entities.Reclamation;
import static tn.esprit.gui.pages.PageTicketsManagementsLeft.reclamationList;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.HandleReclamationAdmin;
import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.interfaces.IServiceReclamation;

/**
 *
 * @author mdsaadlaoui
 */
public class PageTicketsManagementsRight extends VBox {

    static Label reclamationTitle;
    static Label reclamationCategory;
    static Label salary;
    static Text reclamationDescription;
    static Gauge gauge;

    Button btnBan;
    Button btnReject;
    IServiceReclamation serviceReclamation;
    static Predicate<Reclamation> countPredicate = e -> e.getStatus().equalsIgnoreCase("REDIRECTED");

    public PageTicketsManagementsRight() {
        serviceReclamation = new ServiceReclamationImpl();

        gauge = GaugeBuilder.create().skinType(SkinType.MODERN)
                .decimals(0)
                .minValue(0)
                .maxValue(20)
                .autoScale(false)
                .unit("REDIRECTED")
                .value(0)
                .animated(true)
                .build();

        this.getStylesheets().add("/resources/css/theme.css");
        reclamationTitle = new Label("Reclamation Title");
        reclamationTitle.setStyle("-fx-text-fill: white;");
        reclamationCategory = new Label("Reclamation Categorie");
        reclamationCategory.setStyle("-fx-text-fill: white;");
        salary = new Label("2500 EUR");
        salary.setStyle("-fx-text-fill: white;");
        reclamationDescription = new Text("description");
        reclamationDescription.setFill(Color.WHITE);
        setStyle("-fx-background-color:#34495e");

        btnBan = new Button("Ban user");
        btnBan.setPrefWidth(150);
        btnReject = new Button("Reject");
        btnReject.setPrefWidth(150);

        reclamationDescription.wrappingWidthProperty().set(300);
        try {

            List<Reclamation> allReclamations = serviceReclamation.findAll();
            gauge.setValue(allReclamations.stream().filter(countPredicate).count());

        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(ex.getMessage());
            alert.setTitle(ex.getMessage());
            alert.show();
        }
        this.setSpacing(15);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        btnBan.getStyleClass().add("success");
        btnBan.setOnMouseClicked(e -> {
            try {
                Alert alert = new Alert(AlertType.CONFIRMATION, "Confirm selected reclamation " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {
                    serviceReclamation.handleAdmin(PageTicketsManagementsLeft.SELECTED_RECLAMATION, HandleReclamationAdmin.BAN);
                    List<Reclamation> allReclamations = serviceReclamation.findAll();
                    gauge.setValue(allReclamations.stream().filter(countPredicate).count());
                    reclamationList.removeAll(allReclamations);
                    reclamationList = FXCollections.observableArrayList(allReclamations);
                    PageTicketsManagementsLeft.table.setItems(reclamationList);

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
                Alert alert = new Alert(AlertType.CONFIRMATION, "Disable selected reclamation " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                alert.showAndWait();

                if (alert.getResult() == ButtonType.YES) {

                     serviceReclamation.handleAdmin(PageTicketsManagementsLeft.SELECTED_RECLAMATION, HandleReclamationAdmin.REJECT);
                    List<Reclamation> allReclamations = serviceReclamation.findAll();
                    gauge.setValue(allReclamations.stream().filter(countPredicate).count());
                    reclamationList.removeAll(allReclamations);
                    reclamationList = FXCollections.observableArrayList(allReclamations);
                    PageTicketsManagementsLeft.table.setItems(reclamationList);
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
        getChildren().addAll(reclamationTitle, reclamationCategory, salary, reclamationDescription, spacer, btnBan, btnReject, gauge);
    }

}
