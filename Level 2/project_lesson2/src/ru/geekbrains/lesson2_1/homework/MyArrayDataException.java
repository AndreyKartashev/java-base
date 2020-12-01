package ru.geekbrains.lesson2_1.homework;

public class MyArrayDataException extends RuntimeException {
    private String value;
    private int row;
    private int col;

    public MyArrayDataException(String value, int row, int col) {
        super(String.format("Неправильное значение: '%s' в ячейке матрицы [%d][%d], требуется целое число.", value, row, col));
        this.value = value;
        this.col = col;
        this.row = row;
    }

    public String getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
