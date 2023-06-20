module com.example.summativeoop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.summativeoop to javafx.fxml;
    exports com.example.summativeoop;
    exports com.example.summativeoop.controllers.Admin;
    opens com.example.summativeoop.controllers.Admin to javafx.fxml;
    exports com.example.summativeoop.controllers.Admin.models;
    opens com.example.summativeoop.controllers.Admin.models to javafx.fxml;
    exports com.example.summativeoop.controllers.Employee;
    opens com.example.summativeoop.controllers.Employee to javafx.fxml;
    exports com.example.summativeoop.controllers.Employee.models;
    opens com.example.summativeoop.controllers.Employee.models to javafx.fxml;
}