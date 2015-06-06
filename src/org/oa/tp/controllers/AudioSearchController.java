package org.oa.tp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Audio;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class AudioSearchController implements Initializable {

    @FXML
    private Label whatToSearch;
    @FXML
    private TextField ida;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        whatToSearch.setText("Write down the id");


    }

    @FXML
    public void handleGetResult(ActionEvent actionEvent) {

        DaoFacade daoFacade3 = new DaoFacade();
        Audio audio6 = daoFacade3.getAudioDao().findById(Integer.parseInt(ida.getText()));

    }
}
