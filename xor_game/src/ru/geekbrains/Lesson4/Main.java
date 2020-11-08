/*
   1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
   2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например,
      с использованием циклов.
   3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5
      и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
      возможных ситуаций;
   4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/

package ru.geekbrains.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE;
    public static int DOTS_TO_WIN;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static int gameCounter;
    public static int gameSize;

// для AI (4-го задания) - для ответного хода компьютера.
    public static int pointX = 0, pointY = 0;
    public static int maxAmount = 0, signRow = 0;

// Главный метод игры
    public static void main(String[] args) {
        System.out.println("\nНачнем игру крестики-нолики!\n");
        do {
            System.out.println("Введите режим игры 1, 2 или 3.");
            System.out.println("Размер игрового поля: ");
            System.out.println("1  3x3, 3 в ряд, ");
            System.out.println("2  5x5, 4 в ряд, ");
            System.out.println("3  10x10, 5 в ряд.");
            gameSize = sc.nextInt();
            if (gameSize == 1) {
                SIZE = 3;
                DOTS_TO_WIN = 3;
            }
            if (gameSize == 2) {
                SIZE = 5;
                DOTS_TO_WIN = 4;
            }
            if (gameSize == 3) {
                SIZE = 10;
                DOTS_TO_WIN = 5;
            }
            if (gameSize != 1 && gameSize != 2 && gameSize != 3) {
                SIZE = 3;
                DOTS_TO_WIN = 3;
            }

            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Победил Искуственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Игра закончена");
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
            gameCounter = sc.nextInt();
        } while (gameCounter != 0);
    }
// Проверка победы
    public static boolean checkWin(char symb) {
        boolean p1 = false, p2 = false, p3 = false, p4 = false;
        boolean p5 = false, p6 = false, p7 = false, p8 = false;

        p1 = TestWin.testHorisontal(symb);         //1
        p2 = TestWin.testVertical(symb);           //2
        p3 = TestWin.testMainLeftDiagonal(symb);   //3
        p4 = TestWin.testMainRightDiagonal(symb);  //4
        p5 = TestWin.testLeftUpDiagonals(symb);    //5
        p6 = TestWin.testLeftDownDiagonals(symb);  //6
        p7 = TestWin.testRightUpDiagonals(symb);   //7
        p8 = TestWin.testRightDownDiagonals(symb); //8

        if (p1 || p2 || p3 || p4 || p5 || p6 || p7 || p8)
            return true;
        return false;
    }

// Ход компьютера.
    public static void aiTurn() {
        do {
         // процедура AI при ходе компьютера
         // Из GameAI.class

// Заглушка вместо 4 - го задания. Немного не отладил, надоело :-).
            pointX = rand.nextInt(SIZE);
            pointY = rand.nextInt(SIZE);
            //   GameAI.humanRows(DOT_X);
            //   System.out.println("Max amount X = " + maxAmount);
        } while (!isCellValid(pointX, pointY));

        System.out.println("Компьютер походил в точку " + (pointX + 1) + " " + (pointY + 1));
        map[pointX][pointY] = DOT_O;
    }
// Проверка на полноту таблицы. Если полная - ничья
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
// Ход человека
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[x][y] = DOT_X;
    }
// Проверка на вхождение символа в таблицу
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }
// Вначале игры - начальная таблица
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
// Вывод таблицы SIZE x SIZE
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}