module lahiru.java.javafx.test.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens lahiru.java.javafx.test.javafxtest to javafx.fxml;
    exports lahiru.java.javafx.test.javafxtest;
    exports lahiru.java.javafx.test.javafxtest.Controllers;
    opens lahiru.java.javafx.test.javafxtest.Controllers to javafx.fxml;
    exports lahiru.java.javafx.test.javafxtest.Tm;
    opens lahiru.java.javafx.test.javafxtest.Tm to javafx.fxml;
}