package org.oa.tp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.oa.tp.core.Launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable {
    private final String titleAudios = "Audio";
    private final String titleAlbums = "Album";
    private final String titleCars = "Car";
    private final String titleCats = "Cat";
    private final String titleGenres = "Genre";
    private final String titleProducers = "Producer";
    private final String titleCustomers = "Customer";
    private final String titleOrders = "Order";
    private final String titleAuthors = "Author";

    public ImageView img;
    Parent root;

    public static void showNewWindow(String title, Parent root, int width, int height) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, width, height));
        stage.show();
    }

    public void handleAlbums(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/album/album_base.fxml").load();
            showNewWindow(titleAlbums, root, 800, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleAudios(ActionEvent actionEvent) {

        try {
            root = Launcher.loader("fxml/audio/audio_base.fxml").load();
            showNewWindow(titleAudios, root, 880, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleAuthors(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/author/author_base.fxml").load();
            showNewWindow(titleAuthors, root, 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleCars(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/car/car_base.fxml").load();
            showNewWindow(titleCars, root, 880, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleCats(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/cat/cat_base.fxml").load();
            showNewWindow(titleCats, root, 400, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleCustomers(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/customer/customer_base.fxml").load();
            showNewWindow(titleCustomers, root, 600, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleGenres(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/genre/genre_base.fxml").load();
            showNewWindow(titleGenres, root, 400, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleOrders(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/order/order_base.fxml").load();
            showNewWindow(titleOrders, root, 660, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleProducers(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/producer/producer_base.fxml").load();
            showNewWindow(titleProducers, root, 800, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("file: disco.png");
        img = new ImageView();
        img.setImage(image);
    }
}
