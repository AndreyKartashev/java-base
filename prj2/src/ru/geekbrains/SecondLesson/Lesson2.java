package ru.geekbrains.SecondLesson;

import java.util.Scanner;

public class Lesson2 {

/* 1 */   final private static int arr1[] = {0, 0, 0, 0, 1, 1, 1, 1 };
/* 2 */   private  static int arr2[] = new int[8];
/* 3 */   final private static int arr3[] = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
/* 4 */   private static int arr4[][] = new int[5][5];
/* 5 */   private static float arr5[] = new float[10]; //min и max
/* 6 */   private static int arr6[];
/* 7 */   private static int arr7[];

          private static Scanner scanner;
/* 7 */   private static int lenArray = 0, numShift = 0;

      public static void main(String[] args)
      {
          scanner = new Scanner(System.in);

          System.out.println("Введите номер задачи: 6 или 7");
          int numTask = scanner.nextInt();

          if (numTask == 6)
          {
              printHello1();

              boolean p = searchSumma (arr6);
              System.out.println("Результат поиска одинаковых сумм в одномерном массиве - "+ p);

              printGoodBye1();
          }
          else if (numTask == 7) {
              printHello2();

              System.out.println("Введите число для сдвига, положительное либо отрицательное, но не большее по модулю " + lenArray + " :");
              numShift = scanner.nextInt();

              String str;

              if (numShift >= 0) {
                  str = " вправо";
                  shiftRight(numShift);
              } else {
                  str = " влево";
                  shiftLeft(numShift);
              }

              System.out.println("Результат сдвига на " + Math.abs(numShift) + " позиций " + str + " :");

              printGoodBye2();
          }
      }

      public static void printHello1() {
        System.out.println("Добрый день! Введите размерность одномерного массива целых чисел: от 1 до 100");
        lenArray = scanner.nextInt();
        System.out.println("Введите " + lenArray + " целых чисел:");
        arr6 = new int[lenArray];
        for (int i = 0; i < lenArray; i++) {
            arr6[i] = scanner.nextInt();
        }
      }

    public static void printGoodBye1() {   // вывод массива в консоль
        for (int k = 0; k <= arr6.length - 1; k++) {
           System.out.print(arr6[k] + " ");
        }
        System.out.println("\n" + "Задача выполнена, спасибо!");
    }

    public static void printHello2() {
        System.out.println("Добрый день! Введите размерность одномерного массива целых чисел: от 1 до 100");
        lenArray = scanner.nextInt();
        System.out.println("Введите " + lenArray + " целых чисел:");
        arr7 = new int[lenArray];
        for (int i = 0; i < lenArray; i++) {
            arr7[i] = scanner.nextInt();
        }
    }

    public static void printGoodBye2() {   // вывод массива в консоль
        for (int k = 0; k <= arr7.length - 1; k++) {
            System.out.print(arr7[k] + " ");
        }
        System.out.println("\n" + "Задача выполнена, спасибо!");
    }

/*  1.    Задать целочисленный массив, состоящий из элементов 0 и 1.
    Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
*/
    public static void changeArray() {
        for(int i = 0; i < arr1.length; i++)
        {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else if (arr1[i] == 1) {
                arr1[i] = 0;
            }
        }
    }

/*  2.    Задать пустой целочисленный массив размером 8.
    С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
*/
    public static void setIntArray() {
        for (int i = 0; i <= (arr2.length-1)*3; i += 3) {
            arr2[i] = i * 3;
        }
    }

/*  3.    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
    и числа меньшие 6 умножить на 2;
*/
    public static void setIntArray2() {
        for (int i = 0; i < arr3.length; i ++) {
            if (arr3[i] < 6) {arr3[i] *= 2;}
        }
    }

/*  4.    Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
*/
    public static void setIntSquareArrayDiag() {
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (j == i) {
                    arr4[i][j] = 1;
                }
            }
        }
    }

/*   5.    ** Задать одномерный массив и найти в нем минимальный и максимальный элементы
     (без помощи интернета);
*/
    public static void searchAggregateArr(float arrMin, float arrMax) {
      arrMin = arr5[0];
      arrMax = arr5[0];
      for (int i = 1; i <= arr5.length - 1; i ++) {
         if (arr5[i] >= arrMax) {
             arrMax = arr5[i];
         }
         if (arr5[i] < arrMin) {
              arrMin = arr5[i];
         }
      }
    }

/*  6.   ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true, если в массиве есть место,
    в котором сумма левой и правой части массива равны.
    Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

    В цикле:
    int function summa1;
    int function summa2;
    summa1 == summa2 -> true + количества в левой и правой части.
*/
    public static boolean searchSumma (int[] array1) {
        boolean result = false;

        if (array1.length < 2) {
            System.out.println("\n" + "Должно быть хотя бы 2 числа!");
            result = false;
        } else {
            for (int i = 0; i < array1.length; i++) {
                if (Summa1(i, array1) == Summa2(i, array1)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static int Summa1(int posNumber, int[] beginArr) {
        int sum1 = 0;
        for (int i = 0; i < posNumber; i++)
           sum1 += beginArr[i];
        return sum1;
    }

    public static int Summa2(int posNumber, int[] beginArr) {
        int sum2 = 0;
        for (int j = posNumber; j < beginArr.length; j++)
            sum2 += beginArr[j];
        return sum2;
    }

/*  7.    **** Написать метод, которому на вход подается одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива
    на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться
    вспомогательными массивами.
    Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.
*/
    public static void shiftLeft (int nShift) {
        for (int k = 1; k <= Math.abs(nShift); k++) {
            int i = arr7.length - 1;
            int cell = arr7[i];
            arr7[i] = arr7[0];
            // сдвигается на одну ячейку массива
            //  shLeft(i, cell);  // Можно оформить в виде дополнительного метода
            for (int j = i - 1; j >= 0; j--) {
                int temp = arr7[j];
                arr7[j] = cell;
                cell = temp;
            }
        }
    }

    public static void shiftRight (int nShift) {
        for (int k = 1; k <= Math.abs(nShift); k++) {
            int cell = arr7[0];
            arr7[0] = arr7[arr7.length - 1];
            // сдвигается на одну ячейку массива
            //  shRight(i, cell);  // Можно оформить в виде дополнительного метода
            for (int i = 1; i <= arr7.length - 1; i++) {
                int temp = arr7[i];
                arr7[i] = cell;
                cell = temp;
            }
        }
    }
}

    /* К заданию 7 - можно попробовать оформить в виде рекурсивной процедуры (метода), вот пример:
    private static void shLeft (int numberPos, int cell){
        int numCell = numberPos - 1;
        int temp = arr7[numCell];
        arr7[numCell] = cell;
        cell = temp;

        if (numCell == arr7.length-1) {
            System.out.print(numCell + " " + temp);
        }
        else {
            if (numCell == 0){
                shLeft(arr7.length - 1, cell);
            }
            else {
                shLeft(numCell, cell);
            }
        }
    }

    private static void shRight (int numberPos, int cell){
        int temp = arr7[numberPos + 1];
        arr7[numberPos + 1] = cell;
        cell = temp;
        if (numberPos+1 <= arr7.length)
            shLeft(numberPos-1, cell);
            ...
    }
*/