package org.oa.tp.controllers.order;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.controllers.audio.AudioController;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Order;


import java.net.URL;
import java.util.ResourceBundle;

public class OrderRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Order> observableList = OrderController.observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();

        Order order = daoFacade3.getOrderDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(order);
        daoFacade3.getOrderDao().delete(Integer.parseInt(id.getText()));
        result.setText("Deleted");
        Window window = id.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Order> observableList) {
        this.observableList = observableList;
    }
}

