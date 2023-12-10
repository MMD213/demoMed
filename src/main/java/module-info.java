module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires itextpdf;
    requires jdk.jpackage;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.Base;
    opens com.example.demo.Base to javafx.fxml;
}