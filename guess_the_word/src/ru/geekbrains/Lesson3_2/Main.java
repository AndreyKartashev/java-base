package ru.geekbrains.Lesson3_2;

import java.util.Scanner;

public class Main {
    private static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
            "mango", "mushroom", "nut", "olive",
            "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    private static String beginWord;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int gameCounter;

        System.out.println("Игра \"Угадай слово!\"");
        System.out.println("У Вас 10 попыток:");

        do {
            int number = (int) (Math.random() * words.length);
            beginWord = words[number];

            System.out.println("Введите слово на английском, фрукт или овощ: ");
            searchWord();
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

            gameCounter = scanner.nextInt();
        } while (gameCounter != 0);

        scanner.close();
    }

    public static void searchWord() {
        int i = 1, j;
        char symbolBeginWord, symbolNewWord;
        String newWord;

     // Для тестирования   System.out.println("Слово - " + beginWord);

        while (i < 11) { // 5 попыток угадать число
            System.out.println("Попытка " + i);
            newWord = scanner.next().toLowerCase();
            if (newWord.equals(beginWord)) {
                System.out.println("Вы угадали правильно! " + "Загаданное слово = " + newWord);
                break;
            } else {
                System.out.println("Вы угадали не правильно! " + "Загаданное слово все еще скрыто. ");
                System.out.print("Слово - ");

                for (j = 0; j < 15; j++) {
                    if ((j < beginWord.length()) && (j < newWord.length())) {
                        symbolBeginWord = beginWord.charAt(j);
                        symbolNewWord = newWord.charAt(j);
                        if (symbolBeginWord == symbolNewWord) {
                            System.out.print(symbolBeginWord);
                        }
                        else {
                            System.out.print("#");
                        }
                    } else {
                        System.out.print("#");
                    }
                }
                System.out.println("\n");

            }
            if (i == 10) {
                System.out.println("Число попыток закончилось! " + "Загаданное слово = " + beginWord);
                break;
            }
            i++;
        }
    }
}