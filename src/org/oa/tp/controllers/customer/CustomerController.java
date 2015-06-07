package org.oa.tp.controllers.customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;

import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Customer;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;


public class CustomerController implements Initializable {


    public static ObservableList<Customer> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADD_WINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/customer/add_customer.fxml";
    @FXML
    public TableView<Customer> customerListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Customer> customerList = daoFacade3.getCustomerDao().loadAll();
        daoFacade3.getCustomerDao().saveAll();
        displayCustomer(customerList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            CustomerAddController customerAddController = new CustomerAddController();
            loader.setController(customerAddController);
            root = loader.load();
            showNewWindow(ADD_WINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayCustomer(List<Customer> groups) {
        observableList = FXCollections.observableList(groups);
        customerListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            CustomerSearchController customerSearchController = new CustomerSearchController();
            loader.setController(customerSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Customer selectedCustomer = customerListView.getSelectionModel().getSelectedItem();
        if (selectedCustomer != null) {
            observableList.remove(selectedCustomer);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getCustomerDao().delete(selectedCustomer.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                CustomerRemoveController customerRemoveController = new CustomerRemoveController();
                loader.setController(customerRemoveController);
                root = loader.load();
                customerRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
