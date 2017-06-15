package AppFX.controller;

import AppFX.entity.Product;
import AppFX.entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by adm on 09.06.2017.
 */
public class MainShop  {

    ObservableList<Product> productData = FXCollections.observableArrayList();
    @FXML
    private TableView<Product> productTable;
    @FXML
    TableColumn <Product,String> nameColum;
    @FXML
    TableColumn <Product,String> descriptionColum;
    @FXML
    TableColumn <Product,String> typeColum;
    @FXML
    TableColumn <Product,Integer> priceColum;

    @FXML
    private void initialize() {
        initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        nameColum.setCellValueFactory(new PropertyValueFactory<Product,String>("name"));
        descriptionColum.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));
        typeColum.setCellValueFactory(new PropertyValueFactory<Product, String>("type"));
        priceColum.setCellValueFactory(new PropertyValueFactory<Product, Integer>("price"));

        // заполняем таблицу данными
        productTable.setItems(productData);
    }
    private void initData(){
        productData .add(new Product("Iphone 6", "-- ","phone", 300));
        productData .add(new Product("Iphone 5", "--", "phone", 150));
        productData .add(new Product("Samsung", "--", "phone",250));
        productData .add(new Product("Nokia 3110", "--", "phone", 100));
        productData .add(new Product("Китай б/у", "--", "noutbook", 200));
    }
    public void select(ActionEvent actionEvent) {



    }

    public void addProduct(ActionEvent actionEvent) {

    }

    public void quit(ActionEvent actionEvent) {

    }


}
