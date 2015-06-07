package org.oa.tp.controllers.album;

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


public class AlbumSearchController implements Initializable {

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
        Album album = daoFacade3.getAlbumDao().findById(Integer.parseInt(id.getText()));
        result.setText("Album parameters: " + "name " + album.getName() + " year " + album.getYear() + " country " + album.getCountry() + " language " + album.getCountry());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}
