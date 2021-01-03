package ru.geekbrains.lesson1.homework;

public class Fruit<type1, type2> {
    public type1 apple = null;
    public type2 orange = null;
    private float weight = 0.0f;

    public Fruit(type1 obj1, type2 obj2, float weight) {
        this.apple = obj1;
        this.orange = obj2;
        this.weight = weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }

        public void showTypes() {
        System.out.println("Тип type1: " + apple.getClass().getName());
        System.out.println("Тип type2: " + orange.getClass().getName());
    }

    public type1 getApple() {
        return apple;
    }

    public type2 getOrange() {
        return orange;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}