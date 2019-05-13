/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.launch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import tn.esprit.gui.login.LoginGUI;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tn.esprit.entities.User;

/**
 *
 * @author Dhia
 */
public class App extends Application {

    /**
     *
     */
    public static User USER_ONLINE = null;

    /**
     *
     */
    public static LoginGUI LOGIN_GUI;

    /**
     *
     */
    public static Scene GLOBAL_SCENE;

    /**
     *
     */
    public static Stage GLOBAL_STAGE;

    /**
     *
     */
    public static BorderPane GLOBAL_PANE_BORDER;

    @Override
    public void start(Stage primaryStage) {
        GLOBAL_STAGE = new Stage();
        GLOBAL_PANE_BORDER = new BorderPane();

        LOGIN_GUI = new LoginGUI();

        GLOBAL_SCENE = new Scene(GLOBAL_PANE_BORDER);

        Image applicationIcon = new Image(getClass().getResourceAsStream("/resources/images/horde.png"));
        GLOBAL_STAGE.getIcons().add(applicationIcon);
        GLOBAL_STAGE.setResizable(false);
        GLOBAL_STAGE.setTitle("Social Pro");
        //-----------styling----------------
        GLOBAL_PANE_BORDER.setStyle("-fx-background-color: #7f8c8d;");
        GLOBAL_PANE_BORDER.setCenter(LOGIN_GUI);
        VBox main = new VBox(); // la division de notre ecran totlae
        //   HBox te = new HBox() ;
        ImageView logoLarge = new ImageView(new Image(getClass().getResourceAsStream("/resources/images/azer.png")));
        logoLarge.setFitWidth(320);
        logoLarge.setFitHeight(330);
        main.setStyle("-fx-background-color:#34495e;");
        // ProgressIndicator a = new ProgressIndicator() ;
        ProgressBar a = new ProgressBar();

        IntegerProperty seconds = new SimpleIntegerProperty();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        a.progressProperty().bind(seconds.divide(60.0));
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.minutes(0.08), e -> {
                    // do anything you need here on completion...
                    GLOBAL_STAGE.setScene(GLOBAL_SCENE);
                    GLOBAL_STAGE.show();
                    System.out.println("5 sec over");
                    primaryStage.close();
                    timeline.stop();
                }, new KeyValue(seconds, 60)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        a.setMinWidth(300);
        a.setMinHeight(25);

        main.setAlignment(Pos.CENTER);
        Label statusLabel = new Label();
        //      statusLabel.setText("Loading ... ");
        statusLabel.setStyle("-fx-font-size:25px;-fx-text-fill:#d2dae2");

        //    te.getChildren().addAll(a) ;
        main.getChildren().addAll(logoLarge, a, statusLabel);
        Scene scene = new Scene(main);
        primaryStage.setScene(scene);
        primaryStage.show();

        //--------initialisation-----------
        //------------logic-----------------
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
