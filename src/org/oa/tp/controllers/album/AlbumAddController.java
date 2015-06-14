package org.oa.tp.controllers.album;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Album;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;


public class AlbumAddController implements Initializable {
    private final DaoFacade daoFacade = new DaoFacade();
    @FXML
    public TextField idTextField;
    @FXML
    public TextField nameTextField;
    @FXML
    public TextField yearTextField;
    @FXML
    public TextField producer_idTextField;
    @FXML
    public TextField countryTextField;
    @FXML
    public TextField languageTextField;
    long id;
    int year;
    long producer_id;
    String name;
    String country;
    String language;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    private boolean createAlbum(long id, int year, String name, long producer_id, String country, String language) {
        try {
            URL url = new URL("http://localhost:8080/ak_shop_audio_web/albums");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            OutputStream outputStream = urlConnection.getOutputStream();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("method").append("=").append("create").append("&");
            stringBuilder.append("id").append("=").append(id).append("&");
            stringBuilder.append("year").append("=").append(year);
            stringBuilder.append("name").append("=").append(name).append("&");
            stringBuilder.append("producer_id").append("=").append(producer_id);
            stringBuilder.append("country").append("=").append(country).append("&");
            stringBuilder.append("producer_id").append("=").append(producer_id).append("&");
            stringBuilder.append("language").append("=").append(language);

            writer.write(stringBuilder.toString());
            writer.flush();
            writer.close();


            int responseCode = urlConnection.getResponseCode();
            System.out.println("response code : " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = null;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            System.out.println("response : " + response.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @FXML
    public void handleSave(ActionEvent actionEvent) {
        id = Long.parseLong(idTextField.getText());
        year = Integer.parseInt(yearTextField.getText());
        producer_id = Long.parseLong(producer_idTextField.getText());
        name = nameTextField.getText();
        country = countryTextField.getText();
        language = languageTextField.getText();

        Album album = new Album(id, year, name, producer_id, country, language);


        AlbumController.observableList.add(album);
        //     daoFacade.getAlbumDao().add(album);
        Task<Boolean> createAlbum = new Task<Boolean>() {
            @Override
            protected Boolean call() throws Exception {
                return createAlbum(id, year, name, producer_id, country, language);
            }
        };

        createAlbum.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                idTextField.getScene().getWindow().hide();

            }
        });
        new Thread(createAlbum).start();
    }

}


