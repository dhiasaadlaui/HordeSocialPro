package HabibGuitest;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.entities.Job;

public abstract class ItemJob extends Pane {

    protected final Button button;
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

    public ItemJob(Job job) {

        button = new Button();
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

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(326.0);
        setPrefWidth(318.0);
        setStyle("-fx-background-color: LAVENDER; -fx-border-color: #455051; -fx-border-width: 7.5;");
        getStylesheets().add("/HabibGuitest/../resources/css/theme.css");

        button.setLayoutX(111.0);
        button.setLayoutY(280.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("primary");
        button.getStylesheets().add("/HabibGuitest/../resources/css/theme.css");
        button.setText("View details");

        label.setLayoutX(127.0);
        label.setLayoutY(35.0);
        label.getStyleClass().add("danger");
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
        label5.setText(job.getCompany().getRecruiter().getFirstName()+" "+job.getCompany().getRecruiter().getLastName());
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label6.setPrefHeight(32.0);
        label6.setPrefWidth(77.0);
        label6.setText("15/06/2018");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        label7.setPrefHeight(52.0);
        label7.setPrefWidth(82.0);
        label7.setText("16/08/2018");
        label7.setTextFill(javafx.scene.paint.Color.valueOf("#455051"));

        imageView.setFitHeight(62.0);
        imageView.setFitWidth(62.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(18.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/images/fr.png").toExternalForm()));

        getChildren().add(button);
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

    }
}
