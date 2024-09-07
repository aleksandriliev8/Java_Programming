package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApplication extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws Exception {
        javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("view-game.fxml"));

        javafx.scene.Scene scene = new javafx.scene.Scene(root);

        // Set the Window title
        stage.setTitle("");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
            launch(args);
    }
}
