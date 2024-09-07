package gui;

import java.net.URL;
import java.util.ResourceBundle;

import cards.StackOfCards;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GameController {
    private StackOfCards stOfCards;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnHasFiveQueen;

    @FXML
    private Button btnHasQueenAndKing;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnTakeCards;

    @FXML
    private TextArea txaCards;

    @FXML
    private TextArea txaResult;

    @FXML
    void btnHasFiveQueenOnClick(ActionEvent event) {
        txaResult.setText("");
        if(!btnTakeCards.isDisable()) {
            if (stOfCards.hasFiveQueen()) {
                txaResult.setText(String.format("%s\nизтеглената ръка има пет QUEEN", stOfCards.printCards()));
            } else {
                txaResult.setText(String.format("%s\nизтеглената ръка няма пет QUEEN", stOfCards.printCards()));
            }
        }
    }

    @FXML
    void btnHasQueenAndKingOnClick(ActionEvent event) {
        txaResult.setText("");
        if(!btnTakeCards.isDisable()) {
            if (stOfCards.hasQueenAndKing()) {
                txaResult.setText(String.format("%s\nВ изтеглената ръка има двойка QUEEN-KING", stOfCards.printCards()));
            } else {
                txaResult.setText(String.format("%s\nВ изтеглената ръка няма двойка QUEEN-KING", stOfCards.printCards()));
            }
        }
    }

    @FXML
    void btnQuitOnClick(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnTakeCardsOnClick(ActionEvent event) {
        txaCards.setText("");
        if (stOfCards.dealHand()) {
            txaCards.setText(stOfCards.printCards());
        } else {
            btnTakeCards.setDisable(true);

        }
    }

    @FXML
    void initialize() {
        assert btnHasFiveQueen != null : "fx:id=\"btnHasFiveQueen\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnHasQueenAndKing != null : "fx:id=\"btnHasQueenAndKing\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'view-game.fxml'.";
        assert btnTakeCards != null : "fx:id=\"btnTakeCards\" was not injected: check your FXML file 'view-game.fxml'.";
        assert txaCards != null : "fx:id=\"txaCards\" was not injected: check your FXML file 'view-game.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'view-game.fxml'.";
        stOfCards = new StackOfCards();
        stOfCards.make2packs();
    }


}

