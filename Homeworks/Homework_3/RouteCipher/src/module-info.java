module RouteCipher {
    requires javafx.controls;
    requires javafx.fxml;
    opens RouteCipher to javafx.fxml;
    exports RouteCipher to javafx.graphics, RouteCipherTest;
}