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
public class PageTicketsManagements extends HBox {

    public static PageTicketsManagementsLeft pageAdminProcessJobsLeft;
    public static PageTicketsManagementsRight pageAdminProcessJobsRight;

    public PageTicketsManagements() {
        pageAdminProcessJobsLeft = new PageTicketsManagementsLeft();
        pageAdminProcessJobsRight = new PageTicketsManagementsRight();

        getChildren().addAll(pageAdminProcessJobsLeft, pageAdminProcessJobsRight);
    }

}
