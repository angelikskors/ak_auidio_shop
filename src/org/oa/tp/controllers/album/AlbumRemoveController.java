package org.oa.tp.controllers.album;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Album;


import java.net.URL;
import java.util.ResourceBundle;

public class AlbumRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Album> observableList = AlbumController.observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();

        Album album = daoFacade3.getAlbumDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(album);
        daoFacade3.getAlbumDao().delete(Integer.parseInt(id.getText()));
        result.setText("Deleted");
        Window window = id.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Album> observableList) {
        this.observableList = observableList;
    }
}

