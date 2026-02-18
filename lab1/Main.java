package lab1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //task1
        task1();
        //task2
        System.out.println(task2Part1());
        System.out.println(task2Part2());
        //task3
        int number = 10500;
        System.out.println(task3(number));
        //task4
        double f1 = 3.6;
        double f2 = 4.1;
        double f3 = 5.9;
        System.out.println(task4(f1, f2, f3));
        //task5
        Scanner scanner = new Scanner(System.in);
        task5(scanner);
        //task6
        Scanner scanner2 = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int b = scanner.nextInt();
            task6(b);
        }
        scanner.close();
    }

    public static void task1() {
        System.out.println("Я");
        System.out.println("хорошо");
        System.out.println("знаю");
        System.out.println("Java");
    }

    public static double task2Part1() {
        return (46 + 10) * (10 / 3.0);
    }

    public static int task2Part2() {
        return 29 * 4 * (-15);
    }

    public static int task3(int number) {
        int result = (number / 10 ) / 10;
        return result;
    }

    public static double task4 (double a, double b, double c) {
        double result = a * b * c;
        return result;
    }

    public static void task5 (Scanner scanner) {
        System.out.println("Enter consecutively three numbers");
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }

    public static void task6 (int b) {
        System.out.println("Enter one more number");
        if (b % 2 != 0) {
            System.out.println("Нечетное");
        } else {
            System.out.println("Четное");
            if (b > 100) {
                System.out.println("Выход за пределы диапазона");
            }
        }
    }
}