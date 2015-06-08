package org.oa.tp.controllers.genre;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Genre;


import java.net.URL;
import java.util.ResourceBundle;

public class GenreSearchController implements Initializable {

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
        Genre genre = daoFacade3.getGenreDao().findById(Integer.parseInt(id.getText()));
        result.setText("Genre parameters: " + "name " + genre.getName());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}
