package ru.geekbrains.lesson7.homework;
/*
1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть
не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы
добавлять еду в тарелку
*/

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // write your code here
        char[] arr = new char[]{'a', 'B', 'c', 'D', 'e'};
        String str = new String(arr);
        System.out.println("Массив символов = " + str);
        StringBuilder sbStrPrimer;
        sbStrPrimer = new StringBuilder(str);
        System.out.println("Переменная стринг билдер = " + sbStrPrimer + " вот так!");

        Cat cat = new Cat("Barsik", 5);
        Cat cat2 = new Cat("Belka", 10);
        Plate plate = new Plate(100);
        Plate plate2 = new Plate(90);
        plate.info();
        plate2.info();
        cat.eat(plate);
        cat2.eat(plate2);
        plate.info();
        plate2.info();

        //массив котов
        Cat[] arrayCats = new Cat[10];
        for (int i = 0; i <= 9; i++) {
            arrayCats[i] = new Cat();
            arrayCats[i].setAppetite((int) (Math.random() *20));
            arrayCats[i].eat(plate2);
            arrayCats[i].hungry();
        }
        plate2.addFood(200);
        plate2.info();
    }
}