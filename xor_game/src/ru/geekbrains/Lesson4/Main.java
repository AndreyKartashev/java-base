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

//import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int SIZE = 10;
    public static int DOTS_TO_WIN = 5;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int pointX = 0, pointY = 0;
    public static int stepAmount = 0;
    public static int gameCounter = 1;

    public static void main(String[] args) {
        do {
            System.out.println("Введите размер режим игры:");
            System.out.println("Размер игрового поля: 1 - 3x3, 2 - 5x5, 3 - 10x10");
            int gameSize = sc.nextInt();
            switch (gameSize) {
                case 1:{
                  SIZE = 3;
                  DOTS_TO_WIN = 3;
                }
                case 2:{
                    SIZE = 5;
                    DOTS_TO_WIN = 4;
                }
                case 3:{
                    SIZE = 10;
                    DOTS_TO_WIN = 5;
                }
            }

            initMap();
            printMap();

            while (true) {
                humanTurn();
                stepAmount += 1;

                printMap();
                if (stepAmount >= DOTS_TO_WIN) {
                    if (checkWin(DOT_X)) {
                        System.out.println("Победил человек");
                        break;
                    }
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
                stepAmount += 1;
                printMap();
                if (stepAmount >= DOTS_TO_WIN) {
                    if (checkWin(DOT_O)) {
                        System.out.println("Победил Искуственный Интеллект");
                        break;
                    }
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


    public static boolean checkWin(char symb) {
        int amount = 0;
        // 1 - по всем столбцам
        for (int i = 0; i< SIZE; i++) {
            // если DOTS_TO_WIN в ряд по вертикали
            amount = 0;
            int k = 0;
            while (k < SIZE) {
                if (map[i][k] == symb) {
                    amount += 1;
                    if (amount == DOTS_TO_WIN) return true;
                } else {
                    if (amount>0) return false;
                }
                k++;
            }
        }
        // 2 - по всем строкам, ecли есть DOTS_TO_WIN в ряд по горизонтали
        for (int j = 0; j < SIZE; j++) {
                amount = 0;
                int k = 0;
                while (k < SIZE) {
                    if (map[k][j] == symb) {
                        amount += 1;
                        if (amount == DOTS_TO_WIN) return true;
                    } else {
                        if (amount>0) return false;
                    }
                    k++;
                }
        }
        /*
        for j := 1 to N-1 do // перебор по "диагоналям"
            for i := 0 to N-1-j do begin// идем вдоль двух симметричных "диагоналей"
        a[j+i,i]... // вниз от диагонали "верх-лево -- низ-право"
        a[i,j+i]... // вверх от диагонали "верх-лево -- низ-право"
        a[j+i,N-1-i]... // вниз от диагонали "верх-право -- низ-лево"
        a[i,N-1-i+j]... // вверх от диагонали "верх-право -- низ-лево"
        end;
        + 2 "настоящие диагонали"
         */
/*
        // 3 - по всем диагоналям, если есть DOTS_TO_WIN в ряд по диагонали:  диагонали - слева направо - вниз
        for (int j = 1; j <= SIZE-1; j++) {
            for (int i = 0; i <= SIZE-1-j; i++) {
                amount = 0; //
                int k = 0;
                while (k <= SIZE - 1 - j) {
                    if (map[k][k] == symb) {
                        amount += 1;
                        if (amount == DOTS_TO_WIN) return true;
                    } else {
                        if (amount > 0) return false;
                    }
                    k++;
                }
            }
        }
        // 4 - по всем диагоналям, если есть DOTS_TO_WIN в ряд по диагонали: слева направо вверх
        for (int i = SIZE-1; i >= 0; i--) {
                // или DOTS_TO_WIN в ряд по диагонали:  справа налево - вверх
                amount = 0;
                int k = 0;
                while (k < SIZE) {
                    if (map[SIZE-k-1][k] == symb) {
                        amount = amount + 1;
                        if (amount == DOTS_TO_WIN) return true;
                    } else {
                        if (amount>0) return false;
                    }
                    k++;
                }
        }


 */
        return false;
    }

    public static void aiTurn() {
        int x = 0, y = 0;
        do {
            //humanRows(DOT_X); // процедура AI при ходе компьютера
            //x = pointX;
            //y = pointY;
            //if (x == -1 || y == -1 || stepAmount < 3) {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            //}
        } while (!isCellValid(x, y));

        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[x][y] = DOT_O;
    }

    /* Задача 4: AI - закрывать ходы человека.
           1. Вычисление сколько max в ряд у человека (если несколько - надо закрывать любую (первую)
           2. Координаты начальной точки  и конечной - у ряда, который надо закрывать.
           2.  признак - 1:4, ряд
                1 - по вертикали,
                2 - по горизонтали,
                3 - по диагонали слева направо сверху вниз,
                4 - по диагонали справо налево снизу вверх.

           Метод humanRows возвращает параметры:
                  количество иксов в ряд: maxRow,
                  координаты x и y начала и конца: (x1, y1), (x2, y2),
                  признак какой ряд 1:4.
           Далее - вычисляются кооридинаты (x и y) хода компьютера searchPoint (x, y).
               Или близко к началу ряда или к концу ряда - на выбор (считая слева).
    */

    public static void humanRows(char symb) {
        int amount, maxAmount = 0;
        int signRow = 0;

        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        int k;

        // 1 - по всем стобцам, проверка ряда по вертикали.
        for (int i = 0; i < SIZE; i++) {
            amount = 0;
            k = 0;
            while (k < SIZE) {
                if (map[i][k] == symb) {
                    amount = amount + 1;
                    if (amount > maxAmount) {
                        maxAmount = amount;
                        signRow = 1;
                        if (amount == 1) {
                           x1 = i;
                           y1 = k;
                           x2 = i;
                           y2 = k;
                        } else {
                            x2 = i;
                            y2 = k;
                        }
                    }
                }
                k++;
            }
        }
        // 2 - по всем строкам, проверка ряда по горизонтали.
        for (int j = 0; j < SIZE; j++) {
            amount = 0;
            k = 0;
            while (k < SIZE) {
                if (map[k][j] == symb) {
                    amount = amount +1;
                    if (amount > maxAmount) {
                        maxAmount = amount;
                        signRow = 2;
                        if (amount == 1) {
                            x1 = j;
                            y1 = k;
                            x2 = j;
                            y2 = k;
                        } else {
                            x2 = j;
                            y2 = k;
                        }
                    }
                }
                k++;
            }
        }
        // 3 - по всем столбцам, проверка ряда по диагонали:  слева направо - вниз.
        for (int i = 0; i < SIZE; i++) {
            amount = 0;
            k = 0;
            while (k < SIZE) {
                if (map[k][k] == symb) {
                    amount = amount +1;
                    if (amount > maxAmount) {
                        maxAmount = amount;
                        signRow = 3;
                        if (amount == 1) {
                            x1 = y1 = x2 = y2 = k;
                        } else {
                            x2 = k;
                            y2 = k;
                        }
                    }
                }
                k++;
            }
        }
        // 4 - по всем столбцам, проверка ряда по диагонали: слева направо - вверх
        for (int i = SIZE-1; i >= 0; i--) {
            amount = 0;
            k = 0;
            while (k < SIZE) {
                if (map[k][k] == symb) {
                    amount = amount +1;
                    if (amount > maxAmount) {
                        maxAmount = amount;
                        signRow = 4;
                        if (amount == 1) {
                            x1 = x2 = y1 = y2 = k;
                        } else {
                            x2 = k;
                            y2 = k;
                        }
                    }
                }
                k++;
            }
        }
        System.out.println("Максимальная строка - " + maxAmount);

        if (maxAmount > 1) {
            searchPoint(x1, y1, x2, y2, signRow, 1); //ставим слева
            if (pointX == -1|| pointY == -1)
               searchPoint(x1, y1, x2, y2, signRow, 2); //ставим справа
        }
    }

    public static void searchPoint(int x1, int y1, int x2, int y2, int signRow, int reg) {
        //reg равен: 1 - ставить слева от линии или сверху, 2 - ставить справа от линии или снизу.
        switch (signRow) {
            case 1: { // вертикальная линия
                pointY = y1;
                if (reg == 1) {
                    if (x1 > 0) {
                        pointX = x1 - 1;
                    } else {
                        pointX = -1;
                    }
                } else {
                    if (x2 < SIZE - 1) {
                        pointX = x2 + 1;
                    } else {
                        pointX = -1;
                    }
                }
            }
            case 2: { // горизонтальная линия
                pointX = x1;
                if (reg == 1) {
                    if (y1 > 0) {
                        pointY = y1 - 1;
                    } else {
                        pointY = -1;
                    }
                } else {
                    if (y2 < SIZE - 1) {
                        pointY = y2 + 1;
                    } else {
                        pointY = -1;
                    }
                }
            }
            case 3: { // диагональ слева направо вниз
                if (reg == 1) {
                    if (x1 > 0) {
                        pointX = x1 - 1;
                    } else {
                        pointX = -1;
                    }
                    if (y1 > 0) {
                        pointY = y1 - 1;
                    } else {
                        pointY = -1;
                    }
                } else {
                    if (x2 < SIZE - 1) {
                        pointX = x2 + 1;
                    } else {
                        pointX = -1;
                    }
                    if (y2 < SIZE - 1) {
                        pointY = y2 + 1;
                    } else {
                        pointY = -1;
                    }
                }
            }
        /*  case 4: { // диагональ слева направо вверх.
                 if (reg == 1) {
                    if (x1 < SIZE - 1) {
                        pointX = x1 + 1;
                    } else {
                        pointX = -1;
                    }
                    if (y1 > 0) {
                        pointY = y1 - 1;
                    } else {
                        pointY = -1;
                    }
                 }
                 else {
                     if (x2 > 0) {
                         pointX = x2 - 1;
                     } else {
                         pointX = -1;
                     }
                     if (y2 < SIZE - 1) {
                         pointY = y2 + 1;
                     } else {
                         pointY = -1;
                     }
                 }
            }
            */

        }
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[x][y] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

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