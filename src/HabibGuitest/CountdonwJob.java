/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HabibGuitest;

import eu.hansolo.tilesfx.Tile;
import eu.hansolo.tilesfx.Tile.SkinType;
import eu.hansolo.tilesfx.TileBuilder;
import eu.hansolo.tilesfx.fonts.Fonts;
import eu.hansolo.tilesfx.tools.Helper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 *
 * @author habib
 */
public class CountdonwJob extends HBox {

    private static final int SECONDS_PER_DAY = 86_400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private Tile days;
    private Tile hours;
    private Tile minutes;
    private Tile seconds;
    private Duration duration;
    private long lastTimerCall;
    private AnimationTimer timer;

    public CountdonwJob(Date expireDate) {
        days = createTile("DAYS", "0");
        hours = createTile("HOURS", "0");
        minutes = createTile("MINUTES", "0");
        seconds = createTile("SECONDS", "0");
Date now = new Date();
 double year = expireDate.getYear() -now.getYear() ;
double month = expireDate.getMonth() - now.getMonth() ;
double day = expireDate.getDay() - now.getDay();
 double hour = expireDate.getHours()- now.getHours();
 double mins = expireDate.getMinutes() - now.getMinutes() ;
 
double numberOfDays = year*360+month*30+day;
double numberOfhours = numberOfDays*24+hour+(mins/60);
        duration = Duration.hours(numberOfhours);
        
        lastTimerCall = System.nanoTime();
        timer = new AnimationTimer() {
            @Override
            public void handle(final long now) {
                if (now > lastTimerCall + 1_000_000_000l) {
                    duration = duration.subtract(Duration.seconds(1));

                    int remainingSeconds = (int) duration.toSeconds();
                    int d = remainingSeconds / SECONDS_PER_DAY;
                    int h = (remainingSeconds % SECONDS_PER_DAY) / SECONDS_PER_HOUR;
                    int m = ((remainingSeconds % SECONDS_PER_DAY) % SECONDS_PER_HOUR) / SECONDS_PER_MINUTE;
                    int s = (((remainingSeconds % SECONDS_PER_DAY) % SECONDS_PER_HOUR) % SECONDS_PER_MINUTE);

                    if (d == 0 && h == 0 && m == 0 && s == 0) {
                        timer.stop();
                    }

                    days.setDescription(Integer.toString(d));
                    hours.setDescription(Integer.toString(h));
                    minutes.setDescription(String.format("%02d", m));
                    seconds.setDescription(String.format("%02d", s));

                    lastTimerCall = now;
                }

            }
        };

        //HBox pane = new HBox(20, days, hours, minutes, seconds);
        this.setPadding(new Insets(10));
        this.setBackground(new Background(new BackgroundFill(Color.web("#606060"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setSpacing(20);
        this.getChildren().addAll(days, hours, minutes, seconds);

        timer.start();
    }

    private Tile createTile(final String TITLE, final String TEXT) {
        return TileBuilder.create().skinType(SkinType.CHARACTER)
                .prefSize(200, 200)
                .title(TITLE)
                .titleAlignment(TextAlignment.CENTER)
                .description(TEXT)
                .build();
    }
}
