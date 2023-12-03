package lahiru.java.javafx.test.javafxtest.Model;

import javafx.scene.control.Alert;
import lahiru.java.javafx.test.javafxtest.Tm.LoadAllBookTM;
import lahiru.java.javafx.test.javafxtest.To.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookModel {
    public static boolean saveBook(Book book){
        try {
            //load connector
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFxTest", "root", "1212");

            //create sql query
            PreparedStatement stm = connection.prepareStatement("insert into add_Book values(?,?,?,?,?)");
            stm.setObject(1,book.getName());
            stm.setObject(2,book.getId());
            stm.setObject(3,book.getIsbm());
            stm.setObject(4,book.getQty());
            stm.setObject(5,book.getPrice());

            int result = stm.executeUpdate();

            if (result>0){
                return true;
            }else {
                return false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean deleteBook(){
        return true;
    }
    public static boolean updateBook(){
        return true;
    }
    public static ArrayList<Book> loadAllBook(){
        try {
            //load connector
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection with database
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaFxTest", "root", "1212");

            //create sql query
            PreparedStatement stm = connection.prepareStatement("select * from add_book");

            ResultSet resultSet = stm.executeQuery();

            ArrayList<Book> list = new ArrayList<>();

            while (resultSet.next()){
                Book tm = new Book();

                tm.setName(resultSet.getString(1));
                tm.setId(resultSet.getString(2));
                tm.setIsbm(resultSet.getString(3));
                tm.setQty(resultSet.getInt(4));
                tm.setPrice(resultSet.getDouble(5));

                list.add(tm);
            }

            return list;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
