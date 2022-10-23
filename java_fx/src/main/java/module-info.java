module java_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens java_fx.controllers to javafx.fxml;
    exports java_fx;
    exports java_fx.entities;
}
