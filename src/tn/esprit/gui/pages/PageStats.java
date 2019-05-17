/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Company;
import tn.esprit.gui.graphic.StatsPerCompany;

/**
 *
 * @author mdsaadlaoui
 */
public class PageStats extends HBox {

    public static StatsPerCompany statsPerCompany;
    public static PageStatsLeft pageStatsLeft;

    public static void setCompany(Company company) {
        statsPerCompany = new StatsPerCompany(company);
    }

    public PageStats() {
        setStyle("-fx-background-image: url(\"/resources/images/background_1.jpg\");-fx-background-repeat: stretch;   \n"
                + "    -fx-background-position: center center;\n"
                + " -fx-background-size: cover, auto;");
        setPrefWidth(1300.0);
        ICompanyDao companyDao = new CompanyDaoImpl();
        pageStatsLeft = new PageStatsLeft();
        try {
            statsPerCompany = new StatsPerCompany(companyDao.findAll().get((0)));
        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ERROR");
            alert.setContentText(ex.getMessage());
        }

        getChildren().addAll(pageStatsLeft, statsPerCompany);

    }

}
