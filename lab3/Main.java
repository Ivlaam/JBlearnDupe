package lab3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //task1
        String setCourse = "Изучение Java - это просто!";
        Study studyCourse = new Study(setCourse);
        System.out.println(studyCourse.printCourse());


        System.out.println("\n---"); //task2
        Car car1 = new Car();
        car1.setValues("Белый", "Toyota", 1500.5);
        Car car2 = new Car("Красненькая");
        System.out.println("Данные первой машины:");
        car1.showDetails();
        System.out.println("\nДанные второй машины:");
        car2.showDetails();


        System.out.println("\n---"); //task3
        House cottage = new House();
        cottage.setAllHouseFields(2, 2019, "Дачный домик");
        House skyscraper = new House();
        skyscraper.setAllHouseFields(24, 2016, "ЖК Паруса");

        System.out.println("Информация о первом доме");
        cottage.displayHouseInfo();
        System.out.println("Возраст строения: " + cottage.calculateHouseAge() + " лет");

        System.out.println("\nИнформация о втором доме");
        skyscraper.displayHouseInfo();
        System.out.println("Возраст строения: " + skyscraper.calculateHouseAge() + " лет");


        System.out.println("\n---"); //task4
        Tree oak = new Tree(150, "Дуб");
        oak.printInfo();

        Tree pine = new Tree(25, true, "Сосна");
        pine.printInfo();

        Tree emptyTree = new Tree();
        emptyTree.printInfo();
    }
}

//task1
class Study {

    private String course;

    public Study(String course) {
        this.course = course;
    }

    public String printCourse() {
        return this.course;
    }
}

//task2
class Car {
    private String color;
    private String name;
    private double weight;

    // empty
    public Car() {
    }

    // only color
    public Car(String color) {
        this.color = color;
    }

    // color+weight
    public Car(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    // all options
    public void setValues(String color, String name, double weight) {
        this.color = color;
        this.name = name;
        this.weight = weight;
    }

    public void showDetails() {
        System.out.println("Цвет: " + color);
        System.out.println("Название: " + name);
        System.out.println("Вес: " + weight);
    }
}

//task3
class House {
    private int floors;
    private int yearBuilt;
    private String name;


    public void setAllHouseFields(int floors, int yearBuilt, String name) {
        this.floors = floors;
        this.yearBuilt = yearBuilt;
        this.name = name;
    }

    public void displayHouseInfo() {
        System.out.println("Наименование: " + name);
        System.out.println("Количество этажей: " + floors);
        System.out.println("Год постройки: " + yearBuilt);
    }

    public int calculateHouseAge() {
        int currentYear = LocalDate.now().getYear();
        int result = currentYear - this.yearBuilt;
        return result;
    }
}

//task4
class Tree {
    private int age;
    private boolean isAlive;
    private String name;

    public Tree(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Tree(int age, boolean isAlive, String name) {
        this.age = age;
        this.isAlive = isAlive;
        this.name = name;
    }

    public Tree() {
        System.out.println("Пустой конструктор без параметров сработал");
    }

    public void printInfo() {
        boolean status = isAlive;
        System.out.println("Название: " + name);
        System.out.println("Возраст: " + age);
        System.out.println("Живое: " + status);
    }
}