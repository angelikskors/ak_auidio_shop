package org.oa.tp.controllers.order;


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
import org.oa.tp.data.Order;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

public class OrderController implements Initializable {


    public static ObservableList<Order> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADD_WINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/order/add_order.fxml";
    @FXML
    public TableView<Order> orderListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Order> orderList = daoFacade3.getOrderDao().loadAll();
        daoFacade3.getOrderDao().saveAll();
        displayOrder(orderList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            OrderAddController orderAddController = new OrderAddController();
            loader.setController(orderAddController);
            root = loader.load();
            showNewWindow(ADD_WINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayOrder(List<Order> groups) {
        observableList = FXCollections.observableList(groups);
        orderListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            OrderSearchController orderSearchController = new OrderSearchController();
            loader.setController(orderSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Order selectedOrder = orderListView.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            observableList.remove(selectedOrder);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getOrderDao().delete(selectedOrder.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                OrderRemoveController orderRemoveController = new OrderRemoveController();
                loader.setController(orderRemoveController);
                root = loader.load();
                orderRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

