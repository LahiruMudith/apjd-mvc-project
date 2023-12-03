package lahiru.java.javafx.test.javafxtest.Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lahiru.java.javafx.test.javafxtest.Model.BookModel;
import lahiru.java.javafx.test.javafxtest.Tm.LoadAllBookTM;
import lahiru.java.javafx.test.javafxtest.To.Book;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoadController implements Initializable {
    @FXML
    private TableView<LoadAllBookTM> tblLoadAllTable;

    @FXML
    void Load(ActionEvent event) {

        ArrayList<Book> books = BookModel.loadAllBook();

        ArrayList<LoadAllBookTM> booksTms = new ArrayList<>();

        for(Book saveBook: books){
            booksTms.add(new LoadAllBookTM(saveBook.getName(), saveBook.getId(), saveBook.getIsbm(), saveBook.getQty(), saveBook.getPrice()));
        }

        tblLoadAllTable.setItems(FXCollections.observableArrayList(booksTms));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblLoadAllTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblLoadAllTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblLoadAllTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("isbm"));
        tblLoadAllTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("qty"));
        tblLoadAllTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Price"));

//        ArrayList<LoadAllBookTM> load = ;

//        tblLoadAllTable.setItems(FXCollections.observableArrayList(load));

    }
}
