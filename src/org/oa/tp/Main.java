package org.oa.tp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.Album;
import org.oa.tp.data.Audio;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        System.out.println("Albums");
    System.out.println("");
    System.out.println("");
   // DaoFacade daoFacade1=new DaoFacade();
  //  daoFacade1.getAlbumDao().deleteAll();

    DaoFacade daoFacade=new DaoFacade();


    Album item=new Album(0,1999,"TTT",3,"usdfiusdf","dhgdfg");
    Album item1=new Album(2,2000,"hffhf",234,"sjhk","shdf");
    Album item2=new Album(3,2005,"reyer",234,"jshdf","jskdfh");
    Album item3=new Album(4,20003,"sdfsfd",456,"hsdhsf","jsdhf");
    Album item4=new Album(5,34994,"sfdjsjfdjj",56,"skjhdf","usd");

    List<Album> albums=new ArrayList<>();
    albums.add(item);
    albums.add(item1);
    albums.add(item2);
    albums.add(item3);
    albums.add(item4);
    for (Album album:albums){
        System.out.println("Load objects "+album);
    }
    daoFacade.getAlbumDao().addAll(albums);

    System.out.println("______________________________________________________________________________________________");
    Album album1=daoFacade.getAlbumDao().findById(1);
    System.out.println("found by Id " + album1);

    System.out.println("______________________________________________________________________________________________");
    Album changed=new Album(3, 2324, "fee",2355,"shdfhsf","shfjsfh");
    System.out.println("going to change " + changed);
    changed.setName("New name");
    changed.setYear(3400);
    System.out.println(" changed " + changed);
    daoFacade.getAlbumDao().update(changed);
    System.out.println("______________________________________________________________________________________________");
    List<Album>list =daoFacade.getAlbumDao().loadAll();
    for(Album album : list){
        System.out.println("Album New "+ list);

    }

    daoFacade.getAlbumDao().saveAll();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


    System.out.println("Audios");
    System.out.println("");
    System.out.println("");
   // DaoFacade daoFacade2=new DaoFacade();
     //   daoFacade2.getAudioDao().deleteAll();

    DaoFacade daoFacade3=new DaoFacade();
    Audio audio=new Audio(1,"Name1",2,20.5,3,30,1);
        Audio audio1=new Audio(5,"Name2",3,30.5,4,50,2);
        Audio audio2=new Audio(2,"Name3",10,23.5,3,20,3);
        Audio audio3=new Audio(3,"Name5",4,25.5,1,10,3);
        Audio audio4=new Audio(4,"Name4",1,22.5,4,5,5);

    List<Audio> audios=new ArrayList<>();
        audios.add(audio);
        audios.add(audio1);
        audios.add(audio2);
        audios.add(audio3);
        audios.add(audio4);

    for (Audio audio5:audios){
        System.out.println("Load objects "+audio5);
    }
        daoFacade3.getAudioDao().addAll(audios);

    System.out.println("______________________________________________________________________________________________");
    Audio audio6=daoFacade3.getAudioDao().findById(1);
    System.out.println("found by Id " + audio6);

    System.out.println("______________________________________________________________________________________________");
    Audio audioChanged=new Audio(6,"Name6",4,3.3,6,55,2);
    System.out.println("going to change " + audioChanged);
        audioChanged.setAlbumId(342);

    System.out.println(" changed " + audioChanged);
        daoFacade3.getAudioDao().update(audioChanged);
    System.out.println("______________________________________________________________________________________________");
    List<Audio> audioList =daoFacade3.getAudioDao().loadAll();
    for(Audio audio5  : audioList){
        System.out.println("Album New "+ audio5);

    }

        daoFacade3.getAudioDao().saveAll();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

}
}
