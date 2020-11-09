/*    1. Создать классы Собака и Кот с наследованием от класса Животное.
      2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается
         длина препятствия.
         Результатом выполнения действия будет печать в консоль.
         (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
      3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание:
         кот не умеет плавать, собака 10 м.).
      4. * Добавить подсчет созданных котов, собак и животных.
*/
package ru.geekbrains.Lesson6.oop;

public class MainApp {
    public static int numberObjects = 0;

    public static class Animal {
        public String name;
        public int lengthSwim;
        public int lengthRun;
        public int checkSwimLen;
        public int checkRunLen;

        public Animal() {
            //
        }

        public Animal(String name, int lengthSwim, int lengthRun) {
            numberObjects += 1;
            this.name = name;
            this.lengthSwim = lengthSwim;
            this.lengthRun = lengthRun;
        }

        public void run(int length) {
            System.out.println("Животное " + this.name + " пробежало: " + length + "м.");
        }

        public void swim(int length) {
            System.out.println("Животное " + this.name + " проплыло: " + length + "м.");
        }
    }

    public static class Cat extends Animal {
        public Cat() {
            //
        }

        public Cat(String name, int lengthR, int lengthS) {
            super(name, lengthS, lengthR);
            this.checkSwimLen = 0;
            this.checkRunLen = 200;
            if (this.lengthRun > this.checkRunLen) System.out.println("Это рекорд по бегу для кошек!");
            if (this.lengthSwim > this.checkSwimLen) System.out.println("Это рекорд по плаванию для кошек!");
        }
        @Override
        public void run(int length) {
            System.out.println("Кошка " + this.name + " пробежала: " + length + "м.");
        }
        @Override
        public void swim(int length) {
            System.out.println("Кошка " + this.name + " проплыла: " + length + "м.");
        }
    }

    public static class Dog extends Animal {
        public Dog() {
            //
        }

        public Dog(String name, int lengthR, int lengthS) {
            super(name, lengthS, lengthR);
            this.checkSwimLen = 10;
            this.checkRunLen = 500;
            if (this.lengthRun > this.checkRunLen) System.out.println("Это рекорд по бегу для собак!");
            if (this.lengthSwim > this.checkSwimLen) System.out.println("Это рекорд по плаванию для собак!");
        }
        @Override
        public void run(int length) {
            System.out.println("Собака " + this.name + " пробежала: " + length + "м.");
        }
        @Override
        public void swim(int length) {
            System.out.println("Собака " + this.name + " проплыла: " + length + "м.");
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal("Кошка Барсик", 10, 100);
        a.run(100);
        a.swim(10);

        Cat b = new Cat("WhiteSnow", 10, 50);
        b.run(50);
        b.swim(10);

        Dog c = new Dog("BlackAngus", 20, 100);
        c.run(20);
        c.swim(100);

        System.out.println("Количество созданных объектов = " + numberObjects + ".\n");
    }
}