package tn.esprit.gui.items.generic;

import java.text.SimpleDateFormat;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import tn.esprit.entities.Job;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.pages.PageViewJob;

public class ItemJobModernBase extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Button button;

    public ItemJobModernBase(Job job) {

        label = new Label();
        label0 = new Label();
        button = new Button();

        setPrefHeight(96.0);
        setPrefWidth(241.0);
        setStyle("-fx-border-color: #6492db; -fx-border-width: 5px; -fx-background-radius: 25 0 25 0; -fx-border-radius: 25 0 25 0; -fx-background-color: #34495e;");
        getStylesheets().add("/resources/css/theme.css");

        label.setLayoutX(29.0);
        label.setLayoutY(14.0);
        label.setPrefHeight(26.0);
        label.setPrefWidth(142.0);
        label.setText(job.getTitle());
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Book Antiqua Italic", 24.0));

        label0.setLayoutX(14.0);
        label0.setLayoutY(55.0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        label0.setText("Expire date " + sdf.format(job.getExpireDate()));
        label0.setTextFill(javafx.scene.paint.Color.WHITE);

        button.setLayoutX(172.0);
        button.setLayoutY(48.0);
        button.setMnemonicParsing(false);
        button.getStyleClass().add("primary");
        button.setText("View");
        
        button.setOnMouseClicked(e -> {
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewJob(job));
        });

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(button);

    }
}
