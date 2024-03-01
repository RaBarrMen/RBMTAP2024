module com.example.tap2024 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tap2024 to javafx.fxml;
    exports com.example.tap2024;

    //clases de las dependencias
    requires java.sql;
    requires mysql.connector.j;
}