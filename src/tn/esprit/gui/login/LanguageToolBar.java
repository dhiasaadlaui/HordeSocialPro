/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Dhia
 */
public class LanguageToolBar extends HBox {

    /**
     *
     */
    public LanguageToolBar() {
        // ------------initialisation------------
        Image imageFr = new Image(getClass().getResourceAsStream("/resources/images/fr.png"), 23, 17, false, false);
        Button btn_fr = new Button(LanguageToolBar.BUNDLE.getString("french"), new ImageView(imageFr));

        Image imageEn = new Image(getClass().getResourceAsStream("/resources/images/en.png"), 23, 17, false, false);
        Button btn_en = new Button(LanguageToolBar.BUNDLE.getString("english"), new ImageView(imageEn));

        Image imageAr = new Image(getClass().getResourceAsStream("/resources/images/ar.png"), 23, 17, false, false);
        Button btn_ar = new Button(LanguageToolBar.BUNDLE.getString("arabic"), new ImageView(imageAr));

        // ------------Styling------------
        this.getStylesheets().add("/resources/css/theme.css");
        btn_fr.getStyleClass().add("info");
        btn_en.getStyleClass().add("primary");
        btn_ar.getStyleClass().add("warning");
        this.setPadding(new Insets(0, 0, 0, 500));
        //------------Logic
        btn_fr.setOnMouseClicked(e -> {
            loadLang("fr");
            btn_ar.setText(LanguageToolBar.BUNDLE.getString("arabic"));
            btn_en.setText(LanguageToolBar.BUNDLE.getString("english"));
            btn_fr.setText(LanguageToolBar.BUNDLE.getString("french"));
        });
        btn_en.setOnMouseClicked(e -> {
            loadLang("en");
            btn_ar.setText(LanguageToolBar.BUNDLE.getString("arabic"));
            btn_en.setText(LanguageToolBar.BUNDLE.getString("english"));
            btn_fr.setText(LanguageToolBar.BUNDLE.getString("french"));
        });
        btn_ar.setOnMouseClicked(e -> {
            loadLang("ar");
            btn_ar.setText(LanguageToolBar.BUNDLE.getString("arabic"));
            btn_en.setText(LanguageToolBar.BUNDLE.getString("english"));
            btn_fr.setText(LanguageToolBar.BUNDLE.getString("french"));
        });

        setSpacing(3);
        getChildren().addAll(btn_en, btn_fr, btn_ar);
    }

    /**
     *
     */
    public static ResourceBundle BUNDLE = ResourceBundle.getBundle("resources.language.lang_en");
    ;

    /**
     *
     */
    public static Locale LOCALE;

    /**
     *
     * @param lang
     */
    public static void loadLang(String lang) {
        LOCALE = new Locale(lang);
        BUNDLE = ResourceBundle.getBundle("resources.language.lang", LOCALE);
        LoginGUI.loadLoginGuiLang();

    }

}
