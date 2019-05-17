package tn.esprit.gui.pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import tn.esprit.gui.items.generic.ItemJobBase;
import tn.esprit.gui.launch.App;
import tn.esprit.services.interfaces.IServiceJob;
import tn.esprit.services.implementation.SerivceJobImpl;

public abstract class PageJobsBase extends BorderPane {

    protected final ImageView imageView;
    protected final TilePane tilePane;
    protected final ScrollPane scrollPane;
    IServiceJob serviceJob;
    List<Job> listJobs;
    public MenuButton menuButton = new MenuButton();
    public MenuButton menuButton0 = new MenuButton();
    public static String SEARCH_CRITERIA = "";
    public static Predicate<Job> SEARCH_PREDICATE = p -> p.getCategory().getLabel().contains(SEARCH_CRITERIA);
    public static Comparator<Job> SORT_COMPARATOR = (o1, o2) -> o2.getCreationDate().compareTo(o1.getCreationDate());

    public PageJobsBase() {

        Predicate<Job> predicateSearchByCategory = p -> p.getCategory().getLabel().contains(SEARCH_CRITERIA);
        Predicate<Job> predicateSearchByLocation = p -> p.getLocation().contains(SEARCH_CRITERIA);
        Predicate<Job> predicateSearchBySalary = p -> SEARCH_CRITERIA.equalsIgnoreCase(p.getSalary().toString());
        Predicate<Job> predicateSearchByCompany = p -> p.getCompany().getName().contains(SEARCH_CRITERIA);
        Predicate<Job> predicateSearchByCreationDate = p -> p.getCreationDate().toString().contains(SEARCH_CRITERIA);

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
            listJobs = serviceJob.findAll()
                    .stream()
                    .filter(SEARCH_PREDICATE)
                    .sorted(SORT_COMPARATOR)
                    .collect(Collectors.toList());
            for (Job job : listJobs) {
                if ((job.getCompany().getRecruiter().equals(App.USER_ONLINE)) || job.getStatus().equals("CONFIRMED")) {
                    tilePane.getChildren().add(new ItemJobBase(job));
                }
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

        MenuItem menuItem = new MenuItem();
        MenuItem menuItem0 = new MenuItem();
        MenuItem menuItem1 = new MenuItem();
        MenuItem menuItem2 = new MenuItem();
        MenuItem menuItem3 = new MenuItem();
        Region region = new Region();

        MenuItem menuItem4 = new MenuItem();
        MenuItem menuItem5 = new MenuItem();
        MenuItem menuItem6 = new MenuItem();
        MenuItem menuItem7 = new MenuItem();
        MenuItem menuItem8 = new MenuItem();
        Region region0 = new Region();
        TextField textField = new TextField();
        Region region1 = new Region();
        Region region5 = new Region();
        Button btnCreate = new Button();

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
        menuItem4.setOnAction(e -> {
            SEARCH_PREDICATE = predicateSearchByCategory;

        });

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Salary");
        menuItem5.setOnAction(e -> {
            SEARCH_PREDICATE = predicateSearchBySalary;
        });
        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Location");
        menuItem6.setOnAction(e -> {
            SEARCH_PREDICATE = predicateSearchByLocation;
        });

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Company ");
        menuItem7.setOnAction(e -> {
            SEARCH_PREDICATE = predicateSearchByCompany;
        });

        menuItem8.setMnemonicParsing(false);
        menuItem8.setText("Creation date");

        region0.setPrefHeight(32.0);
        region0.setPrefWidth(34.0);

        textField.setPrefHeight(26.0);
        textField.setPrefWidth(143.0);
        textField.setPromptText("Search");

        region1.setPrefHeight(26.0);
        region1.setPrefWidth(100.0);

        btnCreate.setMnemonicParsing(false);

        btnCreate.setText("Create");
        btnCreate.setOnMouseClicked(e -> {
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageCreateJob());
        });

        menuButton.getStyleClass().add("primary");
        menuButton0.getStyleClass().add("primary");
        btnCreate.getStyleClass().add("success");

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
        searchBar.getChildren().addAll(region5, menuButton, region, menuButton0, region0, textField, region1, btnCreate);

        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    SEARCH_CRITERIA = textField.getText();
                    ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                    ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageJobsBase() {
                    });
                }
            }
        });

        setTop(searchBar);

    }
}
