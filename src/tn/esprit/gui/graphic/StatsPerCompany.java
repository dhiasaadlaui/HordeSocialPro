/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.graphic;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import tn.esprit.entities.Company;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Job;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceAbonnementImpl;
import tn.esprit.services.implementation.ServiceApplyImpl;
import tn.esprit.services.interfaces.IServiceAbonnement;
import tn.esprit.services.interfaces.IServiceApply;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author mdsaadlaoui
 */
public class StatsPerCompany extends VBox {

    final static String spacer1 = "spacer1";
    final static String spacer2 = "spacer2";
    final static String spacer3 = "spacer3";
    final static String spacer4 = "spacer3";
    private List<Job> listJobs;
    private List<Apply> listApplies;
    private List<Abonnement> listAbonnements;

    IServiceAbonnement serviceAbonnement;
    IServiceApply serviceApply;
    IServiceJob serviceJob;

  

    public StatsPerCompany(Company company) {
        refresh(company);

    }

    public void refresh(Company company) {
        this.getChildren().removeAll();
        serviceAbonnement = new ServiceAbonnementImpl();
        serviceApply = new ServiceApplyImpl();
        serviceJob = new SerivceJobImpl();

        listJobs = new ArrayList<>();
        listApplies = new ArrayList<>();
        listAbonnements = new ArrayList<>();

        try {
            listJobs = serviceJob.findByCompany(company);
            listApplies = serviceApply.findAll().stream().filter(e -> e.getJob().getCompany().equals(company)).collect(Collectors.toList());
            listAbonnements = serviceAbonnement.findByCompany(company);
        } catch (ObjectNotFoundException | DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText(ex.getMessage());
        }

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc
                = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle(company.getName());
        xAxis.setLabel("Achievements");
        yAxis.setLabel("Counts");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Applies");
        series1.getData().add(new XYChart.Data("_", listApplies.size()));
        series1.getData().add(new XYChart.Data(spacer1, 0));
        series1.getData().add(new XYChart.Data(spacer2, 0));
        series1.getData().add(new XYChart.Data(spacer3, 0));
        series1.getData().add(new XYChart.Data(spacer4, 0));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Abonnements");
        series2.getData().add(new XYChart.Data("_", listAbonnements.size()));
        series2.getData().add(new XYChart.Data(spacer1, 0));
        series2.getData().add(new XYChart.Data(spacer2, 0));
        series2.getData().add(new XYChart.Data(spacer3, 0));
        series2.getData().add(new XYChart.Data(spacer4, 0));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Job offers");
        series3.getData().add(new XYChart.Data("_", listJobs.size()));
        series3.getData().add(new XYChart.Data(spacer1, 0));
        series3.getData().add(new XYChart.Data(spacer2, 0));
        series3.getData().add(new XYChart.Data(spacer3, 0));
        series3.getData().add(new XYChart.Data(spacer4, 0));

        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(500),
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (XYChart.Series<String, Number> series : bc.getData()) {
                    for (XYChart.Data<String, Number> data : series.getData()) {
                        data.setXValue("_");
                    }
                }
            }
        }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();

        bc.getData().addAll(series1, series2, series3);

        this.getChildren().add(bc);

    }

}
