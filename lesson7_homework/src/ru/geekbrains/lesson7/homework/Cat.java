package ru.geekbrains.lesson7.homework;

public class Cat {
    private String name;
    private boolean isHungry;
    private int appetite;

    public Cat() {
      this.appetite = 10;
      this.isHungry = true;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }

    public void setHungry(boolean p) {
        this.isHungry = p;
    }

    public boolean getHungry() {
        return this.isHungry;
    }

    public void hungry() {
        if (this.isHungry) System.out.println("Кот голоден.");
        else System.out.println("Кот сыт.");
    }

    public void eat(Plate p) {
        System.out.println("\nКот еcт.");
        if (p.decreaseFood(appetite)) {
            System.out.print("Еды коту хватило, в тарелке осталось - ");
            setHungry(false);
        } else {
            System.out.print("Еды коту НЕ хватило, в тарелке осталось начальное количество еды - ");
            setHungry(true);
        }
        p.info();
    }
}
