package com.khoben.bdd.view;

import javax.swing.*;
import java.awt.*;

public class ViewController {

    public static void makeMessageBox(Component parent, String message, String title, int type){
        JOptionPane.showMessageDialog(parent,message,title, type);
    }
}
