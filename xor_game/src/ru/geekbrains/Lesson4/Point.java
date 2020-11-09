package ru.geekbrains.Lesson4;

public class Point {
    public static void searchPoint(int x1, int y1, int x2, int y2, int reg) {
        //reg равен: 1 - ставить слева от линии или сверху, 2 - ставить справа от линии или снизу.
        switch (MainApp.signRow) {
            case 1: { // вертикальная линия
                MainApp.pointY = y1;
                if (reg == 1) {
                    if (x1 > 0) {
                        MainApp.pointX = x1 - 1;
                    } else {
                        MainApp.pointX = -1;
                    }
                } else {
                    if (x2 < MainApp.SIZE - 1) {
                        MainApp.pointX = x2 + 1;
                    } else {
                        MainApp.pointX = -1;
                    }
                }
            }
            case 2: { // горизонтальная линия
                MainApp.pointX = x1;
                if (reg == 1) {
                    if (y1 > 0) {
                        MainApp.pointY = y1 - 1;
                    } else {
                        MainApp.pointY = -1;
                    }
                } else {
                    if (y2 < MainApp.SIZE - 1) {
                        MainApp.pointY = y2 + 1;
                    } else {
                        MainApp.pointY = -1;
                    }
                }
            }
            case 3: { // главная и другие диагонали к главной (слева направо вниз)
                if (reg == 1) {
                    if (x1 > 0) {
                        MainApp.pointX = x1 - 1;
                    } else {
                        MainApp.pointX = -1;
                    }
                    if (y1 > 0) {
                        MainApp.pointY = y1 - 1;
                    } else {
                        MainApp.pointY = -1;
                    }
                } else {
                    if (x2 < MainApp.SIZE - 1) {
                        MainApp.pointX = x2 + 1;
                    } else {
                        MainApp.pointX = -1;
                    }
                    if (y2 < MainApp.SIZE - 1) {
                        MainApp.pointY = y2 + 1;
                    } else {
                        MainApp.pointY = -1;
                    }
                }
            }
            case 4: { // побочная диагональ слева направо вверх и другие к побочной (выше и ниже)
                if (reg == 1) {
                    if (x1 < MainApp.SIZE - 1) {
                        MainApp.pointX = x1 - 1;
                    } else {
                        MainApp.pointX = -1;
                    }
                    if (y1 > 0) {
                        MainApp.pointY = y1 - 1;
                    } else {
                        MainApp.pointY = -1;
                    }
                } else {
                    if (x2 > 0) {
                        MainApp.pointX = x2 - 1;
                    } else {
                        MainApp.pointX = -1;
                    }
                    if (y2 < MainApp.SIZE - 1) {
                        MainApp.pointY = y2 + 1;
                    } else {
                        MainApp.pointY = -1;
                    }
                }
            }
        }
    }
}
