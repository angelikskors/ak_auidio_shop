package org.oa.tp.controllers.audio;

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
import org.oa.tp.data.Audio;

import java.io.IOException;
import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

public class AudioController implements Initializable {


    public static ObservableList<Audio> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    private final String SearchWindow = "Searcher";
    private final String RemoveWindow = "Remover";
    private final String ADDWINDOW = "Adder";
    private final String FILE_FXML_REMOVE = "fxml/audio/remove_byId.fxml";
    private final String FILE_FXML_SEARCH = "fxml/audio/search_byId.fxml";
    private final String FILE_FXML_ADD = "fxml/audio/add_audio.fxml";
    @FXML
    public TableView<Audio> audioListView;
    private Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Audio> audioList = daoFacade3.getAudioDao().loadAll();
        daoFacade3.getAudioDao().saveAll();
        displayAudio(audioList);
    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_ADD);
            AudioAddController audioAddController = new AudioAddController();
            loader.setController(audioAddController);
            root = loader.load();
            showNewWindow(ADDWINDOW, root, 400, 600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void displayAudio(List<Audio> groups) {
        observableList = FXCollections.observableList(groups);
        audioListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = Launcher.loader(FILE_FXML_SEARCH);
            AudioSearchController audioSearchController = new AudioSearchController();
            loader.setController(audioSearchController);
            root = loader.load();
            showNewWindow(SearchWindow, root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Audio selectedAudio = audioListView.getSelectionModel().getSelectedItem();
        if (selectedAudio != null) {
            observableList.remove(selectedAudio);
            DaoFacade daoFacade3 = new DaoFacade();
            daoFacade3.getAudioDao().delete(selectedAudio.getId());
        } else {
            try {
                FXMLLoader loader = Launcher.loader(FILE_FXML_REMOVE);
                AudioRemoveController audioremove = new AudioRemoveController();
                loader.setController(audioremove);
                root = loader.load();
                audioremove.getObservablelist(observableList);
                showNewWindow(RemoveWindow, root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}









