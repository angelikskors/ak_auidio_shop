package org.oa.tp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.oa.tp.core.Launcher;
import org.oa.tp.dao.DaoFacade;
import org.oa.tp.data.*;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

public class Main extends Application {
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("Authors");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade9 = new DaoFacade();
        Author author = new Author(1, "Petr", "Gerebzov", 32);
        Author author1 = new Author(2, "Vyasheslav", "Fiberistic", 25);
        Author author2 = new Author(3, "Pavel", "Ambaricin", 15);


        List<Author> authors = new ArrayList<>();
        authors.add(author);
        authors.add(author1);
        authors.add(author2);
        daoFacade9.getAuthorDao().addAll(authors);
        System.out.println("______________________________________________________________________________________________");
        List<Author> authorList = daoFacade9.getAuthorDao().loadAll();
        for (Author author3 : authorList) {
            System.out.println("Authors " + author3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Customers");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade0 = new DaoFacade();
        Customer customer = new Customer(1, "Petr", 20, "pushkinskaya", 3);
        Customer customer1 = new Customer(2, "Vyasheslav", 2, "Lerkosnd", 2);
        Customer customer2 = new Customer(3, "Pavel", 33, "Gagarina", 1);


        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        daoFacade0.getCustomerDao().addAll(customers);
        System.out.println("______________________________________________________________________________________________");
        List<Customer> customerList = daoFacade0.getCustomerDao().loadAll();
        for (Customer customer3 : customerList) {
            System.out.println("Customers " + customer3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Cats");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade4 = new DaoFacade();
        Cat cat = new Cat(1, "persic", true);
        Cat cat1 = new Cat(2, "dlinnochvost", true);
        Cat cat2 = new Cat(3, "ushastik", false);


        List<Cat> cats = new ArrayList<>();
        cats.add(cat);
        cats.add(cat1);
        cats.add(cat2);
        daoFacade4.getCatDao().addAll(cats);
        System.out.println("______________________________________________________________________________________________");
        List<Cat> catList = daoFacade4.getCatDao().loadAll();
        for (Cat cat3 : catList) {
            System.out.println("Cats " + cat3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Cars");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade5 = new DaoFacade();
        Car car = new Car(1, "bmw");
        Car car1 = new Car(2, "porsche");
        Car car2 = new Car(3, "mitsubischi");


        List<Car> cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        daoFacade5.getCarDao().addAll(cars);
        System.out.println("______________________________________________________________________________________________");
        List<Car> carList = daoFacade5.getCarDao().loadAll();
        for (Car car3 : carList) {
            System.out.println("Cars " + car3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Genres");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade7 = new DaoFacade();
        Genre genre = new Genre(1, "pop");
        Genre genre1 = new Genre(2, "rock");
        Genre genre2 = new Genre(3, "rap");


        List<Genre> genres = new ArrayList<>();
        genres.add(genre);
        genres.add(genre2);
        genres.add(genre1);
        daoFacade7.getGenreDao().addAll(genres);
        System.out.println("______________________________________________________________________________________________");
        List<Genre> genreList = daoFacade7.getGenreDao().loadAll();
        for (Genre genre3 : genreList) {
            System.out.println("Genres  " + genre3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Producers");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade6 = new DaoFacade();
        Producer producer = new Producer(1, "Petr", "Ivanov", car.getId(), cat.getId());
        Producer producer1 = new Producer(2, "Valeriy", "Guseev", car1.getId(), cat1.getId());
        Producer producer2 = new Producer(3, "Evgeniy", "Rost", car2.getId(), cat2.getId());


        List<Producer> producers = new ArrayList<>();
        producers.add(producer);
        producers.add(producer1);
        producers.add(producer2);
        daoFacade6.getProducerDao().addAll(producers);
        System.out.println("______________________________________________________________________________________________");
        List<Producer> producers3 = daoFacade6.getProducerDao().loadAll();
        for (Producer producer3 : producers3) {
            System.out.println("Producers " + producer3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


        System.out.println("Albums");
        System.out.println("");
        System.out.println("");


        DaoFacade daoFacade = new DaoFacade();


        Album item = new Album(0, 1999, "TTT", producer.getId(), "usdfiusdf", "dhgdfg");
        Album item1 = new Album(2, 2000, "hffhf", producer1.getId(), "sjhk", "shdf");
        Album item2 = new Album(3, 2005, "reyer", producer.getId(), "jshdf", "jskdfh");
        Album item3 = new Album(4, 20003, "sdfsfd", producer2.getId(), "hsdhsf", "jsdhf");
        Album item4 = new Album(5, 34994, "sfdjsjfdjj", producer2.getId(), "skjhdf", "usd");

        List<Album> albums = new ArrayList<>();
        albums.add(item);
        albums.add(item1);
        albums.add(item2);
        albums.add(item3);
        albums.add(item4);
        for (Album album : albums) {
            System.out.println("Loading objects " + album);
        }
        daoFacade.getAlbumDao().addAll(albums);

        System.out.println("______________________________________________________________________________________________");
        Album album1 = daoFacade.getAlbumDao().findById(1);
        System.out.println("found by Id " + album1);

        System.out.println("______________________________________________________________________________________________");
        Album changed = new Album(3, 2324, "fee", producer.getId(), "shdfhsf", "shfjsfh");
        System.out.println("going to change " + changed);
        changed.setName("New name");
        changed.setYear(3400);
        System.out.println(" changed " + changed);
        daoFacade.getAlbumDao().update(changed);
        System.out.println("______________________________________________________________________________________________");
        List<Album> list = daoFacade.getAlbumDao().loadAll();
        for (Album album : list) {
            System.out.println("Album New " + album);

        }

        daoFacade.getAlbumDao().saveAll();


        System.out.println("Orders");
        System.out.println("");
        System.out.println("");

        DaoFacade daoFacade10 = new DaoFacade();
        int year = 2014;
        int month = 10;
        int day = 31;

        Order order = new Order(1, new Date(2009, 12, 11), 2, 23, 1);
        Order order1 = new Order(2, new Date(2012, 12, 10), 4, 23, 1);
        Order order2 = new Order(3, new Date(2012, 20, 12), 2, 23, 1);


        List<Order> orders = new ArrayList<>();
        orders.add(order);
        orders.add(order1);
        orders.add(order2);
        daoFacade10.getOrderDao().addAll(orders);
        System.out.println("______________________________________________________________________________________________");
        List<Order> orderList = daoFacade10.getOrderDao().loadAll();
        for (Order order3 : orderList) {
            System.out.println("Authors " + order3);

        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;

        Launcher.showMainWindow();

        primaryStage.show();

    }
}
