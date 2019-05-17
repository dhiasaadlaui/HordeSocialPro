package tn.esprit.gui.pages;

import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public abstract class PageViewReclamModeratorBase extends AnchorPane {

    protected final HBox hBox;
    protected final Button button;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final ImageView imageView;
    protected final TitledPane titledPane;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Button button3;

    public PageViewReclamModeratorBase() {

        hBox = new HBox();
        button = new Button();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        imageView = new ImageView();
        titledPane = new TitledPane();
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        button3 = new Button();

        setId("AnchorPane");
        setPrefHeight(447.0);
        setPrefWidth(712.0);
        setStyle("-fx-background-color: #2C3A47;");

        hBox.setLayoutX(93.0);
        hBox.setLayoutY(340.0);
        hBox.setPrefHeight(32.0);
        hBox.setPrefWidth(572.0);
        hBox.setSpacing(50.0);

        button.setMnemonicParsing(false);
        button.setPrefHeight(32.0);
        button.setPrefWidth(141.0);
        button.getStyleClass().add("warning");
        button.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button.setText("Remove Comment");

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(32.0);
        button0.setPrefWidth(118.0);
        button0.getStyleClass().add("primary");
        button0.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button0.setText("DisableJob");

        button1.setMnemonicParsing(false);
        button1.setPrefHeight(32.0);
        button1.setPrefWidth(101.0);
        button1.getStyleClass().add("primary");
        button1.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button1.setText("Reject");

        button2.setMnemonicParsing(false);
        button2.setPrefHeight(32.0);
        button2.setPrefWidth(171.0);
        button2.getStyleClass().add("danger");
        button2.getStylesheets().add("/tn/esprit/gui/pages/../../../../resources/css/theme.css");
        button2.setText("Redirect");

        imageView.setFitHeight(87.0);
        imageView.setFitWidth(129.0);
        imageView.setLayoutX(116.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../../resources/images/defaultcompany.jpg").toExternalForm()));

        titledPane.setAnimated(false);
        titledPane.setLayoutX(248.0);
        titledPane.setLayoutY(14.0);
        titledPane.setPrefHeight(294.0);
        titledPane.setPrefWidth(417.0);
        titledPane.setText("Comments");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(262.0);
        anchorPane.setPrefWidth(402.0);
        titledPane.setContent(anchorPane);

        label.setLayoutX(23.0);
        label.setLayoutY(132.0);
        label.setText("Status");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label0.setLayoutX(123.0);
        label0.setLayoutY(132.0);
        label0.setText("OPEN");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label1.setLayoutX(23.0);
        label1.setLayoutY(169.0);
        label1.setText("Company");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label2.setLayoutX(123.0);
        label2.setLayoutY(169.0);
        label2.setText("companyName");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label3.setLayoutX(25.0);
        label3.setLayoutY(209.0);
        label3.setText("Recruiter");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label4.setLayoutX(123.0);
        label4.setLayoutY(209.0);
        label4.setText("recruiterName");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label5.setLayoutX(25.0);
        label5.setLayoutY(253.0);
        label5.setText("Title");
        label5.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        label6.setLayoutX(123.0);
        label6.setLayoutY(253.0);
        label6.setText("JobTitle");
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#d7caca"));

        button3.setLayoutX(524.0);
        button3.setLayoutY(387.0);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(31.0);
        button3.setPrefWidth(144.0);
        button3.setText("SendMail");
        button3.setOnAction((event) -> {
               Font blueFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.NORMAL, new CMYKColor(255, 0, 0, 0));
		Font redFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.BOLD, new CMYKColor(0, 255, 0, 0));
		Font yellowFont = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 255, 0));
           
            try {
           
          Document document  = new Document() ;
          PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream("C:/Users/mghozzi/Desktop/plll.pdf"));
         
            document.open();
              com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance("src/resources/images/azer.png");
             double percent = 0.5;
           image1.scaleAbsolute(150,130);
 
               Paragraph chapterTitle = new Paragraph("Horde Social Pro ADMINISTRATION ", redFont);
                Paragraph paragraphOne = new Paragraph("Objet : Reclamation a propos de votre publication ");
                 Paragraph paragraphtwo = new Paragraph("Madame, Monsieur,\n" +
"Le 8 septembre 1996, j’ai acheté chez vous un téléviseur (marque), (modèle),\n" +
"(n° de série) (facture n°).3\n" +
"Depuis l’achat, ce téléviseur n’a jamais bien fonctionné : (Décrivez le problème). Je\n" +
"l’ai rapporté à trois reprises (les 15 janvier, 12 février et 18 mars 1997) à votre\n" +
"magasin, pour des périodes d’examen d’environ trois semaines chaque fois. Quand\n" +
"je reprenais possession de l’appareil, vos techniciens m’affirmaient que le problème\n" +
"était résolu, mais ce téléviseur ne fonctionnait pas bien et ne fonctionne toujours\n" +
"pas bien.4\n" +
"Puisque ce téléviseur est défectueux et que vos techniciens ne peuvent le réparer,\n" +
"je vous demande de le remplacer.5\n" +
" J’attends votre réponse dans les 10 jours de la\n" +
"réception de la présente, à défaut de quoi j’intenterai des poursuites judiciaires\n" +
"contre vous sans autre avis ni délai.\n" +
"Veuillez donc agir en conséquence.  ", blueFont);
                  Paragraph paragraphsignature = new Paragraph("ADMINISTRATION", yellowFont) ;
		    Chapter chapter1 = new Chapter(chapterTitle, 1);
		    chapter1.setNumberDepth(0);
          
        
         document.add(chapter1);
         document.add(paragraphOne);
         document.add(paragraphtwo);
          document.add(image1);
          document.add(paragraphsignature);
        document.close();
      }catch(Exception e) {
          System.out.println(e);
      }
      System.out.println("generated success"); 
 
        });
    
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        hBox.getChildren().add(button1);
        hBox.getChildren().add(button2);
        getChildren().add(hBox);
        getChildren().add(imageView);
        getChildren().add(titledPane);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(label6);
        getChildren().add(button3);

    }
}
