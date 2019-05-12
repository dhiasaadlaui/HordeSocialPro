package tn.esprit.gui.pages;

import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import tn.esprit.gui.items.generic.ItemJobBase;
import tn.esprit.gui.items.generic.ItemReclamationBase;

public abstract class PageReclamationsBase extends ScrollPane {

    protected final ImageView imageView;
    protected final VBox vboxList;

    public PageReclamationsBase() {
        getStylesheets().add("/resources/css/theme.css");
        imageView = new ImageView();

        vboxList = new VBox();
        vboxList.setStyle("-fx-background-color: transparent;");
        vboxList.setBackground(Background.EMPTY);

        setId("AnchorPane");

        setPadding(new Insets(50, 50, 50, 50));
        vboxList.setPrefHeight(600.0);
        vboxList.setPrefWidth(800.0);
        setPrefWidth(1000);
        vboxList.setSpacing(20);
        for (int i = 0; i < 10; i++) {
            vboxList.getChildren().add(new ItemReclamationBase() {
            });

        }

        setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");

        //  vboxList.setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setContent(vboxList);

    }
}
