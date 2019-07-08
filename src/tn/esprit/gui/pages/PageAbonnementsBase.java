package tn.esprit.gui.pages;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.items.generic.ItemAbonnementBase;
import tn.esprit.gui.launch.App;
import static tn.esprit.gui.pages.PageJobsBase.SEARCH_PREDICATE;
import tn.esprit.services.implementation.ServiceAbonnementImpl;
import tn.esprit.services.interfaces.IServiceAbonnement;

public abstract class PageAbonnementsBase extends VBox {

    protected final ScrollPane scrollPane;
    protected final VBox vBox;

    IServiceAbonnement serviceAbonnement;
        public MenuButton menuButton = new MenuButton();
    public MenuButton menuButton0 = new MenuButton();
    public static String SEARCH_CRITERIA = "";
    public static Predicate<Job> SEARCH_PREDICATE = p -> p.getCategory().getLabel().contains(SEARCH_CRITERIA);
    public static Comparator<Job> SORT_COMPARATOR = (o1, o2) -> o2.getCreationDate().compareTo(o1.getCreationDate());


    public PageAbonnementsBase() {
        serviceAbonnement = new ServiceAbonnementImpl();
        getStylesheets().add("/resources/css/theme.css");
        scrollPane = new ScrollPane();
        vBox = new VBox();

        setId("AnchorPane");
        setPrefHeight(623.0);
        setPrefWidth(1123.0);
        setStyle("-fx-background-color: #34495e;");

        scrollPane.setLayoutX(275.0);
        scrollPane.setLayoutY(14.0);
        scrollPane.setPrefHeight(800.0);

        vBox.setId("abonnementsList");
        vBox.setPrefHeight(2000.0);
        vBox.setPrefWidth(1200.0);
        vBox.setSpacing(10.0);

        vBox.setBackground(Background.EMPTY);
        vBox.setAlignment(Pos.TOP_CENTER);

        List<Company> companies = new ArrayList<>();
        try {
            companies = serviceAbonnement.findAll()
                    .stream()
                    .filter(e -> e.getCandidate().equals(App.USER_ONLINE))
                    .map(e -> e.getCompany())
                    .collect(Collectors.toList());
        } catch (DataBaseException ex) {
            Alerts.displayError("Data Error", ex.getMessage());
        }

        for (Company company : companies) {
            vBox.getChildren().add(new ItemAbonnementBase(company) {
            });
        }

        scrollPane.setContent(vBox);

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
        menuItem.setText("Domain");

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("Salary");

   

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
        menuItem4.setText("Company Name");
        menuItem4.setOnAction(e -> {
            SEARCH_PREDICATE = null;

        });

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Recruiter Name");
        menuItem5.setOnAction(e -> {
            SEARCH_PREDICATE = null;
        });
        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Adress");
        menuItem6.setOnAction(e -> {
            SEARCH_PREDICATE = null;
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
        
        
        
        
        
        searchBar.getChildren().addAll(region5, menuButton, region, menuButton0, region0, textField, region1);
        
        
        getChildren().addAll(searchBar,scrollPane);
        vBox.setStyle("-fx-background-color: transparent;");
        vBox.setBackground(Background.EMPTY);
        vBox.setSpacing(5);
        scrollPane.setStyle("-fx-background-image: url(\"/resources/images/background_1.jpg\");-fx-background-repeat: stretch;   \n"
                + "    -fx-background-position: center center;\n"
                + " -fx-background-size: cover, auto;");
        scrollPane.setPrefWidth(1300);
        scrollPane.setStyle("-fx-background-color: transparent;");
        vBox.setStyle("-fx-background-color: transparent;");
    }
}
