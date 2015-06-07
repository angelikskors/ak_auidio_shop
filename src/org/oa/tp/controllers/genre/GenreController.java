package org.oa.tp.controllers.genre;

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
import org.oa.tp.data.Genre;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;


public class GenreController implements Initializable {


    public static ObservableList<Genre> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADD_WINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/genre/add_genre.fxml";
    @FXML
    public TableView<Genre> genreListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Genre> genreList = daoFacade3.getGenreDao().loadAll();
        daoFacade3.getGenreDao().saveAll();
        displayGenre(genreList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            GenreAddController genreAddController = new GenreAddController();
            loader.setController(genreAddController);
            root = loader.load();
            showNewWindow(ADD_WINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayGenre(List<Genre> groups) {
        observableList = FXCollections.observableList(groups);
        genreListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            GenreSearchController genreSearchController = new GenreSearchController();
            loader.setController(genreSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Genre selectedGenre = genreListView.getSelectionModel().getSelectedItem();
        if (selectedGenre != null) {
            observableList.remove(selectedGenre);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getGenreDao().delete(selectedGenre.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                GenreRemoveController genreRemoveController = new GenreRemoveController();
                loader.setController(genreRemoveController);
                root = loader.load();
                genreRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
