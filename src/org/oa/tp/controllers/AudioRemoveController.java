package org.oa.tp.controllers;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Audio;

import java.net.URL;
import java.util.AbstractList;
import java.util.ResourceBundle;


public class AudioRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Audio> observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();
        daoFacade3.getAudioDao().delete(Integer.parseInt(id.getText()));
        Audio audio = daoFacade3.getAudioDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(audio);
        result.setText("Deleted");
        Window window = result.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Audio> observableList) {
        this.observableList = observableList;
    }
}
