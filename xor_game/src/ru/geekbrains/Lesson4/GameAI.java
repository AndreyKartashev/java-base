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

package ru.geekbrains.Lesson4;

public class GameAI {
    // на вывод: maxAmount.
    public static void humanRows(char symb) {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
        int max = 0;
        if (TestAI.horisontal(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.vertical(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.leftDiagonal(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.rightDiagonal(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.leftUpDiagonals(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.leftDownDiagonals(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.rightUpDiagonals(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        if (TestAI.rightDownDiagonals(symb, x1, y1, x2, y2))
            if (max < Main.maxAmount)
                max = Main.maxAmount;
        Main.maxAmount = max;

        // Собственно - точка куда ставить
        Point.searchPoint(x1,y1,x2,y2,1);
        if (!Main.isCellValid(Main.pointX, Main.pointY))
            Point.searchPoint(x1,y1,x2,y2,2);
    }
}
