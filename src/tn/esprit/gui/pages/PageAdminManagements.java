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
public class PageAdminManagements extends HBox {

    public static PageAdminManagementsLeft pageAdminProcessJobsLeft;
    public static PageAdminManagementsRight pageAdminProcessJobsRight;

    public PageAdminManagements() {
        pageAdminProcessJobsLeft = new PageAdminManagementsLeft();
        pageAdminProcessJobsRight = new PageAdminManagementsRight();

        getChildren().addAll(pageAdminProcessJobsLeft, pageAdminProcessJobsRight);
    }

}
