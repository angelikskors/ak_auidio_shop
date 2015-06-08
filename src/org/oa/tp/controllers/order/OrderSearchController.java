package org.oa.tp.controllers.order;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Order;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderSearchController implements Initializable {

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
        Order order = daoFacade3.getOrderDao().findById(Integer.parseInt(id.getText()));
        result.setText("Producer parameters: " + "Date " + order.getDate() + " Customer ID " + order.getCustomer_id() + " Amount " + order.getAmount());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}