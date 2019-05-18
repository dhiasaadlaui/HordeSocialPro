package tn.esprit.gui.pages;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.web.HTMLEditor;
import javax.mail.MessagingException;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Apply;
import tn.esprit.entities.Job;
import tn.esprit.gui.cache.Alerts;
import tn.esprit.gui.graphic.PopUpService;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.pages.PageViewJob;
import tn.esprit.services.implementation.ServiceApplyImpl;
import tn.esprit.services.interfaces.IServiceApply;
import tn.esprit.services.util.ServiceMail;

public class PageCreateApply extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final HTMLEditor hTMLEditor;
    protected final TilePane tilePane;
    protected final ImageView imageView;
    protected final Label label0;
    protected final ImageView imageView0;
    protected final Label label1;
    protected final ImageView imageView1;
    protected final Label label2;
    protected final ImageView imageView2;
    protected final Label label3;
    protected final ImageView imageView3;
    protected final Label label4;
    protected final ImageView imageView4;
    protected final Label label5;
    protected final Button button;
    protected final Label label6;
    protected final ImageView imageView5;
    IServiceApply serviceApply;

    public PageCreateApply(Job job) {
        serviceApply = new ServiceApplyImpl();
        anchorPane = new AnchorPane();
        label = new Label();
        hTMLEditor = new HTMLEditor();
        tilePane = new TilePane();
        imageView = new ImageView();
        label0 = new Label();
        imageView0 = new ImageView();
        label1 = new Label();
        imageView1 = new ImageView();
        label2 = new Label();
        imageView2 = new ImageView();
        label3 = new Label();
        imageView3 = new ImageView();
        label4 = new Label();
        imageView4 = new ImageView();
        label5 = new Label();
        button = new Button();
        label6 = new Label();
        imageView5 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(645.0);
        setPrefWidth(748.0);
        setStyle("-fx-background-color: #192a56;");
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/resources/css/theme.css");

        anchorPane.setLayoutX(6.0);
        anchorPane.setLayoutY(78.0);
        anchorPane.setPrefHeight(555.0);
        anchorPane.setPrefWidth(736.0);
        anchorPane.setStyle("-fx-background-color: grey; -fx-background-radius: 10;");

        label.setLayoutX(76.0);
        label.setLayoutY(283.0);
        label.setStyle("-fx-background-size: 20px; -fx-font: black;");

        label.setText("Motivation Letter :");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label.setFont(new Font(18.0));

        hTMLEditor.setHtmlText("<html><head></head><body contenteditable='true'></body></html>");
        hTMLEditor.setLayoutX(38.0);
        hTMLEditor.setLayoutY(310.0);
        hTMLEditor.setPrefHeight(238.0);
        hTMLEditor.setPrefWidth(688.0);

        tilePane.setLayoutX(14.0);
        tilePane.setLayoutY(13.0);
        tilePane.setPrefColumns(2);
        tilePane.setPrefHeight(278.0);
        tilePane.setPrefWidth(562.0);
        tilePane.setTileAlignment(javafx.geometry.Pos.TOP_LEFT);

        imageView.setFitHeight(41.0);
        imageView.setFitWidth(51.0);

        imageView.setImage(new Image(getClass().getResource("/resources/icons/network.png").toExternalForm()));

        label0.setPrefHeight(38.0);
        label0.setPrefWidth(231.0);

        label0.setText("Candidate : " + App.USER_ONLINE.getFirstName() + " " + App.USER_ONLINE.getLastName());
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label0.setFont(new Font(18.0));

        imageView0.setFitHeight(72.0);
        imageView0.setFitWidth(46.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/icons/administrator.png").toExternalForm()));

        label1.setPrefHeight(27.0);
        label1.setPrefWidth(232.0);

        label1.setText("Job : " + job.getTitle());

        label1.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label1.setFont(new Font(18.0));

        imageView1.setFitHeight(30.0);
        imageView1.setFitWidth(54.0);
        imageView1.setImage(new Image(getClass().getResource("/resources/icons/wall-calendar.png").toExternalForm()));

        label2.setPrefHeight(17.0);
        label2.setPrefWidth(188.0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/2019");

        label2.setText("Start Date: " + sdf.format(job.getCreationDate()));
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label2.setFont(new Font(18.0));

        imageView2.setFitHeight(32.0);
        imageView2.setFitWidth(54.0);
        imageView2.setImage(new Image(getClass().getResource("/resources/icons/wall-calendar.png").toExternalForm()));

        label3.setText("Expiration Date: " + sdf.format(job.getExpireDate()));
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label3.setFont(new Font(18.0));

        imageView3.setFitHeight(39.0);
        imageView3.setFitWidth(51.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/resources/icons/stats.png").toExternalForm()));

        label4.setText("Recruiter : " + job.getCompany().getRecruiter().getFirstName() + " " + job.getCompany().getRecruiter().getLastName());
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label4.setFont(new Font(18.0));

        imageView4.setFitHeight(41.0);
        imageView4.setFitWidth(51.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("/resources/icons/banker.png").toExternalForm()));

        label5.setText("Salary : " + job.getSalary() + " EUR");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#0a0000"));
        label5.setFont(new Font(18.0));

        button.setLayoutX(576.0);
        button.setLayoutY(251.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(84.0);
        button.getStyleClass().add("success");

        button.setText("Apply");
        button.setOnMouseClicked(e -> {

            try {
                PopUpService.CreatePopup(serviceApply.create(new Apply.Builder()
                        .letter(hTMLEditor.getHtmlText())
                        .candidate(App.USER_ONLINE)
                        .job(job)
                        .build()));
                ServiceMail.sendMail(App.USER_ONLINE.getEmail(), "Application creation",
                        "<p><em>Dear</em> " + App.USER_ONLINE.getFirstName() + " " + App.USER_ONLINE.getLastName() + ",</p>\n"
                        + "<p>Your application on the job " + job.getTitle() + " of " + job.getCompany().getName() + " company was succefuly created ,&nbsp;</p>\n"
                        + "<p>&nbsp;</p>\n"
                        + "<p><em><span style=\"font-size: 10pt;\">Kind Regards,</span></em></p>\n"
                        + "<p><em><span style=\"font-size: 10pt;\">HordeSocialPro Support Team</span></em></p>"
                );
                ServiceMail.sendMail(job.getCompany().getRecruiter().getEmail(), "New Application on " + job.getTitle(),
                        "<p><em>Dear " + job.getCompany().getRecruiter().getFirstName() + " " + job.getCompany().getRecruiter().getLastName() + ",</em></p>\n"
                        + "<p><em>A new Application has been submited on the job, " + job.getTitle() + "</em></p>\n"
                        + "<p><em>Please check it out.</em></p>\n"
                        + "<p>&nbsp;</p>\n"
                        + "<p><span style=\"font-size: 10pt;\"><em>Kind Regards,</em></span></p>\n"
                        + "<p><span style=\"font-size: 10pt;\"><em>HordeSocialPro Support Team</em></span></p>"
                );

                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewJob(job));

            } catch (DataBaseException | MessagingException ex) {
                Alerts.displayError("Database Error", ex.getMessage());
            }

        });

        label6.setLayoutX(321.0);
        label6.setLayoutY(22.0);
        label6.setPrefHeight(27.0);
        label6.setPrefWidth(84.0);

        label6.setText("Vermeg");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#dddddd"));
        label6.setFont(new Font("Microsoft YaHei", 20.0));

        imageView5.setFitHeight(94.0);
        imageView5.setFitWidth(51.0);
        imageView5.setLayoutX(263.0);
        imageView5.setLayoutY(10.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("/resources/icons/flats.png").toExternalForm()));

        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(hTMLEditor);
        tilePane.getChildren().add(imageView);
        tilePane.getChildren().add(label0);
        tilePane.getChildren().add(imageView0);
        tilePane.getChildren().add(label1);
        tilePane.getChildren().add(imageView1);
        tilePane.getChildren().add(label2);
        tilePane.getChildren().add(imageView2);
        tilePane.getChildren().add(label3);
        tilePane.getChildren().add(imageView3);
        tilePane.getChildren().add(label4);
        tilePane.getChildren().add(imageView4);
        tilePane.getChildren().add(label5);
        anchorPane.getChildren().add(tilePane);
        anchorPane.getChildren().add(button);
        getChildren().add(anchorPane);
        getChildren().add(label6);
        getChildren().add(imageView5);

    }
}
