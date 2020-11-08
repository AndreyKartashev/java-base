package ru.geekbrains.Lesson4;

public class Point {
    public static void searchPoint(int x1, int y1, int x2, int y2, int reg) {
        //reg равен: 1 - ставить слева от линии или сверху, 2 - ставить справа от линии или снизу.
        switch (Main.signRow) {
            case 1: { // вертикальная линия
                Main.pointY = y1;
                if (reg == 1) {
                    if (x1 > 0) {
                        Main.pointX = x1 - 1;
                    } else {
                        Main.pointX = -1;
                    }
                } else {
                    if (x2 < Main.SIZE - 1) {
                        Main.pointX = x2 + 1;
                    } else {
                        Main.pointX = -1;
                    }
                }
            }
            case 2: { // горизонтальная линия
                Main.pointX = x1;
                if (reg == 1) {
                    if (y1 > 0) {
                        Main.pointY = y1 - 1;
                    } else {
                        Main.pointY = -1;
                    }
                } else {
                    if (y2 < Main.SIZE - 1) {
                        Main.pointY = y2 + 1;
                    } else {
                        Main.pointY = -1;
                    }
                }
            }
            case 3: { // главная и другие диагонали к главной (слева направо вниз)
                if (reg == 1) {
                    if (x1 > 0) {
                        Main.pointX = x1 - 1;
                    } else {
                        Main.pointX = -1;
                    }
                    if (y1 > 0) {
                        Main.pointY = y1 - 1;
                    } else {
                        Main.pointY = -1;
                    }
                } else {
                    if (x2 < Main.SIZE - 1) {
                        Main.pointX = x2 + 1;
                    } else {
                        Main.pointX = -1;
                    }
                    if (y2 < Main.SIZE - 1) {
                        Main.pointY = y2 + 1;
                    } else {
                        Main.pointY = -1;
                    }
                }
            }
            case 4: { // побочная диагональ слева направо вверх и другие к побочной (выше и ниже)
                if (reg == 1) {
                    if (x1 < Main.SIZE - 1) {
                        Main.pointX = x1 - 1;
                    } else {
                        Main.pointX = -1;
                    }
                    if (y1 > 0) {
                        Main.pointY = y1 - 1;
                    } else {
                        Main.pointY = -1;
                    }
                } else {
                    if (x2 > 0) {
                        Main.pointX = x2 - 1;
                    } else {
                        Main.pointX = -1;
                    }
                    if (y2 < Main.SIZE - 1) {
                        Main.pointY = y2 + 1;
                    } else {
                        Main.pointY = -1;
                    }
                }
            }
        }
    }
}
