package me.study.alg;

import javax.swing.*;
import java.awt.*;

public class Sudoku {
    private final int N = 9;

    private void drawBoard() {
        JFrame frame = new JFrame("Sudoku");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);
        Container container = frame.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                JButton button = new JButton(String.valueOf(i * N + j));
                button.setSize(100, 100);
                c.fill = GridBagConstraints.HORIZONTAL;
                c.gridx = j;
                c.gridy = i;
                container.add(button, c);
            }
        }
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Sudoku().drawBoard();
    }
}
