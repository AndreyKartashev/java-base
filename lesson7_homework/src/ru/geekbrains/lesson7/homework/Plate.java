package ru.geekbrains.lesson7.homework;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int amountFood) {
        this.food += amountFood;
    }
    public boolean decreaseFood(int n) {
        if ((food - n) >= 0) {
            food -= n;
            return true;
        }
        else return false;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}