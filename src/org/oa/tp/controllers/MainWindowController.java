package org.oa.tp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.oa.tp.core.Launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable {
    private final String titleAudios = "Audio";
    Parent root;

    public static void showNewWindow(String title, Parent root) {
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void handleAlbums(ActionEvent actionEvent) {

    }

    public void handleAudios(ActionEvent actionEvent) {

        try {
            root = Launcher.loader("fxml/audio_base.fxml").load();
            showNewWindow(titleAudios, root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleAuthors(ActionEvent actionEvent) {

    }

    public void handleCars(ActionEvent actionEvent) {

    }

    public void handleCats(ActionEvent actionEvent) {

    }

    public void handleCustomers(ActionEvent actionEvent) {

    }

    public void handleGenres(ActionEvent actionEvent) {

    }

    public void handleOrders(ActionEvent actionEvent) {

    }

    public void handleProducers(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
