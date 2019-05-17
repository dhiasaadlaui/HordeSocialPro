/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.unit.test.ui;

import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Company;
import tn.esprit.gui.graphic.StatsPerCompany;
import tn.esprit.gui.graphic.TopCompaniesPieChart;
import tn.esprit.gui.pages.PageTicketsManagements;
import tn.esprit.gui.pages.PageModeratorProcessJobs;
import tn.esprit.gui.pages.PageCreateJob;

import tn.esprit.gui.pages.PageJobsBase;
import tn.esprit.gui.pages.PageStats;

/**
 *
 * @author Dhia
 */
public class DhiaApp extends Application {

    public DhiaApp() {
    }

    @Override
    public void start(Stage primaryStage) throws DataBaseException {
        //--------initialisation-----------

        PageModeratorProcessJobs main = new PageModeratorProcessJobs();

        ICompanyDao companyDao = new CompanyDaoImpl();

        Scene GLOBAL_SCENE = new Scene(new PageTicketsManagements());

        //-----------styling----------------
        //------------logic-----------------
        primaryStage.setScene(GLOBAL_SCENE);
        primaryStage.show();

    }

    @Override
    public void stop() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
