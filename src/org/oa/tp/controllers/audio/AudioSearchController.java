package org.oa.tp.controllers.audio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Audio;


import java.net.URL;
import java.util.ResourceBundle;


public class AudioSearchController implements Initializable {

    public Label result;
    @FXML
    private Label whatToSearch;
    @FXML
    private TextField id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        whatToSearch.setText("Write down the ID");
    }

    @FXML
    public void handleGetResult(ActionEvent actionEvent) {

        DaoFacade daoFacade3 = new DaoFacade();
        Audio audio6 = daoFacade3.getAudioDao().findById(Integer.parseInt(id.getText()));
        result.setText("Audio parameters: " + "name " + audio6.getName() + " duration " + audio6.getDuration() + " price " + audio6.getPrice());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}
