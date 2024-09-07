package figures;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
// Abbreviaton key:       fx-drawing-main
// Template description: JavaFX App class for drawing
// Variables: CLASS_NAME must be assigned clipboard() expression
// 1. Create a Java class
// 2. Copy the class name in the Clipboard (^C)
// 3, Overwrite all  the class contents by running this Live template
// 4. Right-click the class name (should be the same as in the originally created class)
// 5. Select Show Content actions and execute Set package name to ...<your package name>

public class DrawLines extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 600, 600);

        // TODO  Type code for Java FX drawing objects

        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;

        for (int i = 0; i < 11; i++) {
            Circle circle = new Circle(centerX, centerY ,20 + (i * 20));
            circle.setFill(null);
            circle.setStroke(Color.BLACK);

            group.getChildren().add(circle);
        }

        double bigDiameter = 11 * 20;
        Line vertical = new Line(centerX, centerY + bigDiameter , centerX ,centerY - bigDiameter);
        vertical.setStroke(Color.RED);
        group.getChildren().add(vertical);

        Line horizontal = new Line(centerX - bigDiameter, centerY, centerX + bigDiameter,centerY);
        horizontal.setStroke(Color.RED);
        group.getChildren().add(horizontal);

        // end TODO
        stage.setTitle("Drawing scene"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
