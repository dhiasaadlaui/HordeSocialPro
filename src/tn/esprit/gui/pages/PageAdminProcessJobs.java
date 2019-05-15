/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import javafx.scene.layout.HBox;

/**
 *
 * @author mdsaadlaoui
 */
public class PageAdminProcessJobs extends HBox {

    public static PageAdminProcessJobsLeft pageAdminProcessJobsLeft;
    public static PageAdminProcessJobsRight pageAdminProcessJobsRight;

    public PageAdminProcessJobs() {
        pageAdminProcessJobsLeft = new PageAdminProcessJobsLeft();
        pageAdminProcessJobsRight = new PageAdminProcessJobsRight();

        getChildren().addAll(pageAdminProcessJobsLeft, pageAdminProcessJobsRight);
    }

}
