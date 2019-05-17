package HabibGuitest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.dao.implementation.CompanyDaoImpl;
import tn.esprit.dao.interfaces.ICompanyDao;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.cache.Cache;
import tn.esprit.gui.items.generic.ItemJobModernBase;
import tn.esprit.gui.launch.App;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceAbonnementImpl;
import tn.esprit.services.interfaces.IServiceAbonnement;
import tn.esprit.services.interfaces.IServiceJob;

public abstract class PageCompanyViewBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label label;
    protected final Label label0;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final AnchorPane anchorPane;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Button button;

    ICompanyDao serviceCompany;
    IServiceJob serviceJob;
    IServiceAbonnement serviceAbonnement;

    public PageCompanyViewBase(Company company) {
        serviceAbonnement = new ServiceAbonnementImpl();
        List<Job> jobs = new ArrayList<>();

        serviceCompany = new CompanyDaoImpl();
        serviceJob = new SerivceJobImpl();

        try {
            jobs = serviceJob.findByCompany(company);
        } catch (ObjectNotFoundException ex) {
            Alerts.displayError("Data error", ex.getMessage());
        }

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        anchorPane = new AnchorPane();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        button = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(1000.0);
        setPrefWidth(1300.0);
        setStyle("-fx-background-color: rgb(58,69,88);");
        getStylesheets().add("/resources/css/theme.css");

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setLayoutX(14.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(Cache.httpResources + company.getImage()));

        label.setLayoutX(245.0);
        label.setLayoutY(32.0);
        label.setPrefHeight(94.0);
        label.setPrefWidth(302.0);
        label.setText(company.getName());
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Wingdings 2", 38.0));

        label0.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label0.setLayoutX(622.0);
        label0.setLayoutY(132.0);
        label0.setPrefHeight(74.0);
        label0.setPrefWidth(214.0);
        label0.setText("Last job offers");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        label0.setFont(new Font(33.0));

        scrollPane.setLayoutX(800);
        scrollPane.setLayoutY(222.0);
        scrollPane.setPrefHeight(500);
        scrollPane.setPrefWidth(258.0);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-region-background: transparent;");

        vBox.setId("jobsList");
        vBox.setSpacing(10.0);
        for (Job job : jobs) {
            vBox.getChildren().add(new ItemJobModernBase(job));
        }

        scrollPane.setContent(vBox);

        label1.setLayoutX(38.0);
        label1.setLayoutY(185.0);
        label1.setPrefHeight(73.0);
        label1.setPrefWidth(258.0);
        label1.setText("Introduction");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font(33.0));

        label2.setLayoutX(245.0);
        label2.setLayoutY(109.0);
        label2.setPrefHeight(46.0);
        label2.setPrefWidth(258.0);
        label2.setText("Sector: " + company.getDomain());
        label2.setTextFill(javafx.scene.paint.Color.WHITE);
        label2.setFont(new Font(21.0));

        label3.setLayoutX(38.0);
        label3.setLayoutY(238.0);
        label3.setPrefHeight(128.0);
        label3.setPrefWidth(531.0);
        label3.setText(company.getDescription());
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font(15.0));

        label4.setLayoutX(245.0);
        label4.setLayoutY(141.0);
        label4.setPrefHeight(46.0);
        label4.setPrefWidth(258.0);
        label4.setText("Recruiter: " + company.getRecruiter().getFirstName() + " " + company.getRecruiter().getLastName());
        label4.setTextFill(javafx.scene.paint.Color.WHITE);
        label4.setFont(new Font(21.0));

        anchorPane.setLayoutX(107.0);
        anchorPane.setLayoutY(374.0);
        anchorPane.setStyle("-fx-border-radius: 0 25 0 25; -fx-border-width: 5; -fx-border-color: #FFF;");

        label5.setLayoutX(25.0);
        label5.setPrefHeight(33.0);
        label5.setPrefWidth(214.0);
        label5.setText("Contacts");
        label5.setTextFill(javafx.scene.paint.Color.WHITE);
        label5.setFont(new Font(28.0));

        label6.setLayoutX(43.0);
        label6.setLayoutY(40.0);
        label6.setPrefHeight(40.0);
        label6.setPrefWidth(378.0);
        label6.setText("Adress: " + company.getAdress());
        label6.setTextFill(javafx.scene.paint.Color.WHITE);
        label6.setFont(new Font(20.0));

        label7.setLayoutX(50.0);
        label7.setLayoutY(76.0);
        label7.setPrefHeight(21.0);
        label7.setPrefWidth(378.0);
        label7.setText("Email: " + company.getRecruiter().getEmail());
        label7.setTextFill(javafx.scene.paint.Color.WHITE);
        label7.setFont(new Font(20.0));

        button.setLayoutX(680.0);
        button.setLayoutY(52.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(136.0);
        button.getStyleClass().add("success");
        button.setText("S'abonner");

        Boolean subscribed = false;

        try {
            subscribed = serviceAbonnement.findAll()
                    .stream()
                    .anyMatch(e -> e.getCandidate().equals(App.USER_ONLINE) && e.getCompany().equals(company));
            button.setDisable(subscribed);
        } catch (DataBaseException ex) {
            Alerts.displayError("Error with Abonnements", ex.getMessage());
        }

        button.setOnMouseClicked(e -> {
            try {
                serviceAbonnement.create(
                        new Abonnement.Builder()
                                .candidate(App.USER_ONLINE)
                                .company(company)
                                .dateAbonnement(new Date())
                                .build()
                );
                Alerts.displaySuccess("Success", company.getName() + " added to favouris");
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageCompanyViewBase(company) {
                });

            } catch (DataBaseException ex) {
                Alerts.displayError("Error", ex.getMessage());
            }
        });

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(scrollPane);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        anchorPane.getChildren().add(label5);
        anchorPane.getChildren().add(label6);
        anchorPane.getChildren().add(label7);
        getChildren().add(anchorPane);
        getChildren().add(button);

    }
}
