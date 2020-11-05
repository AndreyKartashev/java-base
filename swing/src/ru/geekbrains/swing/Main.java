package ru.geekbrains.swing;

import javax.swing.*;

public class Main extends JFrame {

        public static void main(String[] args) {
            new Main(); // создаём объект-окно
        }

        Main() {
            setTitle("Hello, Swing!");  // заголовок окна
            setDefaultCloseOperation(EXIT_ON_CLOSE); // при закрытии
            setSize(500, 300); // размеры окна
            setLocationRelativeTo(null); // позиция на экране
            setVisible(true); // сделать видимым
        }



}
