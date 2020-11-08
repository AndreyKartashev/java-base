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
            System.out.println("Зарплата: "+ person.payment);
            System.out.println("Телефон: " + person.phone + "   E-mail:" + person.email);
        }
    }
    public PersonalBook() {
        Person[] persArray = new Person[10];

        persArray[0] = new Person("Иванов","Иван", "Иванович", "Сотрудник", "ivanov@mail.ru", "111 11 11", 10000f, 41 );
        persArray[1] = new Person("Петров", "Пётр", "Петрович","Сотрудник", "petrov@mail.ru", "222 22 22",  12000f, 42 );
        persArray[2] = new Person("Сидоров", "Евгений", "Николаевич", "Мастер", "sidorov@mail.ru", "333 33 33", 14000f, 43);
/*      persArray[3] = new Person("");
        persArray[4] = new Person("");
        persArray[5] = new Person("");
        persArray[6] = new Person("");
        persArray[7] = new Person("");
        persArray[8] = new Person("");
        persArray[9] = new Person("");
 */
        for (int i = 0; i < persArray.length; i++)
            if (persArray[i].age >= 40)
                persArray[i].printPerson(persArray[i]);
    }

    public static void main(String[] args) {
        PersonalBook initBook = new PersonalBook();
    }
}