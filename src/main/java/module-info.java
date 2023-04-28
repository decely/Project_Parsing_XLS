module com.example.parsing_xls {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires java.security.jgss;
    requires org.apache.poi.ooxml;
    requires java.sql;


    opens com.example.parsing_xls to javafx.fxml;
    exports com.example.parsing_xls;
}