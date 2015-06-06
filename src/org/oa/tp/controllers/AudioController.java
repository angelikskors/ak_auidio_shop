package org.oa.tp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static org.oa.tp.controllers.MainWindowController.showNewWindow;

public class AudioController implements Initializable {


    public static ObservableList<Audio> observableList;
    private final DaoFacade daoFacade3 = new DaoFacade();
    @FXML
    public TableView<Audio> audioListView;
    Parent root = null;
    private String titleSearchAudio = "Search Audio";

    @Override
    public void initialize(URL location, ResourceBundle resources) {




        System.out.println("______________________________________________________________________________________________");
        Audio audioChanged = new Audio(6, "Name6", 4, 3.3, 6, 55, 2);
        System.out.println("going to change " + audioChanged);
        audioChanged.setAlbumId(342);

        System.out.println(" changed " + audioChanged);
        daoFacade3.getAudioDao().update(audioChanged);
        System.out.println("______________________________________________________________________________________________");
        List<Audio> audioList = daoFacade3.getAudioDao().loadAll();
        for (Audio audio5 : audioList) {
            System.out.println("Audio New " + audio5);

        }

        daoFacade3.getAudioDao().saveAll();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        displayAudio(audioList);

    }

    @FXML
    public void handleAdd(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/audio/add_audio.fxml").load();
            showNewWindow("Add audio ", root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void displayAudio(List<Audio> groups) {
        observableList = FXCollections.observableList(groups);
        audioListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/audio/search_byId.fxml").load();
            showNewWindow("Search by ID ", root, 200, 200);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {
        Audio selectedAudio = audioListView.getSelectionModel().getSelectedItem();
        if (selectedAudio != null) {
            observableList.remove(selectedAudio);
        } else {
            try {
                root = Launcher.loader("fxml/audio/remove_byId.fxml").load();
                AudioRemoveController audioremove = Launcher.loader("fxml/audio/remove_byId.fxml").getController();
                audioremove.getObservablelist(observableList);
                showNewWindow("Remove Audio ", root, 200, 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}









