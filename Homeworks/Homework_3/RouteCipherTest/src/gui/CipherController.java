package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CipherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text captiontxt;

    @FXML
    private Button decryptBtn;

    @FXML
    private TextArea decryptTxt;

    @FXML
    private Button encryptBtn;

    @FXML
    private TextArea encrypttxt;

    @FXML
    private Button endBtn;

    @FXML
    private TextField keyInput;

    @FXML
    private Label keylbl;

    @FXML
    void decryptOnAction(ActionEvent event) {

    }

    @FXML
    void encryptOnAction(ActionEvent event) {

    }

    @FXML
    void endOnAction(ActionEvent event) {

    }

    @FXML
    void keyOnAction(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert captiontxt != null : "fx:id=\"captiontxt\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert decryptBtn != null : "fx:id=\"decryptBtn\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert decryptTxt != null : "fx:id=\"decryptTxt\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert encryptBtn != null : "fx:id=\"encryptBtn\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert encrypttxt != null : "fx:id=\"encrypttxt\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert endBtn != null : "fx:id=\"endBtn\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert keyInput != null : "fx:id=\"keyInput\" was not injected: check your FXML file 'view-cipher.fxml'.";
        assert keylbl != null : "fx:id=\"keylbl\" was not injected: check your FXML file 'view-cipher.fxml'.";

    }

}

