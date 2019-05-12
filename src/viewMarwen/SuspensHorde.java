/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewMarwen;

import com.sun.javaws.progress.Progress;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mghozzi
 */
public class SuspensHorde extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox main = new VBox(); // la division de notre ecran totlae
     //   HBox te = new HBox() ;
        ImageView logoLarge = new ImageView(new Image(getClass().getResourceAsStream("/resources/images/azer.png")));
       logoLarge.setFitWidth(320);
        logoLarge.setFitHeight(330);
        main.setStyle("-fx-background-color:#34495e;");
           // ProgressIndicator a = new ProgressIndicator() ;
             ProgressBar a = new ProgressBar();
             
             
              IntegerProperty seconds = new SimpleIntegerProperty();
              
               a.progressProperty().bind(seconds.divide(60.0));
                Timeline timeline = new Timeline(
        new KeyFrame(Duration.ZERO, new KeyValue(seconds, 0)),
        new KeyFrame(Duration.minutes(0.5), e-> {
            // do anything you need here on completion...
            System.out.println("Minute over");
        }, new KeyValue(seconds, 60))   
    );
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();
   

              
    a.setMinWidth(300);
    a.setMinHeight(25);
           
          
           
           
           
           
        main.setAlignment(Pos.CENTER);
        Label statusLabel = new Label();
   //      statusLabel.setText("Loading ... ");
       statusLabel.setStyle("-fx-font-size:25px;-fx-text-fill:#d2dae2");
        
        
        
        
        
      
    //    te.getChildren().addAll(a) ;
          main.getChildren().addAll(logoLarge ,a, statusLabel );
        Scene scene = new Scene(main);
        
     
        
        primaryStage.setScene(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }
}
