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

import java.io.IOException;
import java.sql.*;

public class UpdateController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtUpdateISBM;

    @FXML
    private TextField txtUpdateId;

    @FXML
    private TextField txtUpdateName;

    @FXML
    private TextField txtUpdatePrice;

    @FXML
    private TextField txtUpdateQTY;
    @FXML
    void BackHome(ActionEvent event) {
        try {

            //create stage
            Stage stage = (Stage) this.root.getScene().getWindow();

            //scene load
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/Home-Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setScene(scene);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    void Cancle(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void Search(ActionEvent event) {
        String id = txtUpdateId.getText();

        try {
            //load connector
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFxTest", "root", "1212");

            //create sql query
            PreparedStatement stm = connection.prepareStatement("select * from add_book where BOOK_ID=?");
            stm.setObject(1,id);

            ResultSet resultSet = stm.executeQuery();

            while (resultSet.next()){
                txtUpdateName.setText(resultSet.getString(1));
                txtUpdateISBM.setText(resultSet.getString(3));
                txtUpdateQTY.setText(resultSet.getString(4));
                txtUpdatePrice.setText(resultSet.getString(5));
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void Update(ActionEvent event) {
        try {
            //load connector
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFxTest", "root", "1212");

            //create sql query
            PreparedStatement stm = connection.prepareStatement("update add_book set NAME=?, ISBM=?, QTY=?, PRICE=? where BOOK_ID=?");
            stm.setObject(1,txtUpdateName.getText());
            stm.setObject(2,txtUpdateISBM.getText());
            stm.setObject(3,txtUpdateQTY.getText());
            stm.setObject(4,txtUpdatePrice.getText());
            stm.setObject(5,txtUpdateId.getText());

            int executed = stm.executeUpdate();

            if (executed>0){
                System.out.println(executed);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("UPDATE SUCCESSFULLY !");
                alert.show();
                clear();
            }else {
                System.out.println(executed);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("UPDATE FAILED !");
                alert.show();
                clear();
            }




        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clear() {
        txtUpdateId.setText("");
        txtUpdateName.setText("");
        txtUpdateISBM.setText("");
        txtUpdateQTY.setText("");
        txtUpdatePrice.setText("");
    }
}

