package com.company.javaswinglekcja;

import com.company.javaswinglekcja.MyJFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame myFrame = new MyJFrame();
            }
        });

    }
}
