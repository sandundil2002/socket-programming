module lk.ijse {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;

    opens lk.ijse to javafx.fxml;
    opens lk.ijse.controller to javafx.fxml;

    exports lk.ijse;
    exports lk.ijse.controller;
}
