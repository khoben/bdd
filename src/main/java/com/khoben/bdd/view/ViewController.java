package com.khoben.bdd.view;

import javafx.fxml.FXML;

import javax.swing.*;
import java.awt.*;

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

    @FXML
    public void onMakeTurnButtonClick(){

    }

    public static void makeMessageBox(Component parent, String message, String title, int type){
        JOptionPane.showMessageDialog(parent,message,title, type);
    }
}
