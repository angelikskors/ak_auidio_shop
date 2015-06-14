package org.oa.tp.controllers.car;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import org.oa.tp.controllers.author.AuthorAddController;
import org.oa.tp.controllers.author.AuthorRemoveController;
import org.oa.tp.controllers.author.AuthorSearchController;
import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Car;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

/**
 * Created by PC Kors on 08.06.2015.
 */
public class CarController implements Initializable {


    public static ObservableList<Car> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADDWINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/car/add_car.fxml";
    @FXML
    public TableView<Car> carListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Car> carList = daoFacade3.getCarDao().loadAll();
        daoFacade3.getCarDao().saveAll();
        displayCar(carList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            AuthorAddController authorAddController = new AuthorAddController();
            loader.setController(authorAddController);
            root = loader.load();
            showNewWindow(ADDWINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayCar(List<Car> groups) {
        observableList = FXCollections.observableList(groups);
        carListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            CarSearchController carSearchController = new CarSearchController();
            loader.setController(carSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Car selectedCar = carListView.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            observableList.remove(selectedCar);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getCarDao().delete(selectedCar.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                CarRemoveController carRemoveController = new CarRemoveController();
                loader.setController(carRemoveController);
                root = loader.load();
                carRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
