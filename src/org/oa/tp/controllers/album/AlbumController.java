package org.oa.tp.controllers.album;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Album;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
    private ListView<Album> albumListView;
    @FXML
    private ListView<Album> albumsView;

    @FXML
    private ProgressBar progressLoading;
    private boolean createMode = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        List<Album> albumList = daoFacade.getAlbumDao().loadAll();
        daoFacade.getAlbumDao().saveAll();
        displayAlbum(albumList);
        if (!createMode) {
            getAlbums();
        }
        Task<Album[]> getAllAlbums = new Task<Album[]>() {
            @Override
            protected Album[] call() throws Exception {
                Thread.sleep(5000);
                return getAlbums();
            }
        };

        progressLoading.visibleProperty().bind(getAllAlbums.runningProperty());

        getAllAlbums.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                Album[] albums = getAllAlbums.getValue();
                ObservableList<Album> albumObservableList = FXCollections.observableArrayList(albums);
                albumListView.setItems(albumObservableList);
            }
        });
        new Thread(getAllAlbums).start();
    }

    private Album[] getAlbums() {

        try {
            URL url = new URL("http://localhost:8084/ak_shop_audio_web/albums?method=get");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            Gson gson = new Gson();
            Album[] albums = gson.fromJson(response.toString(), Album[].class);

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
