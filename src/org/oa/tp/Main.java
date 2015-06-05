package org.oa.tp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.*;

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

        System.out.println("Authors");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade9=new DaoFacade();
        Author author=new Author(1,"Petr","Gerebzov",32);
        Author author1  =new Author(2,"Vyasheslav","Fiberistic",25);
        Author author2  =new Author(3,"Pavel","Ambaricin",15);


        List<Author> authors=new ArrayList<>();
        authors.add(author);
        authors.add(author1);
        authors.add(author2);
        daoFacade9.getAuthorDao().addAll(authors);
        System.out.println("______________________________________________________________________________________________");
        List<Author> authorList =daoFacade9.getAuthorDao().loadAll();
        for(Author author3  : authorList){
            System.out.println("Authors "+ author3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Customers");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade0=new DaoFacade();
        Customer customer=new Customer(1,"Petr",20,"pushkinskaya",3);
        Customer customer1 =new Customer(2,"Vyasheslav",2,"Lerkosnd",2);
        Customer customer2 =new Customer(3,"Pavel",33,"Gagarina",1);


        List<Customer> customers=new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        daoFacade0.getCustomerDao().addAll(customers);
        System.out.println("______________________________________________________________________________________________");
        List<Customer> customerList =daoFacade0.getCustomerDao().loadAll();
        for(Customer customer3  : customerList){
            System.out.println("Customers "+ customer3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Cats");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade4=new DaoFacade();
        Cat cat=new Cat(1,"persic",true);
        Cat cat1=new Cat(2,"dlinnochvost",true);
        Cat cat2=new Cat(3,"ushastik",false);


        List<Cat> cats=new ArrayList<>();
        cats.add(cat);
        cats.add(cat1);
        cats.add(cat2);
        daoFacade4.getCatDao().addAll(cats);
         System.out.println("______________________________________________________________________________________________");
        List<Cat> catList =daoFacade4.getCatDao().loadAll();
        for(Cat cat3  : catList){
            System.out.println("Cats "+ cat3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Cars");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade5=new DaoFacade();
        Car car=new Car(1,"bmw");
        Car car1=new Car(2,"porsche");
        Car car2=new Car(3,"mitsubischi");


        List<Car> cars=new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        daoFacade5.getCarDao().addAll(cars);
        System.out.println("______________________________________________________________________________________________");
        List<Car> carList =daoFacade5.getCarDao().loadAll();
        for(Car car3  : carList){
            System.out.println("Cars "+ car3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Genres");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade7=new DaoFacade();
        Genre genre=new Genre(1,"pop");
        Genre genre1=new Genre(2,"rock");
        Genre genre2=new Genre(3,"rap");


        List<Genre> genres=new ArrayList<>();
        genres.add(genre);
        genres.add(genre2);
        genres.add(genre1);
        daoFacade7.getGenreDao().addAll(genres);
        System.out.println("______________________________________________________________________________________________");
        List<Genre> genreList =daoFacade7.getGenreDao().loadAll();
        for(Genre genre3  : genreList){
            System.out.println("Genres  "+ genre3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Producers");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade6=new DaoFacade();
        Producer producer=new Producer(1,"Petr","Ivanov",car.getId(),cat.getId());
        Producer producer1=new Producer(2,"Valeriy","Guseev",car1.getId(),cat1.getId());
        Producer  producer2 =new Producer(3,"Evgeniy","Rost",car2.getId(),cat2.getId());


        List<Producer> producers=new ArrayList<>();
        producers.add(producer);
        producers.add(producer1);
        producers.add(producer2);
        daoFacade6.getProducerDao().addAll(producers);
        System.out.println("______________________________________________________________________________________________");
        List<Producer> producers3 =daoFacade6.getProducerDao().loadAll();
        for(Producer producer3  : producers3){
            System.out.println("Producers "+ producer3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("Albums");
        System.out.println("");
        System.out.println("");


        DaoFacade daoFacade=new DaoFacade();


        Album item=new Album(0,1999,"TTT",producer.getId(),"usdfiusdf","dhgdfg");
        Album item1=new Album(2,2000,"hffhf",producer1.getId(),"sjhk","shdf");
        Album item2=new Album(3,2005,"reyer",producer.getId(),"jshdf","jskdfh");
        Album item3=new Album(4,20003,"sdfsfd",producer2.getId(),"hsdhsf","jsdhf");
        Album item4=new Album(5,34994,"sfdjsjfdjj",producer2.getId(),"skjhdf","usd");

        List<Album> albums=new ArrayList<>();
        albums.add(item);
        albums.add(item1);
        albums.add(item2);
        albums.add(item3);
        albums.add(item4);
        for (Album album:albums){
            System.out.println("Loading objects "+album);
        }
        daoFacade.getAlbumDao().addAll(albums);

        System.out.println("______________________________________________________________________________________________");
        Album album1=daoFacade.getAlbumDao().findById(1);
        System.out.println("found by Id " + album1);

        System.out.println("______________________________________________________________________________________________");
        Album changed=new Album(3, 2324, "fee",producer.getId(),"shdfhsf","shfjsfh");
        System.out.println("going to change " + changed);
        changed.setName("New name");
        changed.setYear(3400);
        System.out.println(" changed " + changed);
        daoFacade.getAlbumDao().update(changed);
        System.out.println("______________________________________________________________________________________________");
        List<Album>list =daoFacade.getAlbumDao().loadAll();
        for(Album album : list){
            System.out.println("Album New "+ album);

        }

        daoFacade.getAlbumDao().saveAll();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("Audios");
        System.out.println("");
        System.out.println("");

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
