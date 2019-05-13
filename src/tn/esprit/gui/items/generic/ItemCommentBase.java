package tn.esprit.gui.items.generic;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.esprit.gui.pages.PageCreateClaim;

public abstract class ItemCommentBase extends AnchorPane {

    protected final ImageView userphoto;
    protected final TextArea textComment;
    protected final Label labelDate;
    protected final Button btnClaim;
    protected final Button btnRepply;
    protected final Separator separator;
    protected final Label txtUserName;
    protected final Button btnDelete;

    public ItemCommentBase() {

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
        userphoto.setImage(new Image(getClass().getResourceAsStream("/resources/images/default.jpg")));

        textComment.setEditable(false);
        textComment.setLayoutX(72.0);
        textComment.setLayoutY(17.0);
        textComment.setPrefHeight(59.0);
        textComment.setPrefWidth(348.0);
        textComment.setText("Interesting job , i would like to contact HR Officer for more info,\n My mail");

        labelDate.setLayoutX(374.0);
        labelDate.setLayoutY(77.0);
        labelDate.setText("Date: 01/05/2019");

        btnClaim.setLayoutX(516.0);
        btnClaim.setLayoutY(31.0);
        btnClaim.setMnemonicParsing(false);
        btnClaim.getStyleClass().add("danger");
        btnClaim.setText("!");
        btnClaim.setOnMouseClicked(e->{
            Stage claimStage = new Stage();
            Scene claimScene = new Scene(new PageCreateClaim());
            claimStage.setScene(claimScene);
            claimStage.show();
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
        txtUserName.setText("Mehdi sarray:");

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
        getChildren().add(btnDelete);

    }
}
