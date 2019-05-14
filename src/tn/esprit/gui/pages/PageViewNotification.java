/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tn.esprit.dao.exceptions.DataBaseException;
import tn.esprit.entities.Job;
import tn.esprit.entities.Notification;
import tn.esprit.entities.User;
import tn.esprit.gui.launch.App;
import tn.esprit.services.implementation.ServiceNotificationImpl;
import tn.esprit.services.interfaces.IServiceNotification;

/**
 *
 * @author mmsarray
 */
public class PageViewNotification extends BorderPane {

    private ListView listView;
    private Text topText = new Text("Notification List");
    private HBox hbox;
    private List<Notification> notificationList = new ArrayList();
    ObservableList<Notification> observableList = FXCollections.observableArrayList();
    private IServiceNotification notificationServ = new ServiceNotificationImpl();
    private List<Notification> notifyMe = new ArrayList<>();

    public PageViewNotification(User user) {
        hbox = new HBox();
        getStylesheets().add("/resources/css/theme.css");
        listView = new ListView();
        setListView(App.USER_ONLINE);
        hbox.getChildren().add(listView);
        setTop(topText);
        setCenter(hbox);
    }

    public void setListView(User user) {
        Notifications NotificationsBuilder = Notifications.create()
                .darkStyle()
                .title("Social Pro")
                .text("You Have a New Notification")
                .position(Pos.BOTTOM_RIGHT).hideAfter(Duration.seconds(7))
                .onAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                        ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewNotification(App.USER_ONLINE) {
                        });
                    }
                });

        try {

            notificationList = notificationServ.findAll().stream().filter(e -> e.getCompany().getRecruiter().equals(App.USER_ONLINE)).collect(Collectors.toList());
            System.out.println(notificationList.get(0).toString());
        } catch (DataBaseException ex) {
            Logger.getLogger(PageViewNotification.class.getName()).log(Level.SEVERE, null, ex);
        }

        observableList.setAll(notificationList);
        listView.setItems(observableList);
        listView.setCellFactory(new Callback<ListView<Notification>, javafx.scene.control.ListCell<Notification>>() {
            @Override
            public ListCell<Notification> call(ListView<Notification> listView) {
                ListCell cell = new ListViewCell();

                cell.setOnMouseClicked(e -> {

                    if (!cell.isEmpty()) {

                        Notification ntf = (Notification) cell.getItem();

                        e.consume();
                        try {
                            listView.getItems().remove(ntf);
                            notificationServ.delete(ntf);
                        } catch (DataBaseException ex) {
                            Logger.getLogger(PageViewNotification.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().remove(1);
                        ((HBox) App.GLOBAL_PANE_BORDER.getCenter()).getChildren().add(new PageViewJob(ntf.getJob()));
                        
                    }
                });

                return cell;
            }

        });
        listView.setOnMouseClicked(e -> {
            System.out.println("You clicked on an empty cell");
        });

        if (!notifyMe.isEmpty() && notifyMe.size() < notificationList.size()) {
            NotificationsBuilder.showInformation();
        }
        
        notifyMe = new ArrayList(notificationList);

    }

}
