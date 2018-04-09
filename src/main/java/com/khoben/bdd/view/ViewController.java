package com.khoben.bdd.view;

import com.khoben.bdd.model.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javax.swing.*;

import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.*;
import java.util.Optional;

public class ViewController {

    @FXML
    Button makeTurn;
    @FXML
    TextField selectedLetter;
    @FXML
    Label avLetters;
    @FXML
    Label curChoiceCost;
    @FXML
    TextArea descrWord;
    @FXML
    Label wordMask;
    @FXML
    Label totalScore;

    private Game game;

    @FXML
    public void initialize() {
        selectedLetter.addEventFilter(KeyEvent.KEY_TYPED, validation(1));
        game = new Game();
        game.loadGame();
        update();
    }

    public void update(){
        selectedLetter.setText("");
        wordMask.setText(game.getCurWord().getMask());
        if (!wordMask.getText().contains("*"))
            makeConfirmBox();
        descrWord.setText(game.getCurWord().getDescr());
        totalScore.setText("Очков набрано: " + game.getTotalScore());
        curChoiceCost.setText(game.getCurStepCost() + " очков на барабане буква:");
        avLetters.setText(game.getAvLettersPrintable());
    }

    @FXML
    public void onMakeTurnButtonClick() {
        String curLetter = selectedLetter.getText();
        if (curLetter == "")
            return;
        game.makeTurn(curLetter);
        update();
    }


    public EventHandler<KeyEvent> validation(final Integer max_Lengh) {
        return e -> {
            TextField txt_TextField = (TextField) e.getSource();

            if (txt_TextField.getText().length() >= max_Lengh) {
                e.consume();
            }
            if (e.getCharacter().toLowerCase().matches("[а-я.]")) {
                if (txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                    e.consume();
                } else if (txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                    e.consume();
                }
            } else {
                e.consume();
            }
        };
    }

    public static void makeMessageBox(String message, String title, int type) {
        JOptionPane.showMessageDialog(null, message, title, type);
    }

    public void makeConfirmBox(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Ура!");
        alert.setHeaderText("Поздравляем!");
        alert.setContentText("Вы отгадали слово. Мб еще одно?");

        ButtonType buttonTypeOne = new ButtonType("Да");
        ButtonType buttonTypeCancel = new ButtonType("Нет", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonTypeOne){
            game.loadGame();
            update();
        }else{
            System.exit(0);
        }
    }
}
