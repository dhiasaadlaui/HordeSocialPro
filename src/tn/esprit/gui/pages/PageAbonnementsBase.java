package tn.esprit.gui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Company;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.items.generic.ItemAbonnementBase;
import tn.esprit.gui.launch.App;
import tn.esprit.services.implementation.ServiceAbonnementImpl;
import tn.esprit.services.interfaces.IServiceAbonnement;

public abstract class PageAbonnementsBase extends AnchorPane {

    protected final ScrollPane scrollPane;
    protected final VBox vBox;

    IServiceAbonnement serviceAbonnement;

    public PageAbonnementsBase() {
        serviceAbonnement = new ServiceAbonnementImpl();

        scrollPane = new ScrollPane();
        vBox = new VBox();

        setId("AnchorPane");
        setPrefHeight(623.0);
        setPrefWidth(1123.0);
        setStyle("-fx-background-color: #34495e;");

        scrollPane.setLayoutX(275.0);
        scrollPane.setLayoutY(14.0);
        scrollPane.setPrefHeight(598.0);
        scrollPane.setPrefWidth(583.0);
        scrollPane.setStyle("-fx-background-color: transparent;");

        vBox.setId("abonnementsList");
        vBox.setPrefHeight(710.0);
        vBox.setPrefWidth(546.0);
        vBox.setSpacing(10.0);
        vBox.setStyle("-fx-background-color: transparent;");

        List<Company> companies = new ArrayList<>();
        try {
            companies = serviceAbonnement.findAll()
                    .stream()
                    .filter(e -> e.getCandidate().equals(App.USER_ONLINE))
                    .map(e -> e.getCompany())
                    .collect(Collectors.toList());
        } catch (DataBaseException ex) {
            Alerts.displayError("Data Error", ex.getMessage());
        }

        for (Company company : companies) {
            vBox.getChildren().add(new ItemAbonnementBase(company) {
            });
        }

        scrollPane.setContent(vBox);

        getChildren().add(scrollPane);

    }
}
