package Task1a;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtGcd;

    @FXML
    private Button btnGCD;

    @FXML
    private Button btnQuit;

    @FXML
    private Label lbla;

    @FXML
    private Label lblb;

    @FXML
    private GridPane lblgcd;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnGCDOnAction(ActionEvent event) {
        int a = Integer.parseInt(txtA.getText());
        int b = Integer.parseInt(txtB.getText());
        txtGcd.setText(Integer.toString(computeGcd(a,b)));
    }

    @FXML
    void initialize() {
        assert btnGCD != null : "fx:id=\"btnGCD\" was not injected: check your FXML file 'view.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'view.fxml'.";
        assert lbla != null : "fx:id=\"lbla\" was not injected: check your FXML file 'view.fxml'.";
        assert lblb != null : "fx:id=\"lblb\" was not injected: check your FXML file 'view.fxml'.";
        assert lblgcd != null : "fx:id=\"lblgcd\" was not injected: check your FXML file 'view.fxml'.";
        assert txtA != null : "fx:id=\"txtA\" was not injected: check your FXML file 'view.fxml'.";
        assert txtB != null : "fx:id=\"txtB\" was not injected: check your FXML file 'view.fxml'.";
        assert txtGcd != null : "fx:id=\"txtGcd\" was not injected: check your FXML file 'view.fxml'.";

    }

    private int computeGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return computeGcd(b, a % b);
    }

}

