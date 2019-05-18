package tn.esprit.gui.items.generic;

import tn.esprit.gui.pages.PageCompanyViewBase;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Abonnement;
import tn.esprit.entities.Company;
import tn.esprit.entities.Job;
import tn.esprit.entities.User;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.pages.PageAbonnementsBase;
import tn.esprit.services.exceptions.ObjectNotFoundException;
import tn.esprit.services.implementation.SerivceJobImpl;
import tn.esprit.services.implementation.ServiceAbonnementImpl;
import tn.esprit.services.interfaces.IServiceAbonnement;
import tn.esprit.services.interfaces.IServiceJob;

public abstract class ItemAbonnementBase extends AnchorPane {

    protected final Button button;
    protected final Button button0;
    protected final Pane pane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final ImageView imageView;
    protected final TitledPane titledPane;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;

    IServiceJob serviceJob;
    IServiceAbonnement serviceAbonnement;

    public ItemAbonnementBase(Company company) {
        serviceJob = new SerivceJobImpl();
        serviceAbonnement = new ServiceAbonnementImpl();
        button = new Button();
        button0 = new Button();
        pane = new Pane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        imageView = new ImageView();
        titledPane = new TitledPane();
        scrollPane = new ScrollPane();
        vBox = new VBox();

        setPrefHeight(339.0);
        setPrefWidth(545.0);
        setStyle("-fx-background-color: #34495e; -fx-border-radius: 25 25 25 25; -fx-border-color: #2980b9; -fx-border-width: 5; -fx-background-radius: 25 25 25 25;");
        getStylesheets().add("/resources/css/theme.css");

        button.setLayoutX(280.0);
        button.setLayoutY(293.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(115.0);
        button.getStyleClass().add("danger");
        button.getStylesheets().add("/resources/css/theme.css");
        button.setText("Desabonner");
        button.setFont(new Font(15.0));
        button.setOnMouseClicked(e -> {
            List<Abonnement> abonnements = new ArrayList<>();
            try {
                abonnements = serviceAbonnement.findByCandidate(App.USER_ONLINE);
                if (abonnements.size() > 0) {
                    serviceAbonnement.delete(abonnements.get(0));
                }
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageAbonnementsBase() {
                });
            } catch (ObjectNotFoundException | DataBaseException ex) {
                Alerts.displayError("ObjectNotFoundException", ex.getMessage());
            }

        });

        button0.setLayoutX(416.0);
        button0.setLayoutY(293.0);
        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(115.0);
        button0.getStyleClass().add("success");
        button0.setText("View");
        button0.setFont(new Font(15.0));
        button0.setOnMouseClicked(e -> {
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
            ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageCompanyViewBase(company) {
            });
        });

        pane.setLayoutX(14.0);
        pane.setLayoutY(106.0);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(254.0);

        label.setLayoutX(94.0);
        label.setLayoutY(123.0);
        label.setPrefHeight(24.0);
        label.setPrefWidth(186.0);
        label.setText(company.getDomain());
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label0.setLayoutY(116.0);
        label0.setPrefHeight(32.0);
        label0.setPrefWidth(115.0);
        label0.setText("Domaine :");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffffff2"));

        label1.setLayoutX(94.0);
        label1.setLayoutY(91.0);
        label1.setPrefHeight(24.0);
        label1.setPrefWidth(186.0);
        label1.setText("companyNumber");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label2.setLayoutY(84.0);
        label2.setPrefHeight(32.0);
        label2.setPrefWidth(115.0);
        label2.setText("Recruiter  :");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#fffffff2"));

        label3.setLayoutX(94.0);
        label3.setLayoutY(56.0);
        label3.setPrefHeight(24.0);
        label3.setPrefWidth(200.0);
        label3.setText(company.getAdress());
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label4.setLayoutY(49.0);
        label4.setPrefHeight(32.0);
        label4.setPrefWidth(115.0);
        label4.setText("Adress :");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#fffffff2"));

        label5.setLayoutY(13.0);
        label5.setPrefHeight(32.0);
        label5.setPrefWidth(115.0);
        label5.setText("Name     :");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#fffffff2"));

        label6.setLayoutX(94.0);
        label6.setLayoutY(17.0);
        label6.setPrefHeight(24.0);
        label6.setPrefWidth(200.0);
        label6.setText(company.getName());
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        imageView.setFitHeight(117.0);
        imageView.setFitWidth(115.0);
        imageView.setImage(new Image(getClass().getResource("/resources/images/heart_14746.png").toExternalForm()));

        titledPane.setLayoutX(280.0);
        titledPane.setLayoutY(17.0);
        titledPane.setPrefHeight(262.0);
        titledPane.setPrefWidth(254.0);
        titledPane.getStyleClass().add("info");
        titledPane.setText("Lastest posts");

        scrollPane.setPrefHeight(220.0);
        scrollPane.setPrefWidth(306.0);

        vBox.setId("jobsList");
        vBox.setPrefHeight(426.0);
        vBox.setPrefWidth(238.0);

        List<Job> jobs = new ArrayList<>();

        try {
            jobs = serviceJob.findByCompany(company);
        } catch (ObjectNotFoundException ex) {
            Alerts.displayError("Data Error", ex.getMessage());
        }

        for (Job job : jobs) {
            vBox.getChildren().add(new ItemJobModernBase(job));

        }

        scrollPane.setContent(vBox);
        titledPane.setContent(scrollPane);

        getChildren().add(button);
        getChildren().add(button0);
        pane.getChildren().add(label);
        pane.getChildren().add(label0);
        pane.getChildren().add(label1);
        pane.getChildren().add(label2);
        pane.getChildren().add(label3);
        pane.getChildren().add(label4);
        pane.getChildren().add(label5);
        pane.getChildren().add(label6);
        getChildren().add(pane);
        getChildren().add(imageView);
        getChildren().add(titledPane);
        scrollPane.setStyle("-fx-background-color: transparent;");
        vBox.setStyle("-fx-background-color: transparent;");
    }
}
