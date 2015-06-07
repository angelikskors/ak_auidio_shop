package org.oa.tp.controllers.producer;

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
import org.oa.tp.data.Producer;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

public class ProducerController implements Initializable {


    public static ObservableList<Producer> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADD_WINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/producer/add_producer.fxml";
    @FXML
    public TableView<Producer> producerListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Producer> producerList = daoFacade3.getProducerDao().loadAll();
        daoFacade3.getProducerDao().saveAll();
        displayProducer(producerList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            ProducerAddController producerAddController = new ProducerAddController();
            loader.setController(producerAddController);
            root = loader.load();
            showNewWindow(ADD_WINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayProducer(List<Producer> groups) {
        observableList = FXCollections.observableList(groups);
        producerListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            ProducerSearchController producerSearchController = new ProducerSearchController();
            loader.setController(producerSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Producer selectedProducer = producerListView.getSelectionModel().getSelectedItem();
        if (selectedProducer != null) {
            observableList.remove(selectedProducer);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getCatDao().delete(selectedProducer.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                ProducerRemoveController producerRemoveController = new ProducerRemoveController();
                loader.setController(producerRemoveController);
                root = loader.load();
                producerRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
