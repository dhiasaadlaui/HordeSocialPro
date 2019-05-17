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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.interfaces.IServiceJob;

/**
 *
 * @author mdsaadlaoui
 */
public class TopCompaniesPieChart extends Group {

    ICompanyDao serviceCompany;
    IServiceJob serviceJob;

    public TopCompaniesPieChart() {
        getStylesheets().add("/resources/css/stylesheet.css");
        serviceCompany = new CompanyDaoImpl();
        serviceJob = new SerivceJobImpl();

        //Preparing ObservbleList object         
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        List<Company> listCompanies = new ArrayList<>();
        List<Job> jobs = new ArrayList<>();

        try {
            listCompanies = serviceCompany.findAll();
            for (Company company : listCompanies) {
                jobs = serviceJob.findByCompany(company);
                pieChartData.add(new PieChart.Data(company.getName(), jobs.size()));
            }
        } catch (DataBaseException | ObjectNotFoundException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data error");
            alert.setContentText(ex.getMessage());
            alert.show();
        }

        //Creating a Pie chart 
        PieChart pieChart = new PieChart(pieChartData);

        //Setting the title of the Pie chart 
        pieChart.setTitle("Total job offers");

        //setting the direction to arrange the data 
        pieChart.setClockwise(true);

        //Setting the length of the label line 
        pieChart.setLabelLineLength(50);

        //Setting the labels of the pie chart visible  
        pieChart.setLabelsVisible(true);

        //Setting the start angle of the pie chart  
        pieChart.setStartAngle(180);
        pieChart.getStylesheets().add("/resources/css/stylesheet.css");

        this.getChildren().add(pieChart);

    }

}
