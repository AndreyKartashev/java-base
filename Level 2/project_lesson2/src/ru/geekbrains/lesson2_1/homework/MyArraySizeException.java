package ru.geekbrains.lesson2_1.homework;

public class MyArraySizeException extends IllegalArgumentException {

    public MyArraySizeException() {
        super("Размерность матрицы должна быть 4.");
    }
}
