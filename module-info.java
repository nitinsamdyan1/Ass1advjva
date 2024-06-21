module com.example.studentmanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.studentmanager.controllers to javafx.fxml;

    exports com.example.studentmanager;
}
