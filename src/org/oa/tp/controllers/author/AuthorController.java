package org.oa.tp.controllers.author;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import org.oa.tp.controllers.audio.AudioAddController;
import org.oa.tp.controllers.audio.AudioRemoveController;
import org.oa.tp.controllers.audio.AudioSearchController;
import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Author;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;


public class AuthorController implements Initializable {


    public static ObservableList<Author> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADDWINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/author/add_author.fxml";
    @FXML
    public TableView<Author> authorListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Author> audioList = daoFacade3.getAuthorDao().loadAll();
        daoFacade3.getAuthorDao().saveAll();
        displayAuthor(audioList);
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


    public void displayAuthor(List<Author> groups) {
        observableList = FXCollections.observableList(groups);
        authorListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            AuthorSearchController authorSearchController = new AuthorSearchController();
            loader.setController(authorSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Author selectedAuthor = authorListView.getSelectionModel().getSelectedItem();
        if (selectedAuthor != null) {
            observableList.remove(selectedAuthor);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getAuthorDao().delete(selectedAuthor.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                AuthorRemoveController authorRemoveController = new AuthorRemoveController();
                loader.setController(authorRemoveController);
                root = loader.load();
                authorRemoveController.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}









