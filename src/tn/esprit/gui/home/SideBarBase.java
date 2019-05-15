package tn.esprit.gui.home;

import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.login.LoginGUI;
import tn.esprit.gui.pages.PageJobsBase;
import tn.esprit.gui.pages.PageReclamationsBase;
import tn.esprit.gui.pages.PageViewNotification;

public abstract class SideBarBase extends VBox {

    protected final ImageView imageView;
    protected final Label label;
    protected final Separator separator;
    protected final Label label0;
    protected final HBox hBox;
    protected final ImageView imageView0;
    protected final Label label1;
    protected final HBox hBox0;
    protected final ImageView imageView1;
    protected final Label label2;
    protected final HBox hBox1;
    protected final ImageView imageView2;
    protected final HBox hBoxNotif;
    protected final ImageView imageViewNotif;
    protected final Label labelNotif;
    protected final Label label3;
    protected final HBox hBox2;
    protected final ImageView imageView3;
    protected final Label label4;
    protected final HBox hBox3;
    protected final ImageView imageView4;
    protected final Label label5;
    protected final HBox hBox4;
    protected final ImageView imageView5;
    protected final Label label6;
    protected final Label label7;
    protected final TilePane tilePane;
    protected final VBox vBox;
    protected final ImageView imageView6;
    protected final Label label8;
    protected final VBox vBox0;
    protected final ImageView imageView7;
    protected final Label label9;
    protected final VBox vBox1;
    protected final ImageView imageView8;
    protected final Label label10;
    protected final VBox vBox2;
    protected final ImageView imageView9;
    protected final Label label11;
    protected final VBox vBoxNotif;
    private PageViewNotification pvn = new PageViewNotification(App.USER_ONLINE);
   

