package tn.esprit.gui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Reclamation;
import tn.esprit.gui.items.generic.ItemJobBase;
import tn.esprit.gui.items.generic.ItemReclamationBase;
import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.interfaces.IServiceReclamation;

public abstract class PageReclamationsBase extends ScrollPane {

    protected final ImageView imageView;
    protected final VBox vboxList;
    private IServiceReclamation serviceReclamation;

    public PageReclamationsBase() {
        serviceReclamation = new ServiceReclamationImpl();
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

        List<Reclamation> recList = new ArrayList<Reclamation>();

        try {
            recList = serviceReclamation.findAll();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

        for (Reclamation reclamation : recList) {
            vboxList.getChildren().add(new ItemReclamationBase(reclamation));
        }

        setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");

        //  vboxList.setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");
        setHbarPolicy(ScrollBarPolicy.NEVER);
        setContent(vboxList);

    }
}
