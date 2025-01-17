package Task1a;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @java.lang.Override
    public void start(Stage stage) throws Exception {
        Parent root
                = FXMLLoader.load(getClass().getResource("view.fxml"));

        Scene scene = new Scene(root);

        // Set the Window title
        stage.setTitle("GCD");
        stage.sizeToScene();
        stage.resizableProperty().setValue(java.lang.Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(java.lang.String[] args) {
            launch(args);
    }
}
