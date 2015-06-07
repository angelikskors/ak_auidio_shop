package org.oa.tp.controllers.audio;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Audio;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by PC Kors on 06.06.2015.
 */
public class AudioAddController implements Initializable {

    private final DaoFacade daoFacade3 = new DaoFacade();
    public TextField audio_nameTextField;
    public TextField author_idTextField;
    public TextField durationTextField;
    public TextField priceTextField;
    public TextField genre_idTextField;
    public TextField album_idTextField;
    String audio_name;
    Long author_id;
    Integer duration;
    Double price;
    Long genre_id;
    Long album_id;
    private Audio audio;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void handleSave(ActionEvent actionEvent) {
        audio_name = audio_nameTextField.getText();
        author_id = Long.parseLong(author_idTextField.getText());
        duration = Integer.parseInt(durationTextField.getText());
        price = Double.parseDouble(priceTextField.getText());
        genre_id = Long.parseLong(genre_idTextField.getText());
        album_id = Long.parseLong(album_idTextField.getText());

        audio = new Audio(0, audio_name, author_id, price, genre_id, duration, album_id);
        AudioController.observableList.add(audio);
        daoFacade3.getAudioDao().add(audio);
        Window window = album_idTextField.getScene().getWindow();
        window.hide();
    }
}
