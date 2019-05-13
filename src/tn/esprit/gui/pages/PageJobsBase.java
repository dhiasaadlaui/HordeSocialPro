package tn.esprit.gui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import tn.esprit.gui.items.generic.ItemJobBase;
import tn.esprit.services.interfaces.IServiceJob;
import tn.esprit.services.implementation.SerivceJobImpl;

public abstract class PageJobsBase extends BorderPane {

    protected final ImageView imageView;
    protected final TilePane tilePane;
    protected final ScrollPane scrollPane;
    IServiceJob serviceJob;
    List<Job> listJobs;

    public PageJobsBase() {
        listJobs = new ArrayList<Job>();

        serviceJob = new SerivceJobImpl();
        scrollPane = new ScrollPane();
        getStylesheets().add("/resources/css/theme.css");
        imageView = new ImageView();

        tilePane = new TilePane(50, 50);
        tilePane.setStyle("-fx-background-color: transparent;");
        tilePane.setBackground(Background.EMPTY);

        setId("AnchorPane");

        setPadding(new Insets(0, 50, 50, 50));
        tilePane.setPrefHeight(600.0);
        tilePane.setPrefColumns(3);

        try {
            listJobs = serviceJob.findAll();
            for (Job job : listJobs) {
                tilePane.getChildren().add(new ItemJobBase(job));
            }

        } catch (DataBaseException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error connecting database");
            alert.setContentText("error with database");
            alert.show();
        }

        scrollPane.setStyle("-fx-background-color:transparent;");
        //scrollPane.prefHeightProperty().bind(this.heightProperty());
        setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");
        //  tilePane.setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setContent(tilePane);
        scrollPane.setPadding(new Insets(20, 0, 0, 0));
        setCenter(scrollPane);

        HBox searchBar = new HBox();
        MenuButton menuButton = new MenuButton();
        MenuItem menuItem = new MenuItem();
        MenuItem menuItem0 = new MenuItem();
        MenuItem menuItem1 = new MenuItem();
        MenuItem menuItem2 = new MenuItem();
        MenuItem menuItem3 = new MenuItem();
        Region region = new Region();
        MenuButton menuButton0 = new MenuButton();
        MenuItem menuItem4 = new MenuItem();
        MenuItem menuItem5 = new MenuItem();
        MenuItem menuItem6 = new MenuItem();
        MenuItem menuItem7 = new MenuItem();
        MenuItem menuItem8 = new MenuItem();
        Region region0 = new Region();
        TextField textField = new TextField();
        Region region1 = new Region();
        Region region5 = new Region();
        Button btnSearch = new Button();

        searchBar.setAlignment(Pos.BASELINE_LEFT);

        menuButton.setMnemonicParsing(false);
        menuButton.setPrefHeight(0.0);
        menuButton.setPrefWidth(114.0);
        menuButton.setText("Sort by");

        menuItem.setMnemonicParsing(false);
        menuItem.setText("Category");

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Salary");

        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("Location");

        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("Company ");

        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("Creation date");

        region.setPrefHeight(32.0);
        region.setPrefWidth(34.0);
        region5.setPrefHeight(32.0);
        region5.setPrefWidth(500.0);
        menuButton0.setMnemonicParsing(false);
        menuButton0.setPrefHeight(0.0);
        menuButton0.setPrefWidth(114.0);
        menuButton0.setText("Search By");

        menuItem4.setMnemonicParsing(false);
        menuItem4.setText("Category");

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Salary");

        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Location");

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Company ");

        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("Creation date");

        region0.setPrefHeight(32.0);
        region0.setPrefWidth(34.0);

        textField.setPrefHeight(26.0);
        textField.setPrefWidth(143.0);
        textField.setPromptText("Search");

        region1.setPrefHeight(26.0);
        region1.setPrefWidth(100.0);

        btnSearch.setMnemonicParsing(false);

        btnSearch.setText("Create");

        menuButton.getStyleClass().add("primary");
        menuButton0.getStyleClass().add("primary");
        btnSearch.getStyleClass().add("success");

        menuButton.getItems().add(menuItem);
        menuButton.getItems().add(menuItem0);
        menuButton.getItems().add(menuItem1);
        menuButton.getItems().add(menuItem2);
        menuButton.getItems().add(menuItem3);
        menuButton0.getItems().add(menuItem4);
        menuButton0.getItems().add(menuItem5);
        menuButton0.getItems().add(menuItem6);
        menuButton0.getItems().add(menuItem7);
        menuButton0.getItems().add(menuItem8);
        searchBar.getChildren().addAll(region5, menuButton, region, menuButton0, region0, textField, region1, btnSearch);

        setTop(searchBar);

    }
}
