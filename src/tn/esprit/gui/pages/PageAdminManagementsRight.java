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
import tn.esprit.entities.User;
import static tn.esprit.gui.pages.PageAdminManagementsLeft.usersList;
import tn.esprit.services.exceptions.ConstraintViolationException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceUserImpl;
import tn.esprit.services.interfaces.IServiceUser;

/**
 *
 * @author mdsaadlaoui
 */
public class PageAdminManagementsRight extends VBox {

    static Label fullName;
    static Label accountStatus;
    static Label userAuthorization;
    static Text adress;
    static Gauge gauge;

    Button btnAccept;
    Button btnReject;
    IServiceUser serviceUser;
    
    static Predicate<User> countPredicate = e -> e.getAccountStatus().equals("ADMINISTRATOR");

    public PageAdminManagementsRight() {
        serviceUser = new ServiceUserImpl();

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
        fullName = new Label("Job Title");
        fullName.setStyle("-fx-text-fill: white;");
        accountStatus = new Label("Job Categorie");
        accountStatus.setStyle("-fx-text-fill: white;");
        userAuthorization = new Label("2500 EUR");
        userAuthorization.setStyle("-fx-text-fill: white;");
        adress = new Text("description");
        adress.setFill(Color.WHITE);
        setStyle("-fx-background-color:#34495e");

        btnAccept = new Button("BAN USER");
        btnAccept.setPrefWidth(150);
        btnReject = new Button("PROMOTE TO ADMIN");
        btnReject.setPrefWidth(150);

        adress.wrappingWidthProperty().set(300);
        try {

            List<User> allUsers = serviceUser.findAll();
            gauge.setValue(allUsers.stream().filter(countPredicate).count());

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
                    serviceUser.banUser(PageAdminManagementsLeft.SELECTED_USER,"banned");
                    
                    List<User> allUsers = serviceUser.findAll();
                    gauge.setValue(allUsers.stream().filter(countPredicate).count());
                    usersList.removeAll(allUsers);
                    usersList = FXCollections.observableArrayList(allUsers);
                    PageAdminManagementsLeft.table.setItems(usersList);

                }
            } catch (ConstraintViolationException | DataBaseException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(ex.getMessage());
                alert.setTitle(ex.getMessage());
                alert.show();
            }
        });
        btnReject.getStyleClass().add("danger");

        Region spacer = new Region();
        spacer.setPrefHeight(200);
        getChildren().addAll(fullName, accountStatus, userAuthorization, adress, spacer, btnAccept, btnReject, gauge);
    }

}
