package org.oa.tp.controllers.author;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Author;


import java.net.URL;
import java.util.ResourceBundle;


public class AuthorRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Author> observableList = AuthorController.observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();

        Author author = daoFacade3.getAuthorDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(author);
        daoFacade3.getAuthorDao().delete(Integer.parseInt(id.getText()));
        result.setText("Deleted");
        Window window = id.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Author> observableList) {
        this.observableList = observableList;
    }
}
