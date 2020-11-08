package ru.geekbrains.Lesson4;

public class TestAI {
    public static int[] maxArray = new int[8]; // как вариант
    // 1 - По строкам
    public static boolean horisontal(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0, i = 0, j;
        while (i < Main.SIZE) {
            amount = 0;
            j = 0;
            while (j < Main.SIZE) {
                if (Main.map[i][j] == symb) {
                    amount += 1;
                    if (amount > Main.maxAmount) {
                        Main.maxAmount = amount;
                        Main.signRow = 1;
                        if (amount == 1) {
                            x1 = x2 = i;
                            y1 = y2 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                        return true;
                    }
                }
                j++;
            }
            i++;
        }
        return false;
    }
    // 2 - По столбцам
    public static boolean vertical(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0, i, j = 0;
        while (j < Main.SIZE) {
            amount = 0;
            i = 0;
            while (i < Main.SIZE) {
                if (Main.map[i][j] == symb) {
                    amount = amount + 1;
                    if (amount > Main.maxAmount) {
                        Main.maxAmount = amount;
                        Main.signRow = 2;
                        if (amount == 1) {
                            x1 = x2 = i;
                            y1 = y2 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                        return true;
                    }
                }
                i++;
            }
            j++;
        }
        return false;
    }

    // 3 - Главная диагональ
    public static boolean leftDiagonal(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0, i = 0;
        while (i < Main.SIZE) {
            // если Main.DOTS_TO_WIN в ряд по главной диагонали
            if (Main.map[i][i] == symb) {
                amount = amount + 1;
                if (amount > Main.maxAmount) {
                    Main.maxAmount = amount;
                    Main.signRow = 3;
                    if (amount == 1)
                        x1 = x2 = y1 = y2 = i;
                    else
                        x2 = y2 = i;
                  //  return true;
                }
            }
            i++;
        }
        return false;
    }

    // 4 - Побочная диагональ
    public static boolean rightDiagonal(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0, i = 0;
        while (i < Main.SIZE) {
            // если Main.DOTS_TO_WIN в ряд по главной диагонали
            if (Main.map[Main.SIZE - i - 1][i] == symb) {
                amount = amount + 1;
                if (amount > Main.maxAmount) {
                    Main.maxAmount = amount;
                    Main.signRow = 4;
                    if (amount == 1) {
                        x1 = x2 = Main.SIZE - i - 1;
                        y1 = y2 = i;
                    } else {
                        x2 = Main.SIZE - i - 1;
                        y2 = i;
                    }
                    return true;
                }
            }
            i++;
        }
        return false;
    }

    //5   Диагонали вверх от главной диагонали ("верх-лево -- низ-право")
    public static boolean leftUpDiagonals(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0;
        for (int j = 1; j < Main.SIZE; j++) {
            // перебор по "диагоналям"
            for (int i = 0; i < Main.SIZE - j; i++) {
                //идем вдоль двух симметричных "диагоналей"
                if (Main.map[i][j + i] == symb) {
                    amount = amount + 1;
                    if (amount > Main.maxAmount) {
                        Main.maxAmount = amount;
                        Main.signRow = 3;
                        if (amount == 1) {
                            x1 = x2 = i;
                            y1 = y2 = j + 1;
                        } else {
                            x2 = i;
                            y2 = j + 1;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 6  Диагонали вниз от главной диагонали ("верх-лево -- низ-право")
    public static boolean leftDownDiagonals(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0;
        for (int j = 1; j < Main.SIZE; j++) {
            for (int i = 0; i < Main.SIZE - j; i++) {
                if (Main.map[j + i][i] == symb) {
                    amount = amount + 1;
                    if (amount > Main.maxAmount) {
                        Main.maxAmount = amount;
                        Main.signRow = 3;
                        if (amount == 1) {
                            x1 = x2 = j + i;
                            y1 = y2 = i;
                        } else {
                            x2 = j + i;
                            y2 = i;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 7  Диагонали  вверх от побочной диагонали ("верх-право -- низ-лево")
    public static boolean rightUpDiagonals(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0;
        for (int j = 1; j < Main.SIZE; j++) {
            for (int i = 0; i < Main.SIZE - j; i++) {
                if (Main.map[i][Main.SIZE - i - j - 1] == symb) {
                    amount = amount + 1;
                    if (amount > Main.maxAmount) {
                        Main.maxAmount = amount;
                        Main.signRow = 4;
                        if (amount == 1) {
                            x1 = x2 = i;
                            y1 = y2 = Main.SIZE - j;
                        } else {
                            x2 = i;
                            y2 = Main.SIZE - j;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // 8  Диагонали  вниз от побочной диагонали ("верх-право -- низ-лево")
    public static boolean rightDownDiagonals(char symb, int x1, int y1, int x2, int y2) {
        int amount = 0;
        for (int j = 1; j < Main.SIZE; j++) {
            for (int i = 0; i < Main.SIZE - j; i++) {
                if (Main.map[j + i][Main.SIZE - 1 - i] == symb) {
                    amount = amount + 1;
                    if (amount > Main.maxAmount) {
                        Main.maxAmount = amount;
                        Main.signRow = 4;
                        if (amount == 1) {
                            x1 = x2 = j + i;
                            y1 = y2 = Main.SIZE - 1 - i;
                        } else {
                            x2 = j + i;
                            y2 = Main.SIZE - 1 - i;
                        }
                    }
                }
            }
        }
        return false;
    }
}