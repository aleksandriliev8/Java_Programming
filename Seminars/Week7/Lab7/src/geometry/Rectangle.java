package geometry;

import javafx.scene.Group;

public class Rectangle {

    private Point uPont;

    private double width;

    private double height;

    public Rectangle(Point uPont, double width, double height) {
        this.uPont = uPont;
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        this(new Point(), 10, 10);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.uPont, rectangle.width, rectangle.height);
    }

    public Point getuPont() {
        return new Point(uPont);
    }

    public void setuPont(Point uPont) {
        if (uPont != null) {
            this.uPont = uPont;
        } else {
            this.uPont = new Point();
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            this.width = 10;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = 10;
        }
    }

    public void draw (Group pane) {
        javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(
                uPont.getCoords()[0], uPont.getCoords()[1], width, height
        );

        pane.getChildren().add(rectangle);
    }

    @Override
    public String toString() {
        return String.format("uPoint: %s, width: %.2f, height: %.2f", uPont, width, height);
    }
}
