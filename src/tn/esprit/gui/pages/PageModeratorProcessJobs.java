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
public class PageModeratorProcessJobs extends HBox {

    public static PageModeratorProcessJobsLeft pageAdminProcessJobsLeft;
    public static PageModeratorProcessJobsRight pageAdminProcessJobsRight;

    public PageModeratorProcessJobs() {
        pageAdminProcessJobsLeft = new PageModeratorProcessJobsLeft();
        pageAdminProcessJobsRight = new PageModeratorProcessJobsRight();

        getChildren().addAll(pageAdminProcessJobsLeft, pageAdminProcessJobsRight);
    }

}
