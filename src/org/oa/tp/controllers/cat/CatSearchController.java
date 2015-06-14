package org.oa.tp.controllers.cat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Cat;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by PC Kors on 08.06.2015.
 */
public class CatSearchController implements Initializable {

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
        Cat cat = daoFacade3.getCatDao().findById(Integer.parseInt(id.getText()));
        result.setText("Cat parameters: " + " Breed " + cat.getBreed());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}