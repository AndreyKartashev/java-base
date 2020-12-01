/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
   при подаче массива другого размера необходимо
   бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
   Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
   должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод,
   обработать возможные исключения MySizeArrayException и MyArrayDataException,
   и вывести результат расчета.
*/

package ru.geekbrains.lesson2_1.homework;

import java.util.Scanner;
import java.util.zip.DataFormatException;

public class TestMatrixEx {
    final private static int SIZE = 4;
    private static String[][] strArray;
    private static int summa = 0;
    private static int arraySize = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("Введите размерность квадратной матрицы:");
            arraySize = scanner.nextInt();
            strArray = new String[arraySize][arraySize];
            System.out.println("Введите матрицу:");
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    // Ввод нового значения элемента матрицы
                    strArray[i][j] = scanner.next();
                }
            }
            try {
                summa = numbersCheck(strArray);
                System.out.println("\nСумма элементов двумерного массива = " + summa);
            } catch (MyArraySizeException e) {
                System.out.println("\nОшибка ввода: некорректный размер матрицы. Ошибка: " + e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println("\nОшибка ввода: некорректный символ в матрице. Ошибка: " + e.getMessage());
                System.out.println("\nСимвол: " + e.getValue() + ".  Строка: " + e.getRow() + ", столбец: " + e.getCol());
            }
            System.out.println("\nВведите цифру 0 - чтобы продолжить, или любую другую - чтобы прекратить работу с программой:");
            number = scanner.nextInt();
        } while (number == 0);
    }

    public static int numbersCheck(String[][] strArr) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;

        // Блок проверки размерности квадратной матрицы, отличие от заданного значения.
        {
            if (strArr.length != SIZE) {
                throw new MyArraySizeException();
            }
            for (String[] row : strArr) {
                if (row.length != SIZE) {
                    throw new MyArraySizeException();
                }
            }
        }

        // Блок подсчета в цикле суммы и проверки на ограничение по типу Integer.
        {
            System.out.println("Введенный двумерный массив:");
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    System.out.print(" " + strArr[i][j]);
                    try {
                        //  Новый элемент для суммы
                        summ += Integer.parseInt(strArr[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(strArr[i][j], i + 1, j + 1);
                    }
                }
                System.out.println();
            }
        }
        return summ;
    }
}