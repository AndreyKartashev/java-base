package ru.geekbrains.Swing_Balls;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

    public class Main extends JFrame {

        final String TITLE_OF_PROGRAM = "Random balls";
        final int WINDOW_WIDTH = 650;
        final int WINDOW_HEIGHT = 650;

        public static void main(String[] args) {
            new Main();
        }

        public Main() {
            setTitle(TITLE_OF_PROGRAM);
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            Canvas canvas = new Canvas();
            canvas.setBackground(Color.white);
            canvas.setPreferredSize(
                    new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

            add(canvas);
            pack();
            setLocationRelativeTo(null);
            setResizable(false);
            setVisible(true);
        }

        class Canvas extends JPanel {
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                // рисуем окружности
            }
        }
    }