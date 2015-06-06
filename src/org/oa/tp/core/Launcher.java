package org.oa.tp.core;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.oa.tp.Main;

import java.io.IOException;


public class Launcher {
    public static void showMainWindow() {
        Parent root = null;

        try {
            root = loader("views/main_window.fxml").load();
        } catch (IOException e) {
            L.error("Exit", e);
            Platform.exit();
        }
        Main.getPrimaryStage().setTitle("Audio Shop");
        Main.getPrimaryStage().setScene(new Scene(root, 600, 420));
    }

    public static FXMLLoader loader(String uri) {
        return new FXMLLoader(Main.class.getResource(uri));
    }


}
