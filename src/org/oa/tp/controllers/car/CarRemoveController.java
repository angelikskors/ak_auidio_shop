package org.oa.tp.controllers.car;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.controllers.audio.AudioController;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Car;
import org.oa.tp.data.Cat;

import java.net.URL;
import java.util.ResourceBundle;


public class CarRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Car> observableList = CarController.observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();

        Car car = daoFacade3.getCarDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(car);
        daoFacade3.getCarDao().delete(Integer.parseInt(id.getText()));
        result.setText("Deleted");
        Window window = id.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Car> observableList) {
        this.observableList = observableList;
    }


}
