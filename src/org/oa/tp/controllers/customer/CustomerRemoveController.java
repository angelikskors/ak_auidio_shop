package org.oa.tp.controllers.customer;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Customer;


import java.net.URL;
import java.util.ResourceBundle;


public class CustomerRemoveController implements Initializable {
    @FXML
    public TextField id;
    @FXML
    public Label result;
    private ObservableList<Customer> observableList = CustomerController.observableList;


    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        DaoFacade daoFacade3 = new DaoFacade();

        Customer customer = daoFacade3.getCustomerDao().findById(Integer.parseInt(id.getText()));
        observableList.remove(customer);
        daoFacade3.getCustomerDao().delete(Integer.parseInt(id.getText()));
        result.setText("Deleted");
        Window window = id.getScene().getWindow();
        window.hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getObservablelist(ObservableList<Customer> observableList) {
        this.observableList = observableList;
    }
}
