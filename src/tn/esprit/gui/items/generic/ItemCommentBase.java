package tn.esprit.gui.items.generic;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit.entities.Comment;
import tn.esprit.gui.cache.Cache;
import tn.esprit.gui.launch.App;
import tn.esprit.gui.pages.PageCreateClaim;
import tn.esprit.services.interfaces.IServiceComment;

public class ItemCommentBase extends AnchorPane {

    protected final ImageView userphoto;
    protected final TextArea textComment;
    protected final Label labelDate;
    protected final Button btnClaim;
    protected final Button btnRepply;
    protected final Separator separator;
    protected final Label txtUserName;
    protected final Button btnDelete;
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public ItemCommentBase(Comment comment) {
        this.comment = comment;
        userphoto = new ImageView();
        textComment = new TextArea();
        labelDate = new Label();
        btnClaim = new Button();
        btnRepply = new Button();
        separator = new Separator();
        txtUserName = new Label();
        btnDelete = new Button();

        setPrefHeight(106.0);
        setPrefWidth(639.0);
        getStylesheets().add("/resources/css/theme.css");

        userphoto.setFitHeight(67.0);
        userphoto.setFitWidth(59.0);
        userphoto.setLayoutX(6.0);
        userphoto.setLayoutY(13.0);
        userphoto.setPickOnBounds(true);
        userphoto.setPreserveRatio(true);
        // System.out.println(Cache.httpResources+comment.getUser().getPhoto());
        userphoto.setImage(new Image(Cache.httpResources + comment.getUser().getPhoto()));

        textComment.setEditable(false);
        textComment.setLayoutX(72.0);
        textComment.setLayoutY(17.0);
        textComment.setPrefHeight(59.0);
        textComment.setPrefWidth(348.0);
        textComment.setText(comment.getContent());
        String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        labelDate.setLayoutX(374.0);
        labelDate.setLayoutY(77.0);
        labelDate.setText("Date: " + comment.getDate().format(formatter));

        btnClaim.setLayoutX(516.0);
        btnClaim.setLayoutY(31.0);
        btnClaim.setMnemonicParsing(false);
        btnClaim.getStyleClass().add("danger");
        btnClaim.setText("!");
        btnClaim.setOnMouseClicked(e -> {
            Stage claimStage = new Stage();
            Scene claimScene = new Scene(new PageCreateClaim(comment));
            claimStage.setScene(claimScene);
            claimStage.show();
            btnClaim.setDisable(true);
        });

        btnRepply.setLayoutX(444.0);
        btnRepply.setLayoutY(31.0);
        btnRepply.setMnemonicParsing(false);
        btnRepply.getStyleClass().add("info");
        btnRepply.setText("Repply");

        separator.setLayoutX(81.0);
        separator.setLayoutY(92.0);
        separator.setPrefHeight(14.0);
        separator.setPrefWidth(450.0);

        txtUserName.setLayoutX(72.0);
        txtUserName.setLayoutY(-3.0);
        txtUserName.setText(comment.getUser().getFirstName() + " " + comment.getUser().getLastName() + ":");

        btnDelete.setLayoutX(553.0);
        btnDelete.setLayoutY(31.0);
        btnDelete.setMnemonicParsing(false);
        btnDelete.getStyleClass().add("danger");
        btnDelete.setText("Delete");

        getChildren().add(userphoto);
        getChildren().add(textComment);
        getChildren().add(labelDate);
        getChildren().add(btnClaim);
        getChildren().add(btnRepply);
        getChildren().add(separator);
        getChildren().add(txtUserName);
        if ((App.USER_ONLINE.getAuthorization().equals("ADMINISTRATOR")) || (App.USER_ONLINE.equals(comment.getUser()))) {
            getChildren().add(btnDelete);
        }

    }
}
