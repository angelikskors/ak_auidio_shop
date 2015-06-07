package org.oa.tp.controllers.cat;

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

import org.oa.tp.data.Cat;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

public class CatController implements Initializable {


    public static ObservableList<Cat> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADD_WINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/cat/add_cat.fxml";
    @FXML
    public TableView<Cat> catListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Cat> catList = daoFacade3.getCatDao().loadAll();
        daoFacade3.getCarDao().saveAll();
        displayCat(catList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            CatAddController catAddController = new CatAddController();
            loader.setController(catAddController);
            root = loader.load();
            showNewWindow(ADD_WINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayCat(List<Cat> groups) {
        observableList = FXCollections.observableList(groups);
        catListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            CatSearchController catSearchController = new CatSearchController();
            loader.setController(catSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Cat selectedCat = catListView.getSelectionModel().getSelectedItem();
        if (selectedCat != null) {
            observableList.remove(selectedCat);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getCatDao().delete(selectedCat.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                CatRemoveController catRemoveController = new CatRemoveController();
                loader.setController(catRemoveController);
                root = loader.load();
                catRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