    public SideBarBase() {

        imageView = new ImageView();
        label = new Label();
        separator = new Separator();
        label0 = new Label();
        hBox = new HBox();
        imageView0 = new ImageView();
        label1 = new Label();
        hBox0 = new HBox();
        imageView1 = new ImageView();
        label2 = new Label();
        hBox1 = new HBox();
        imageView2 = new ImageView();
        label3 = new Label();
        hBox2 = new HBox();
        imageView3 = new ImageView();
        label4 = new Label();
        hBox3 = new HBox();
        imageView4 = new ImageView();
        label5 = new Label();
        hBox4 = new HBox();
        imageView5 = new ImageView();
        label6 = new Label();
        label7 = new Label();
        tilePane = new TilePane();
        vBox = new VBox();
        imageView6 = new ImageView();
        label8 = new Label();
        vBox0 = new VBox();
        imageView7 = new ImageView();
        label9 = new Label();
        vBox1 = new VBox();
        imageView8 = new ImageView();
        label10 = new Label();
        vBox2 = new VBox();
        imageView9 = new ImageView();
        label11 = new Label();
        hBoxNotif = new HBox();
        imageViewNotif = new ImageView();
        labelNotif = new Label();
        vBoxNotif = new VBox();
         

        setAlignment(javafx.geometry.Pos.TOP_CENTER);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(800.0);
        setPrefWidth(311.0);
        getStyleClass().add("sidebar");
        getStylesheets().add("/resources/css/stylesheet.css");
        imageView.setFitHeight(136.0);
        imageView.setFitWidth(196.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/images/profile-1.png").toExternalForm()));
        VBox.setMargin(imageView, new Insets(10.0, 0.0, 0.0, 0.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setPrefHeight(38.0);
        label.setPrefWidth(220.0);
        label.setStyle("-fx-text-fill: #b8b1b1;");
        label.setText(App.USER_ONLINE.getFirstName()+" "+App.USER_ONLINE.getLastName());
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(19.0));

        separator.setPrefWidth(200.0);
        VBox.setMargin(separator, new Insets(20.0, 0.0, 0.0, 0.0));

        label0.setPrefHeight(25.0);
        label0.setPrefWidth(360.0);
        label0.setStyle("-fx-text-fill: #b8b1b1; -fx-background-color: rgb(80,80,88);");
        label0.setText("         Main");
        label0.setFont(new Font(16.0));

        hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox.setPrefHeight(12.0);
        hBox.setPrefWidth(204.0);
        hBox.setSpacing(20.0);
        hBox.getStyleClass().add("sidebar-user-btn");

        imageView0.setFitHeight(51.0);
        imageView0.setFitWidth(52.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/images/home_14773.png").toExternalForm()));

        label1.setPrefHeight(38.0);
        label1.setPrefWidth(220.0);
        label1.setStyle("-fx-text-fill: #b8b1b1;");
        label1.setText("Home");
        label1.setFont(new Font(19.0));
        hBox.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        hBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox0.setPrefHeight(12.0);
        hBox0.setPrefWidth(204.0);
        hBox0.setSpacing(20.0);
        hBox0.getStyleClass().add("sidebar-user-btn");

        imageView1.setFitHeight(51.0);
        imageView1.setFitWidth(52.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/resources/images/file_edit_14809.png").toExternalForm()));

        label2.setPrefHeight(53.0);
        label2.setPrefWidth(275.0);
        label2.setStyle("-fx-text-fill: #b8b1b1;");
        label2.setText("Applications");
        label2.setFont(new Font(19.0));
        hBox0.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox1.setPrefHeight(12.0);
        hBox1.setPrefWidth(204.0);
        hBox1.setSpacing(20.0);
        hBox1.getStyleClass().add("sidebar-user-btn");

        imageView2.setFitHeight(51.0);
        imageView2.setFitWidth(52.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/resources/images/heart_14746.png").toExternalForm()));

        label3.setPrefHeight(38.0);
        label3.setPrefWidth(220.0);
        label3.setStyle("-fx-text-fill: #b8b1b1;");
        label3.setText("Favoris");
        label3.setFont(new Font(19.0));
        hBox1.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));
        
        hBoxNotif.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBoxNotif.setPrefHeight(12.0);
        hBoxNotif.setPrefWidth(204.0);
        hBoxNotif.setSpacing(20.0);
        hBoxNotif.getStyleClass().add("sidebar-user-btn");
        
        imageViewNotif.setFitHeight(51.0);
        imageViewNotif.setFitWidth(52.0);
        imageViewNotif.setPickOnBounds(true);
        imageViewNotif.setPreserveRatio(true);
        imageViewNotif.setImage(new Image(getClass().getResource("/resources/images/icons8_Alarm_96px.png").toExternalForm()));
        
        labelNotif.setPrefHeight(53.0);
        labelNotif.setPrefWidth(275.0);
        labelNotif.setStyle("-fx-text-fill: #b8b1b1;");
        labelNotif.setText("Notification("+PageViewNotification.NotifNumber+")");
        labelNotif.setFont(new Font(19.0));
        hBoxNotif.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));
        
        
        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setPrefHeight(12.0);
        hBox2.setPrefWidth(204.0);
        hBox2.setSpacing(20.0);
        hBox2.getStyleClass().add("sidebar-user-btn");

        imageView3.setFitHeight(51.0);
        imageView3.setFitWidth(52.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/resources/images/plus_14756.png").toExternalForm()));

        label4.setPrefHeight(38.0);
        label4.setPrefWidth(220.0);
        label4.setStyle("-fx-text-fill: #b8b1b1;");
        label4.setText("Reclamations");
        label4.setFont(new Font(19.0));
        hBox2.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox3.setPrefHeight(12.0);
        hBox3.setPrefWidth(204.0);
        hBox3.setSpacing(20.0);
        hBox3.getStyleClass().add("sidebar-user-btn");

        imageView4.setFitHeight(51.0);
        imageView4.setFitWidth(52.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("/resources/images/configuration_1_14712.png").toExternalForm()));

        label5.setPrefHeight(38.0);
        label5.setPrefWidth(220.0);
        label5.setStyle("-fx-text-fill: #b8b1b1;");
        label5.setText("Settings");
        label5.setFont(new Font(19.0));
        hBox3.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        hBox4.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox4.setPrefHeight(12.0);
        hBox4.setPrefWidth(204.0);
        hBox4.setSpacing(20.0);
        hBox4.getStyleClass().add("sidebar-user-btn");

        imageView5.setFitHeight(51.0);
        imageView5.setFitWidth(52.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("/resources/images/close_14776.png").toExternalForm()));

        label6.setPrefHeight(38.0);
        label6.setPrefWidth(220.0);
        label6.setStyle("-fx-text-fill: #b8b1b1;");
        label6.setText("Log out");
        label6.setFont(new Font(19.0));
        hBox4.setPadding(new Insets(0.0, 0.0, 0.0, 10.0));

        label7.setPrefHeight(25.0);
        label7.setPrefWidth(452.0);
        label7.setStyle("-fx-text-fill: #b8b1b1; -fx-background-color: rgb(80,80,88);");
        label7.setText("         Administration");
        label7.setFont(new Font(16.0));

        tilePane.setPrefHeight(253.0);
        tilePane.setPrefWidth(333.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(104.0);
        vBox.setPrefWidth(141.0);
        vBox.getStyleClass().add("sidebar-user-btn");

        imageView6.setFitHeight(86.0);
        imageView6.setFitWidth(81.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("/resources/icons/bars-chart.png").toExternalForm()));

        label8.setAlignment(javafx.geometry.Pos.CENTER);
        label8.setPrefHeight(38.0);
        label8.setPrefWidth(220.0);
        label8.setStyle("-fx-text-fill: #b8b1b1;");
        label8.setText("Dashboard");
        label8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label8.setFont(new Font(19.0));

        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(104.0);
        vBox0.setPrefWidth(141.0);
        vBox0.getStyleClass().add("sidebar-user-btn");

        imageView7.setFitHeight(86.0);
        imageView7.setFitWidth(81.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        imageView7.setImage(new Image(getClass().getResource("/resources/icons/network.png").toExternalForm()));

        label9.setAlignment(javafx.geometry.Pos.CENTER);
        label9.setPrefHeight(38.0);
        label9.setPrefWidth(220.0);
        label9.setStyle("-fx-text-fill: #b8b1b1;");
        label9.setText("Administrators");
        label9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label9.setFont(new Font(19.0));

        vBox1.setAlignment(javafx.geometry.Pos.CENTER);
        vBox1.setPrefHeight(104.0);
        vBox1.setPrefWidth(141.0);
        vBox1.getStyleClass().add("sidebar-user-btn");

        imageView8.setFitHeight(86.0);
        imageView8.setFitWidth(81.0);
        imageView8.setPickOnBounds(true);
        imageView8.setPreserveRatio(true);
        imageView8.setImage(new Image(getClass().getResource("/resources/icons/luggage.png").toExternalForm()));

        label10.setAlignment(javafx.geometry.Pos.CENTER);
        label10.setPrefHeight(38.0);
        label10.setPrefWidth(220.0);
        label10.setStyle("-fx-text-fill: #b8b1b1;");
        label10.setText("Jobs");
        label10.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label10.setFont(new Font(19.0));

        vBox2.setAlignment(javafx.geometry.Pos.CENTER);
        vBox2.setPrefHeight(104.0);
        vBox2.setPrefWidth(141.0);
        vBox2.getStyleClass().add("sidebar-user-btn");

        imageView9.setFitHeight(86.0);
        imageView9.setFitWidth(81.0);
        imageView9.setPickOnBounds(true);
        imageView9.setPreserveRatio(true);
        imageView9.setImage(new Image(getClass().getResource("/resources/icons/decree.png").toExternalForm()));

        label11.setAlignment(javafx.geometry.Pos.CENTER);
        label11.setPrefHeight(38.0);
        label11.setPrefWidth(220.0);
        label11.setStyle("-fx-text-fill: #b8b1b1;");
        label11.setText("Tickets");
        label11.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label11.setFont(new Font(19.0));

        App.GLOBAL_PANE_BORDER.setCenter(new LoginGUI());

        hBox4.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                //alert.getDialogPane().setStyle("-fx-background-color:#218c74;-fx-text-fill:#ecf0f1");
                alert.initStyle(StageStyle.UTILITY);

                alert.setTitle("Confirmation");
                alert.setHeaderText("tttttttt");
                alert.setContentText("aaaaaa");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("okey");
                    App.GLOBAL_PANE_BORDER.setCenter(new LoginGUI());
                } else {
                    System.out.println("cancel !");

                }

            }
        });
        hBox2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageReclamationsBase() {
                });
            }
        });
        hBox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageJobsBase() {
                });
            }
        });
        hBoxNotif.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewNotification(App.USER_ONLINE) {
                });
            }
        });

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(separator);
        getChildren().add(label0);
        hBox.getChildren().add(imageView0);
        hBox.getChildren().add(label1);
        getChildren().add(hBox);
        hBox0.getChildren().add(imageView1);
        hBox0.getChildren().add(label2);
        getChildren().add(hBox0);
        hBox1.getChildren().add(imageView2);
        hBox1.getChildren().add(label3);
        getChildren().add(hBox1);
        hBoxNotif.getChildren().add(imageViewNotif);
        hBoxNotif.getChildren().add(labelNotif);
        getChildren().add(hBoxNotif);
        hBox2.getChildren().add(imageView3);
        hBox2.getChildren().add(label4);
        getChildren().add(hBox2);
        hBox3.getChildren().add(imageView4);
        hBox3.getChildren().add(label5);
        getChildren().add(hBox3);
        hBox4.getChildren().add(imageView5);
        hBox4.getChildren().add(label6);
        getChildren().add(hBox4);
        getChildren().add(label7);
        vBox.getChildren().add(imageView6);
        vBox.getChildren().add(label8);
        tilePane.getChildren().add(vBox);
        vBox0.getChildren().add(imageView7);
        vBox0.getChildren().add(label9);
        tilePane.getChildren().add(vBox0);
        vBox1.getChildren().add(imageView8);
        vBox1.getChildren().add(label10);
        tilePane.getChildren().add(vBox1);
        vBox2.getChildren().add(imageView9);
        vBox2.getChildren().add(label11);
        tilePane.getChildren().add(vBox2);
        getChildren().add(tilePane);
        
        startPollRequests() ;

    }
     public void startPollRequests() 
     {
            Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(7), new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                        pvn.setListView(App.USER_ONLINE);
                     
                     System.out.println(PageViewNotification.NotifNumber);

                      }
                         }));
                fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
                fiveSecondsWonder.play();
     }
}
