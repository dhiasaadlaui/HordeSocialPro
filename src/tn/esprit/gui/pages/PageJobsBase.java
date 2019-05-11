package tn.esprit.gui.pages;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import tn.esprit.gui.items.generic.ItemJobBase;

public abstract class PageJobsBase extends ScrollPane {

    protected final ImageView imageView;
    protected final TilePane tilePane;

    public PageJobsBase() {
        getStylesheets().add("/resources/css/theme.css");
        imageView = new ImageView();

        tilePane = new TilePane(50, 50);
        tilePane.setStyle("-fx-background-color: transparent;");
        tilePane.setBackground(Background.EMPTY);

        setId("AnchorPane");

        setPadding(new Insets(50, 50, 50, 50));
        tilePane.setPrefHeight(600.0);
        tilePane.setPrefColumns(3);
        for (int i = 0; i < 10; i++) {
            tilePane.getChildren().add(new ItemJobBase() {
            });

        }

        setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");

        //  tilePane.setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setContent(tilePane);

    }
}
