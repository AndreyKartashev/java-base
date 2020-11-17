package ru.geekbrains.lesson7.oop;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        System.out.println("Кот поел.");
        if (p.decreaseFood(appetite)) {
            System.out.print("Еды коту хватило, в тарелке осталось - ");
        } else {
            System.out.print("Еды коту НЕ хватило, в тарелке осталось - ");
        }
        p.info();
    }
}