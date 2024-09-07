package figures;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawLines extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){

        Group group = new Group();
        int sceneX = 550;
        int sceneY = 500;
        Scene scene = new Scene(group, sceneX, sceneY);
        int spaceBetweenLinesX = sceneX/20;
        int spaceBetweenLinesY = sceneY/20;

        for (int i = 0, j = 0; i <= sceneX; i += spaceBetweenLinesX, j+= spaceBetweenLinesY)
        {
            //Printing he plane made from lines in down left corner
            Line downLeftFigure = new Line(0, j, i, sceneY);
            downLeftFigure.setStroke(Color.DARKORANGE);
            group.getChildren().add(downLeftFigure);

            //Printing he plane made from lines in up left corner
            Line upLeftFigure = new Line(0, sceneY - j, i, 0);
            upLeftFigure.setStroke(Color.DARKORANGE);
            group.getChildren().add(upLeftFigure);

            //Printing he plane made from lines in up right corner
            Line upRightFigure = new Line(sceneX, j, i, 0);
            upRightFigure.setStroke(Color.DARKORANGE);
            group.getChildren().add(upRightFigure);

            //Printing the plane made from lines in down right corner
            Line downRightFigure = new Line(sceneX, j, sceneX - i, sceneY);
            downRightFigure.setStroke(Color.ORANGE);
            group.getChildren().add(downRightFigure);
        }

        stage.setTitle("Canvas demo");
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }
}
