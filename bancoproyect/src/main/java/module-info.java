module society {
    requires javafx.controls;
    requires javafx.fxml;

    opens society to javafx.fxml;
    opens society.controller to javafx.fxml;
    opens society.model to javafx.fxml;
    
    exports society;
    exports society.controller;
    exports society.model;
}
