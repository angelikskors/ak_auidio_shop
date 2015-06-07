package org.oa.tp.controllers.album;

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
import org.oa.tp.data.Album;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

public class AlbumController implements Initializable {

    public static ObservableList<Album> observableList;
    private final DaoFacade daoFacade = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADDWINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/album/add_album.fxml";
    @FXML
    public TableView<Album> albumTableView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Album> albumList = daoFacade.getAlbumDao().loadAll();
        daoFacade.getAlbumDao().saveAll();
        displayAlbum(albumList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            AlbumAddController albumAddController = new AlbumAddController();
            loader.setController(albumAddController);
            root = loader.load();
            showNewWindow(ADDWINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayAlbum(List<Album> groups) {
        observableList = FXCollections.observableList(groups);
        albumTableView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            AlbumSearchController albumSearchController = new AlbumSearchController();
            loader.setController(albumSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Album selectedAlbum = albumTableView.getSelectionModel().getSelectedItem();
        if (selectedAlbum != null) {
            observableList.remove(selectedAlbum);
            daoFacade.getAlbumDao().delete(selectedAlbum.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                AlbumRemoveController albumRemoveController = new AlbumRemoveController();
                loader.setController(albumRemoveController);
                root = loader.load();
                albumRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
