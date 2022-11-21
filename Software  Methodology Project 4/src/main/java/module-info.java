module com.example.project_4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires org.testng;


    opens com.example.project_4 to javafx.fxml;
    exports com.example.project_4;
    exports org.junit.jupiter.api;
    opens org.junit.jupiter.api to javafx.fxml;
}