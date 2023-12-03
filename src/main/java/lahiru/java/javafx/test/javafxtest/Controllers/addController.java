package lahiru.java.javafx.test.javafxtest.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lahiru.java.javafx.test.javafxtest.HelloApplication;
import lahiru.java.javafx.test.javafxtest.Model.BookModel;
import lahiru.java.javafx.test.javafxtest.To.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class addController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtIsbm;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtQty;
    @FXML
    void BackHome(ActionEvent event) {
        try {

            //create stage
            Stage stage = (Stage) this.root.getScene().getWindow();

            //scene load
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Home-menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void Add(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String isbm = txtIsbm.getText();
        int qty = Integer.parseInt(txtQty.getText());
        double price = Double.parseDouble(txtPrice.getText());
        System.out.println("Name :" +name+ " | " + "ID :" +id+ " | " + "Price:" +price );

        boolean saveBook = BookModel.saveBook(new Book(name, id, isbm, qty, price));

        if (saveBook==true) {
            System.out.println("Added successfully !");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Added successfully");
            alert.show();
            clear();
        }else {
            System.out.println("Added Failed !");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Added Failed");
            alert.show();
            clear();
        }
    }

    @FXML
    void Cancle(ActionEvent event) {
        System.exit(0);
    }

    public void clear() {
        txtId.setText("");
        txtName.setText("");
        txtIsbm.setText("");
        txtQty.setText("");
        txtPrice.setText("");
    }
}


