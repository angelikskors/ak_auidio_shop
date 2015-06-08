package org.oa.tp.controllers.cat;

/**
 * Created by PC Kors on 08.06.2015.
 */

import javafx.collections.ObservableList;
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


public class CatRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Cat> observableList = CatController.observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();

        Cat cat = daoFacade3.getCatDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(cat);
        daoFacade3.getCatDao().delete(Integer.parseInt(id.getText()));
        result.setText("Deleted");
        Window window = id.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Cat> observableList) {
        this.observableList = observableList;
    }
}

