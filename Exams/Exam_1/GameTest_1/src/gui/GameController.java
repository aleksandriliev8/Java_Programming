package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class GameController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDraw;

    @FXML
    private Button btnEnd;

    @FXML
    private Button btnKing;

    @FXML
    private TextArea btnPrint;

    @FXML
    private Button btnQueenKing;

    @FXML
    private TextArea btnResult;

    @FXML
    void btnDrawOnClick(ActionEvent event) {

    }

    @FXML
    void btnEndOnClick(ActionEvent event) {

    }

    @FXML
    void btnKingOnClick(ActionEvent event) {

    }

    @FXML
    void btnPrintOnClick(MouseEvent event) {

    }

    @FXML
    void btnQueenKingOnClick(ActionEvent event) {

    }

    @FXML
    void btnResultOnClick(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert btnDraw != null : "fx:id=\"btnDraw\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnEnd != null : "fx:id=\"btnEnd\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnKing != null : "fx:id=\"btnKing\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnPrint != null : "fx:id=\"btnPrint\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnQueenKing != null : "fx:id=\"btnQueenKing\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnResult != null : "fx:id=\"btnResult\" was not injected: check your FXML file 'view-game.fxml'.";

    }

}

