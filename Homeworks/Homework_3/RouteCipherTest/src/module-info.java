module RouteCipherTest {
    requires javafx.fxml;
    requires javafx.controls;
    requires RouteCipher;

    opens gui to javafx.fxml;
    exports gui;
}