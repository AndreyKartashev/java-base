package ru.geekbrains.Lesson4;

public class TestWin {
    // 1  По всем строкам
    public static boolean testHorisontal(char symb) {
        int amount, i, j;
        i = 0;
        while (i < MainApp.SIZE) {
            // если Main.DOTS_TO_WIN в ряд по горизонтальным рядам
            amount = 0;
            j = 0;
            while (j < MainApp.SIZE) {
                if (MainApp.map[i][j] == symb) {
                    amount += 1;
                    if (amount == MainApp.DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (MainApp.map[i][j] != symb) {
                    if (amount > 0) {
                        return false;
                    }
                }
                j++;
            }
            i++;
        }
        return false;
    }
    // 2  По всем cтолбцам
    public static boolean testVertical(char symb) {
        int amount, i, j;
        j = 0;
        while (j < MainApp.SIZE) {
            //ecли есть Main.DOTS_TO_WIN в ряд по вертикальным рядам
            amount = 0;
            i = 0;
            while (i < MainApp.SIZE) {
                if (MainApp.map[i][j] == symb) {
                    amount += 1;
                    if (amount == MainApp.DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (MainApp.map[i][j] != symb) {
                    if (amount > 0) {
                        return false;
                    }
                }
                i++;
            }
            j++;
        }
        return false;
    }
    // 3   Главная диагональ
    public static boolean testMainLeftDiagonal(char symb) {
        int amount = 0, i = 0;
        while (i < MainApp.SIZE) {
            // если Main.DOTS_TO_WIN в ряд по главной диагонали
            if (MainApp.map[i][i] == symb) {
                amount += 1;
                if (amount == MainApp.DOTS_TO_WIN) {
                    return true;
                }
            }
            if (MainApp.map[i][i] != symb) {
                if (amount > 0) {
                    return false;
                }
            }
            i++;
        }
        return false;
    }
    // 4   Побочная диагональ
    public static boolean testMainRightDiagonal(char symb) {
        int amount = 0, i = 0;
        while (i < MainApp.SIZE) {
            // если Main.DOTS_TO_WIN в ряд по побочной диагонали
            if (MainApp.map[MainApp.SIZE - i - 1][i] == symb) {
                amount += 1;
                if (amount == MainApp.DOTS_TO_WIN) {
                    return true;
                }
            }
            if (MainApp.map[MainApp.SIZE - i - 1][i] != symb) {
                if (amount > 0) {
                    return false;
                }
            }
            i++;
        }
        return false;
    }
    // 5   a[i,j+i]...  Диагонали вверх от диагонали "верх-лево -- низ-право"
    public static boolean testLeftUpDiagonals(char symb) {
        int amount = 0;
        for (int j = 1; j < MainApp.SIZE; j++) {
            // перебор по "диагоналям"
            for (int i = 0; i < MainApp.SIZE - j; i++) {
                //идем вдоль двух симметричных "диагоналей"
                if (MainApp.map[i][j + i] == symb) {
                    amount += 1;
                    if (amount == MainApp.DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (MainApp.map[i][j + i] != symb) {
                    if (amount > 0) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    // 6   a[j+i,i]...  Диагонали вниз от диагонали "верх-лево -- низ-право"
    public static boolean testLeftDownDiagonals(char symb) {
        int amount = 0;
        for (int j = 1; j < MainApp.SIZE; j++) {
            for (int i = 0; i < MainApp.SIZE - j; i++) {
                if (MainApp.map[j + i][i] == symb) {
                    amount += 1;
                    if (amount == MainApp.DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (MainApp.map[j + i][i] != symb) {
                    if (amount > 0) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
    // 7    a[i,N-1-i-j]... Диагонали  вверх от диагонали "верх-право -- низ-лево"
    public static boolean testRightUpDiagonals(char symb) {
        int amount = 0;
        for (int j = 1; j < MainApp.SIZE; j++) {
            for (int i = 0; i < MainApp.SIZE - j; i++) {
                if (MainApp.map[i][MainApp.SIZE - i - j - 1] == symb) {
                    amount += 1;
                    if (amount == MainApp.DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (MainApp.map[i][MainApp.SIZE - i - j - 1] != symb) {
                    if (amount > 0) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
   // 8  a[j+i,N-1-i]... Диагонали  вниз от диагонали "верх-право -- низ-лево"
    public static boolean testRightDownDiagonals(char symb) {
        int amount = 0;
        for (int j = 1; j < MainApp.SIZE; j++) {
            for (int i = 0; i < MainApp.SIZE - j; i++) {
                if (MainApp.map[j + i][MainApp.SIZE - 1 - i] == symb) {
                    amount += 1;
                    if (amount == MainApp.DOTS_TO_WIN) {
                        return true;
                    }
                }
                if (MainApp.map[j + i][MainApp.SIZE - 1 - i] != symb) {
                    if (amount > 0) {
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
