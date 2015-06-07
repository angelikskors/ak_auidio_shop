package org.oa.tp.controllers.author;

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


public class AuthorSearchController implements Initializable {

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
        Author author = daoFacade3.getAuthorDao().findById(Integer.parseInt(id.getText()));
        result.setText("Author parameters: " + "First Name " + author.getFirstName() + " Last Name " + author.getLastName() + " age " + author.getAge());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}