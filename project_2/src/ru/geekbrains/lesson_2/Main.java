package ru.geekbrains.lesson_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int operation, a, b, result;
        Scanner scanner = new Scanner(System.in);
        //1
        System.out.println("Введите операцию:");
        System.out.println("1 - сложение,");
        System.out.println("2 - вычитание,");
        System.out.println("3 - умножение,");
        System.out.println("4 - деление.");

        operation = scanner.nextInt();
        System.out.println("Операция - " + operation);

        System.out.println("Введите два числа:");
        a = scanner.nextInt();
        b = scanner.nextInt();

        //2
        result = 0;
        if (operation == 1) {result = a + b;}
        else if (operation == 2) {result = a - b;}
        else if (operation == 3) {result = a * b;}
        else if (operation == 4) {result = a / b;}

        System.out.println("Результат = " + result);
    }
}
