package lab2;

public class Main {

    public static void main(String[] args) {
        //task1
        System.out.println("Сумма int: " + Calculator.add(15, 10));
        System.out.println("Сумма long: " + Calculator.add(400L, 200L));
        System.out.println("Сумма double: " + Calculator.add(12.5, 2.5));

        System.out.println("Вычитание int: " + Calculator.sub(15, 10));
        System.out.println("Вычитание long: " + Calculator.sub(400L, 200L));
        System.out.println("Вычитание double: " + Calculator.sub(12.5, 2.5));

        System.out.println("Умножение int: " + Calculator.mult(15, 10));
        System.out.println("Умножение long: " + Calculator.mult(400L, 200L));
        System.out.println("Умножение double: " + Calculator.mult(12.5, 2.5));

        System.out.println("Деление int: " + Calculator.div(15, 10));
        System.out.println("Деление long: " + Calculator.div(400L, 200L));
        System.out.println("Деление double: " + Calculator.div(12.5, 2.5));

        System.out.println("---"); //task2

        Animal unknownAnimal = new Animal();
        System.out.println("Данные первого животного:");
        unknownAnimal.printAnimal();

        System.out.println("---");

        Animal myCat = new Animal("Мурзик", "Кот", 5);
        System.out.println("Данные второго животного:");
        myCat.printAnimal();
    }
}

class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }

    public static long add(long a, long b) {
        return a + b;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static long sub(long a, long b) {
        return a - b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    public static long mult(long a, long b) {
        return a * b;
    }

    public static double mult(double a, double b) {
        return a * b;
    }

    public static int div(int a, int b) {
        return a / b;
    }

    public static long div(long a, long b) {
        return a / b;
    }

    public static double div(double a, double b) {
        return a / b;
    }
}

class Animal {
    private String name;
    private String species; // Вид
    private int age;

    public Animal() {
        this.name = "Безымянный";
        this.species = "Неизвестный вид";
        this.age = 0;
    }

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public void printAnimal() {
        System.out.println("Кличка: " + name);
        System.out.println("Вид: " + species);
        System.out.println("Возраст: " + age);
    }
}