package ru.geekbrains.First_Lesson;

import java.util.Scanner;

public class prjTestYear {
    private static int year;
    private static Scanner scanner;
    private static boolean yesNoYear;

//  2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
    private static int x = 10, y = 20;
    private static float f, m = 1.5f;
    private static boolean test_p = false;
    private byte i = 0, j = 0, k = 1;
    private double yes = 78.656;
    private char с = 'j';

//  1. Создать пустой проект в IntelliJ IDEA и прописать метод main();

    public static void main(String[] args) {
	  scanner = new Scanner(System.in);

	  System.out.println("Введите год: ");
      year = scanner.nextInt();
      System.out.println("Вы ввели "+ year +" год.");

        yesNoYear = TestYear(year);
        if (Yes_No_Year)
            System.out.println("Спасибо за использование нашей программы! Год - високосный.");
        else
            System.out.println("Спасибо за использование нашей программы! Но - год не високосный.");
    }

//    3. Написать метод вычисляющий выражение a * (b + (c / d)) и
//    возвращающий результат,где a, b, c, d – входные параметры этого метода;
    public double Arifm1(int a, int b, int c, int d){
        return a * (b + (c / d));
    }

//    4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
//    в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public boolean Arifm2 (int a, int b){
        int res = a + b;
        if ((res >= 10) && (res <= 20)) {
            return true;
        }
        else {
            return false;
        }
    }

//    5. Написать метод, которому в качестве параметра передается целое число,
//    метод должен напечатать в консоль положительное ли число передали, или отрицательное;
//    Замечание: ноль считаем положительным числом.
    public boolean Arifm3 (int a) {
     if ( a >= 0 ) {
         System.out.println("Число " + a +" положительное.");
         return true;
     }
     else {
         System.out.println("Число "+ a +" отрицательное.");
         return false;
     }
    }

//    6. Написать метод, которому в качестве параметра передается целое число,
//    метод должен вернуть true, если число отрицательное;
    public boolean Arifm4 (int a) {
        if ( a < 0 ) {
            System.out.println("Число " + a +" отрицательное.");
            return true;
        }
        else  {
            return false;
        }
    }

//    7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
//    метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public void OutString(String str) {
        System.out.println("Привет, " + str + "!");
    }

   /*Возможно параметр метода представить в виде массива символов char[] str, а потом при выводе на консоль
     написать преобразовать в строку str.toString();
     char[] str1;
     str1.toString()
   */

//    8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    public static boolean TestYear (int numberYear){
        int rest4, rest100, rest400;
        rest4 = numberYear % 4;
        rest100 = numberYear % 100;
        rest400 = numberYear % 400;
        if (rest400 == 0) {
            System.out.println("Год високосный! 1");
            return true;//да
        }
        else if (rest100 == 0){
            System.out.println("Год не високосный! 2");
            return false;//нет
        }
        else if (rest4 == 0){
            System.out.println("Год високосный! 3");
            return true;//да
        }
        else {
            System.out.println("Год не високосный! 4");
            return false;//нет
        }
    }

}