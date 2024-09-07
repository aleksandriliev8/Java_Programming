package Shape;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Geometry extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 300, 250);


        double width = scene.getWidth();
        double height = scene.getHeight();
        double centerX=width/2;
        double centerY=height/2;
        double radius = Math.min(width,height)/3;
        Circle circle = new Circle(centerX,centerY,radius);
        circle.setFill(null);
        circle.setStroke(Color.RED);
        group.getChildren().add(circle);

        double lineX=getAndValidateLineX(width);
        Line line = new Line(lineX,0,lineX,height);
        line.setStroke(Color.BLUE);
        group.getChildren().add(line);


        double chSquared = radius * radius - (centerX-lineX)*(centerX-lineX);

        if (chSquared>= 0) {
            double intersectionOneY=centerY+Math.sqrt(chSquared);
            drawIntersectionPoints(group,lineX,intersectionOneY);
            if (chSquared>0) {
                double intersectionTwoY = centerY-Math.sqrt(chSquared);
                drawIntersectionPoints(group,lineX,intersectionTwoY);
            }
        }
        else {
            showWarningDialog();
            Platform.exit();
        }


        // end TODO
        stage.setTitle("Geometry"); // Update Title as required
        stage.sizeToScene();
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(scene);
        stage.show();
    }

    private double getAndValidateLineX(double width) {
        double lineX;
        do {
        lineX=getLineX();

        if (lineX<0||lineX>width){
            showErrorDialog(width);
        }

        }while (lineX<0||lineX>width);

        return lineX;
    }

    private void showErrorDialog(double width) {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(String.format("X should be within bounds: [0:%.2f]",width));
        alert.showAndWait();
    }

    private double getLineX() {
        TextInputDialog dialog=new TextInputDialog();
        dialog.setTitle("Prompt");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter x:");
        return Double.parseDouble(dialog.showAndWait().get());
    }
    
    private void showWarningDialog(){
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText("No intersection points.");
        alert.showAndWait();
    }
    private void drawIntersectionPoints(Group group, double pointX, double pointY) {
        Circle circle=new Circle(pointX,pointY,10);
        Text text = new Text(pointX+10,pointY,String.format("(%.2f; %.2f)",pointX,pointY));
        group.getChildren().addAll(circle,text);
    }

}