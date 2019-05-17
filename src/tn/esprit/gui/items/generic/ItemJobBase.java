package tn.esprit.gui.items.generic;

import java.text.SimpleDateFormat;
import tn.esprit.gui.pages.PageViewJob;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.entities.Job;
import tn.esprit.gui.cache.Cache;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.pages.PageEditJob;
import tn.esprit.gui.pages.PageJobsBase;

public class ItemJobBase extends Pane {

    protected final Label label;
    protected final VBox vBox;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final VBox vBox0;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final ImageView imageView;
    protected final HBox hBox;
    protected final Button button;
    protected final Button button0;

    public ItemJobBase(Job job) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        label = new Label();
        vBox = new VBox();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        vBox0 = new VBox();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        imageView = new ImageView();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(326.0);
        setPrefWidth(318.0);
        setStyle("-fx-background-color: LAVENDER; -fx-border-color: #455051; -fx-border-width: 7.5;");
        getStylesheets().add("/resources/css/theme.css");

        label.setLayoutX(141.0);
        label.setLayoutY(40.0);
        label.setText(job.getCompany().getName());
        label.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));
        label.setFont(new Font(18.0));

        vBox.setLayoutX(41.0);
        vBox.setLayoutY(92.0);
        vBox.setPrefHeight(173.0);
        vBox.setPrefWidth(100.0);

        label0.setPrefHeight(42.0);
        label0.setPrefWidth(81.0);
        label0.setText("Job title :");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label1.setPrefHeight(51.0);
        label1.setPrefWidth(86.0);
        label1.setText("Recruiter :");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label2.setPrefHeight(33.0);
        label2.setPrefWidth(90.0);
        label2.setText("Creation date :");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label3.setPrefHeight(54.0);
        label3.setPrefWidth(91.0);
        label3.setText("Expire date :");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        vBox0.setLayoutX(158.0);
        vBox0.setLayoutY(92.0);
        vBox0.setPrefHeight(173.0);
        vBox0.setPrefWidth(138.0);

        label4.setPrefHeight(39.0);
        label4.setPrefWidth(132.0);
        label4.setText(job.getTitle());
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label5.setPrefHeight(52.0);
        label5.setPrefWidth(116.0);
        label5.setText(job.getCompany().getRecruiter().getFirstName() + " " + job.getCompany().getRecruiter().getLastName());
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label6.setPrefHeight(32.0);
        label6.setPrefWidth(77.0);
        label6.setText(format.format(job.getCreationDate()));
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label7.setPrefHeight(52.0);
        label7.setPrefWidth(82.0);
        label7.setText(format.format(job.getExpireDate()));
        label7.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        imageView.setFitHeight(72.0);
        imageView.setFitWidth(82.0);
        imageView.setLayoutX(31.0);
        imageView.setLayoutY(18.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
   //     System.out.println(Cache.httpResources+job.getCompany().getImage());
        imageView.setImage(new Image(Cache.httpResources+job.getCompany().getImage()));

        hBox.setLayoutX(53.0);
        hBox.setLayoutY(280.0);
        hBox.setSpacing(10.0);

        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(100.0);
        button.getStyleClass().add("primary");
        button.setText("View details");
        button.setOnMouseClicked(e -> {
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewJob(job));
        });
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(0.0);
        button0.setPrefWidth(100.0);
        button0.getStyleClass().add("success");
        button0.setText("Edit");
        button0.setOnMouseClicked(e -> {
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageEditJob(job));
        });

        getChildren().add(label);
        vBox.getChildren().add(label0);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(label2);
        vBox.getChildren().add(label3);
        getChildren().add(vBox);
        vBox0.getChildren().add(label4);
        vBox0.getChildren().add(label5);
        vBox0.getChildren().add(label6);
        vBox0.getChildren().add(label7);
        getChildren().add(vBox0);
        getChildren().add(imageView);
        hBox.getChildren().add(button);
        if(job.getCompany().getRecruiter().equals(App.USER_ONLINE))
        hBox.getChildren().add(button0);
        getChildren().add(hBox);

    }
}
