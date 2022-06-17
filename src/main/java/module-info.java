module fxapp.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens fxapp.calculator to javafx.fxml;
    exports fxapp.calculator;
}