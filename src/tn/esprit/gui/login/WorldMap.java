/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.login;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.tools.Country;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import tn.esprit.services.util.Randomizer;

/**
 *
 * @author mdsaadlaoui
 */
public class WorldMap {

    /**
     *
     */
    public Tile worldMap;

    /**
     *
     * @param tileWidth
     * @param tileHeigh
     */
    public WorldMap(double tileWidth, double tileHeigh) {

        for (Country value1 : Country.values()) {
            double value = Randomizer.randomIntgeger(10);
            Color color=Tile.GRAY;
            if (value > 8) {
                color = Tile.RED;
            } else if (value > 6) {
                color = Tile.ORANGE;
            } else if (value > 4) {
                color = Tile.YELLOW_ORANGE;
            } 
            value1.setColor(color);
        }

        worldMap = TileBuilder.create()
                .prefSize(tileWidth, tileHeigh)
                .skinType(Tile.SkinType.WORLDMAP)
                .title(LanguageToolBar.BUNDLE.getString("loginmaptitle"))
                .text(LanguageToolBar.BUNDLE.getString("loginmaptext"))
                .textVisible(true)
                .textAlignment(TextAlignment.LEFT)
                .build();

    }

}
