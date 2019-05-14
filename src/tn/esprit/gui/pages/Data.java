/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import tn.esprit.entities.Comment;
import tn.esprit.entities.Notification;
import tn.esprit.services.implementation.ServiceNotificationImpl;
import tn.esprit.services.interfaces.IServiceNotification;

/**
 * FXML Controller class
 *
 * @author Mehdi Sarray
 */
public class Data{
    @FXML
    private HBox hBox;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    private ImageView imageView;
    private IServiceNotification notif  ;
    private VBox verticalBox;
    /**
     * Initializes the controller class.
     */
  
    public Data()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("listCellitem.fxml"));
        fxmlLoader.setController(this);
        notif = new ServiceNotificationImpl();
        verticalBox = new VBox();
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Class<?> clazz = this.getClass();
 
        InputStream input = clazz.getResourceAsStream("/resources/images/icons8_important_mail_96px_3.png");
        Image image = new Image(input);
        imageView = new ImageView(image);
        imageView.setFitWidth(40);
	imageView.setFitHeight(40);
        imageView.setStyle("-fx-border-radius: 50;");
        hBox.setStyle("-fx-border-radius: 50;");
        
    }

    public void setInfo(Notification notif)
    {
     
       
        label1.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");
        label1.setText(notif.getDate().format(DateTimeFormatter.ISO_DATE_TIME));
        label2.setText("a new comment has been submitted in your Job "+notif.getJob().getTitle());
        label1.setWrapText(true);
    label2.setStyle("-fx-font-family: \"Comic Sans MS\"; -fx-font-size: 20; -fx-text-fill: darkred;");
    label2.setWrapText(true);
    
    }

    public HBox getBox(Notification notif)
    {
        setInfo(notif);
        verticalBox.getChildren().add(label1);
        verticalBox.getChildren().add(label2);
        hBox.getChildren().addAll(imageView,verticalBox);
        return hBox;
    }
    
}
