package ru.geekbrains.Lesson5.personal;

public class PersonalBook {
    public static class Person {
        private String serName;
        private String firstName;
        private String lastName;
        private String rang;
        private String email;
        private String phone;
        private float payment;
        private int age;

        public Person(String serName, String firstName,
                      String lastName, String rang, String email, String phone, float payment, int age) {
            this.serName = serName;
            this.firstName = firstName;
            this.lastName = lastName;
            this.rang = rang;
            this.email = email;
            this.phone = phone;
            this.payment = payment;
            if (age > 0 && age < 100)
                this.age = age;
            else this.age = 50;
        }

        public void printPerson(Person person) {
            System.out.println("Карта сотрудника: " + person.serName + " " + person.firstName + " " + person.lastName + ".");
            System.out.println("Должность: " + person.rang);
            System.out.println("Возраст:" + person.age);
            System.out.println("Зарплата: " + person.payment);
            System.out.println("Телефон: " + person.phone + "   E-mail:" + person.email + "\n");
        }
    }

    public PersonalBook() {
        Person[] persArray = new Person[10];

        persArray[0] = new Person("Иванов", "Иван", "Иванович", "Сотрудник цеха", "ivanov@mail.ru", "111 11 11", 10000f, 41);
        persArray[1] = new Person("Петров", "Пётр", "Петрович", "Сотрудник цеха", "petrov@mail.ru", "222 22 22", 12000f, 22);
        persArray[2] = new Person("Сидоров", "Евгений", "Николаевич", "Мастер по ремонту", "sidorov@mail.ru", "333 33 33", 14000f, 43);
        persArray[3] = new Person("Николаев", "Илья", "Владимирович", "Начальник отделения", "nikolaev@mail.ru", "444 44 44", 15000.125f, 50);
        persArray[4] = new Person("Свиридов", "Сергей", "Алексеевич", "Начальник отдела разработки", "sviridov@mail.ru", "555 55 55", 18000.500f, 30);
        persArray[5] = new Person("Монахов", "Валерий", "Николаевич", "Сотрудник отдела исследований", "monakhov@mail.ru", "666 66 66", 23000.1f, 49);
        persArray[6] = new Person("Епифанов", "Илья", "Кириллович", "Начальник цеха", "epifanov@mail.ru", "777 77 77", 29000.50f, 39);
        persArray[7] = new Person("Борисов", "Николай", "Григорьевич", "Сотрудник отделения подготовки", "borisov@mail.ru", "888 88 88", 27000.25f, 45);
        persArray[8] = new Person("Мальцев", "Юрий", "Николаевич", "Генеральный директор", "maltsev@mail.ru", "999 99 99", 50000.40f, 60);
        persArray[9] = new Person("Карташев", "Андрей", "Юрьевич", "Ведущий программист Java", "andrey01_2001@outlook.com", "555 66 77", 39000.18f, 40);

        for (int i = 0; i < persArray.length; i++)
            if (persArray[i].age >= 40)
                persArray[i].printPerson(persArray[i]);
    }

    public static void main(String[] args) {
        System.out.println("\nПрограмма \"Учет сотрудников\".\n");
        PersonalBook initBook = new PersonalBook();
    }
}