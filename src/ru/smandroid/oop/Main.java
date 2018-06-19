package ru.smandroid.oop;

import java.util.Date;

abstract class Person {
    String name;
    String lastName; // Фамилия
    String middleName; // Отчество
    Date dateOfBirth; // Дата рождения

    abstract void call();

    public Person(String name, String lastName, String middleName, Date dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
    }
}

class Abiturient extends Person {
    byte[] marks; // Оценки

    public Abiturient(String name, String lastName, String middleName,
                      Date dateOfBirth, byte[] marks) {
        super(name, lastName, middleName, dateOfBirth);
        this.marks = marks;
    }

    @Override
    void call() {
        System.out.println("Здравствуйте! Вы меня приняли?");
    }
}

class Student extends Person {
    String faculty; // Факультет
    byte course; // Курс
    String group; // Группа

    public Student(String name, String lastName, String middleName,
                   Date dateOfBirth, String faculty, byte course, String group) {
        super(name, lastName, middleName, dateOfBirth);
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    void call() {
        System.out.println("Ээй, зачем вы мне посреди лета звоните? Я всё сдал!");
    }
}


public class Main {

    public static void main(String[] args) {
        Person people[] = {
                new Abiturient("Антон", "Ежиков", "Антонович",
                        new Date(1999, 12, 5), new byte[]{5, 3, 4, 5}),
                new Abiturient("Андрей", "Степанов", "Валерьянович",
                        new Date(1999, 12, 5), new byte[]{5, 3, 4, 5}),
                new Student("Антон", "Сидоров", "Сергеевич",
                        new Date(1997, 5, 12), "ФСиР", (byte)2,
                        "14221-ДБ"),
                new Student("Сергей", "Сидоров", "Валентинович",
                        new Date(1977, 6, 14), "ФСиР", (byte)1,
                        "14121-ДБ")
        };
        for (Person p : people) {
            p.call();
            if (p instanceof Student) {
                ((Student) p).course++;
            }
        }
    }
}
