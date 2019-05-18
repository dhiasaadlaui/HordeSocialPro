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
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
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
import javafx.scene.layout.VBox;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Reclamation;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.items.generic.ItemJobBase;
import tn.esprit.gui.items.generic.ItemReclamationBase;
import tn.esprit.gui.launch.App;

import tn.esprit.services.implementation.ServiceReclamationImpl;
import tn.esprit.services.interfaces.IServiceReclamation;

public abstract class PageReclamationsBase extends BorderPane {

    protected final ImageView imageView;
    protected final VBox vboxList;
    private IServiceReclamation serviceReclamation;
    public MenuButton menuButton = new MenuButton();
    public MenuButton menuButton0 = new MenuButton();

    public static String SEARCH_CRITERIA = "";
    public static Predicate<Reclamation> SEARCH_PREDICATE = e -> e.getStatus().contains(SEARCH_CRITERIA);
    public static Comparator<Reclamation> SORT_COMPARATOR = (o1, o2) -> o2.getId().compareTo(o1.getId());

    public PageReclamationsBase() {
        ScrollPane scrollPane = new ScrollPane();

        serviceReclamation = new ServiceReclamationImpl();
        getStylesheets().add("/resources/css/theme.css");
        imageView = new ImageView();
        scrollPane.setStyle("-fx-background-image: url(\"/resources/images/background_1.jpg\");-fx-background-repeat: stretch;   \n"
                + "    -fx-background-position: center center;\n"
                + " -fx-background-size: cover, auto;");
        scrollPane.setPrefWidth(1300);

        vboxList = new VBox();
        vboxList.setStyle("-fx-background-color: transparent;");
        vboxList.setBackground(Background.EMPTY);
        vboxList.setPrefWidth(1300);
        scrollPane.setStyle("-fx-background-color: transparent;");
        scrollPane.setPadding(new Insets(50, 50, 50, 50));
        vboxList.setPrefHeight(600.0);
        vboxList.setPrefWidth(1200.0);

        vboxList.setSpacing(20);

        List<Reclamation> recList = new ArrayList<Reclamation>();

        try {
            recList = serviceReclamation.findAll()
                    .stream()
                    .filter(SEARCH_PREDICATE)
                    .sorted(SORT_COMPARATOR)
                    .collect(Collectors.toList());

        } catch (DataBaseException ex) {
            Alerts.displayError("DataBase exception", ex.getMessage());
        }

        for (Reclamation reclamation : recList) {
            vboxList.getChildren().add(new ItemReclamationBase(reclamation));
        }

        scrollPane.setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");

        //  vboxList.setStyle("-fx-background-image: url(\"/resources/images/animated-background.gif\");-fx-background-size: cover;");
        scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        scrollPane.setContent(vboxList);

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
        menuItem4.setText("Status");
        menuItem4.setOnAction(e -> {

        });

        menuItem5.setMnemonicParsing(false);
        menuItem5.setText("Salary");
        menuItem5.setOnAction(e -> {
        });
        menuItem6.setMnemonicParsing(false);
        menuItem6.setText("Location");
        menuItem6.setOnAction(e -> {

        });

        menuItem7.setMnemonicParsing(false);
        menuItem7.setText("Company ");
        menuItem7.setOnAction(e -> {

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
        btnCreate.setVisible(false);
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
  
        menuButton0.getItems().add(menuItem4);
  
        searchBar.getChildren().addAll(region5, menuButton, region, menuButton0, region0, textField, region1);

        textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    SEARCH_CRITERIA = textField.getText();
                    ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                    ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageReclamationsBase() {
                    });
                }
            }
        });

        setTop(searchBar);

    }
}
