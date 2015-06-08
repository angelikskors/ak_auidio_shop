package org.oa.tp.controllers.customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Customer;
;

import java.net.URL;
import java.util.ResourceBundle;


public class CustomerSearchController implements Initializable {

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
        Customer customer = daoFacade3.getCustomerDao().findById(Integer.parseInt(id.getText()));
        result.setText("Customer parameters: " + "name " + customer.getName() + " Address " + customer.getAddress() + " phone " + customer.getPhone());
        Window window = result.getScene().getWindow();
        window.hide();
    }
}