package ru.geekbrains.Lesson3_1;

import java.util.Scanner;

public class SearchTheNumber {
    final private static int range = 10;
    private static Scanner scanner;

    //Главный метод класса
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int gameCounter;

        System.out.println("Игра \"Угадай число!\"");
        System.out.println("У Вас 3 попытки:");

        do {
           System.out.println("Введите число от 0 до " + range);

           testDigit();

           System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
           gameCounter = scanner.nextInt();
        } while (gameCounter != 0);

        scanner.close();
    }

    // Процедура для цикла проверки числа
    private static void testDigit() {
        int inputNumber;
        int i = 1;
        // Загаданный номер от 0 до range (range - константа, описана в начале словом final :
        int number = (int) (Math.random() * range);

        while (i <= 3) { // 3 попытки угадать число
            System.out.println("Попытка " + i);
            inputNumber = scanner.nextInt();

            if (number == inputNumber) {
                System.out.println("Вы угадали правильно! " + "Загаданное число = " + number);
                break;
            } else if (number > inputNumber) {
                System.out.println("Загаданное число больше. ");
            } else {
                System.out.println("Загаданное число меньше. ");
            }
            if (i == 3) {
                System.out.println("Число попыток закончилось! " + "Загаданное число = " + number);
                break;
            }
            i = i + 1;
        }
    }
}