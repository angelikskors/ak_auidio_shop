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


        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("Audios");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade3 = new DaoFacade();
        Audio audio = new Audio(1, "Name1", 2, 20.5, 3, 30, 1);
        Audio audio1 = new Audio(5, "Name2", 3, 30.5, 4, 50, 2);
        Audio audio2 = new Audio(2, "Name3", 10, 23.5, 3, 20, 3);
        Audio audio3 = new Audio(3, "Name5", 4, 25.5, 1, 10, 3);
        Audio audio4 = new Audio(4, "Name4", 1, 22.5, 4, 5, 5);

        List<Audio> audios = new ArrayList<>();
        audios.add(audio);
        audios.add(audio1);
        audios.add(audio2);
        audios.add(audio3);
        audios.add(audio4);

        for (Audio audio5 : audios) {
            System.out.println("Load objects " + audio5);
        }
        daoFacade3.getAudioDao().add(audio);

        System.out.println("______________________________________________________________________________________________");
        Audio audio6 = daoFacade3.getAudioDao().findById(1);
        System.out.println("found by Id " + audio6);

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
            root = Launcher.loader("fxml/add_audio.fxml").load();
            showNewWindow("Search by ID ", root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void displayAudio(List<Audio> groups) {
        observableList = FXCollections.observableList(groups);
        audioListView.setItems(observableList);
    }

    @FXML
    public void handleSearchById(ActionEvent actionEvent) {
        try {
            root = Launcher.loader("fxml/search_byId.fxml").load();
            showNewWindow("Search by ID ", root);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void handleRemove(ActionEvent actionEvent) {

    }
}









