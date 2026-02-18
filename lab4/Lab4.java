package lab4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Lab4 {
    public static void main (String[] args) {
        //task1
        printOddNumbers();

        System.out.println("---");//task2
        printDividables();

        System.out.println("---");//tasks3 & 4
        Scanner scanner = new Scanner(System.in);
        /*
        System.out.print("Введите первое число: ");
        int first = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int second = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int third = scanner.nextInt(); //commenting out and replacing with hardcoded values for testing purposes */
        int first = 5;
        int second = 10;
        int third = 15;
        boolean result3 = checkSumEqualThird(first, second, third);
        System.out.println("Сумма первых двух чисел равна третьему: " + result3);

        System.out.println("---");//for task4 output
        boolean result4 = isIncreasing(first, second, third);
        System.out.println("Каждое последующее число больше предыдущего: " + result4);
        //scanner.close();

        System.out.println("---");//tasks5 & 6
        int[] numbers = {3, -3, 7, 4, 5, 4, 3};
        boolean result5 = isThreeAtEnds(numbers);
        System.out.println("В массиве 3 в начале или конце: " + result5);

        System.out.println("---");//for task6 output
        boolean result6 = containsOneOrThree(numbers);
        System.out.println("Массив содержит 1 или 3: " + result6);

        System.out.println("---");//task7
        int[] sortedArray = {1, 2, 3, 4, 10};
        int[] unsortedArray = {1, 5, 2, 8, 3};
        System.out.println("Отсортированный: {1, 2, 3, 4, 10}");
        checkArrayOrder(sortedArray);
        System.out.println("Неотсортированный: {1, 5, 2, 8, 3}");
        checkArrayOrder(unsortedArray);

        /*
        System.out.println("---");//task8
        System.out.print("Array length: ");
        int length = scanner.nextInt();
        int[] userArray = fillArray(scanner, length);
        printArray(userArray); */
        scanner.close();

        System.out.println("---");//task9
        int[] setArray = {5, 6, 7, 2};
        System.out.print("Array 1: ");
        printArray(setArray);
        swapFirstAndLast(setArray);
        System.out.print("Array 2: ");
        printArray(setArray);

        System.out.println("---");//task10
        int[] otherArray = {1, 2, 3, 1, 2, 4};
        findAndPrintUnique(otherArray);

        System.out.println("---");//task11
        int size = 10;
        int[] randomArray = new int[size];

        // randomizer
        fillWithRandom(randomArray, 1, 100);
        System.out.print("Исходный массив: ");
        printArray(randomArray);
        mergeSort(randomArray, 0, randomArray.length - 1);
        System.out.print("Отсортированный массив: ");
        printArray(randomArray);
    }

    //task1
    public static void printOddNumbers() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    //task2
    public static void printDividables() {
        String divBy3 = "";
        String divBy5 = "";
        String divByBoth = "";

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                divByBoth += i + ", ";
            }
            if (i % 3 == 0) {
                divBy3 += i + ", ";
            }
            if (i % 5 == 0) {
                divBy5 += i + ", ";
            }
        }

        System.out.println("Делится на 3: " + divBy3);
        System.out.println("Делится на 5: " + divBy5);
        System.out.println("Делится на 3 и на 5: " + divByBoth);
    }

    //task3
    public static boolean checkSumEqualThird(int a, int b, int c) {
        return (a + b) == c;
    }

    //task4
    public static boolean isIncreasing(int a, int b, int c) {
        return (b > a) && (c > b);
    }

    //task5
    public static boolean isThreeAtEnds(int[] array) {
        if (array.length < 2) {
            return false;
        }
        return (array[0] == 3) || (array[array.length - 1] == 3);
    }

    //task6
    public static boolean containsOneOrThree(int[] array) {
        for (int number : array) {
            if (number == 1 || number == 3) {
                return true;
            }
        }
        return false;
    }

    //task7
    public static void checkArrayOrder(int[] array) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
                break; // Дальше проверять нет смысла
            }
        }
        if (isSorted) {
            System.out.println("OK");
        } else {
            System.out.println("Please, try again");
        }
    }

    //task8, also printArray reused for tasks 9 and 11
    public static int[] fillArray(Scanner scanner, int length) {
        int[] array = new int[length];
        System.out.println("Numbers of array:");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    //task9
    public static void swapFirstAndLast(int[] array) {
        if (array.length < 2) {
            return;
        }
        int temp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = temp;
    }

    //task10
    public static void findAndPrintUnique(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            boolean isUnique = true;
            for (int j = 0; j < array.length; j++) {
                if (i != j && current == array[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                System.out.println("Первое уникальное число: " + current);
                return;
            }
        }
        System.out.println("Уникальных чисел в массиве нет.");
    }

    //task11
    public static void fillWithRandom(int[] array, int min, int max) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    //okay, now that was REALLY hard even just to understand! Is it actually a basics level???
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] L = new int[n1]; //temp arrays
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i) L[i] = array[left + i];
        for (int j = 0; j < n2; ++j) R[j] = array[middle + 1 + j];
        int i = 0, j = 0, k = left; //preparing
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { //which is lesser - add to result_array
                array[k] = L[i]; //left is smaller
                i++;
            } else { //right is smaller
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) { //picking up leftovers
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
