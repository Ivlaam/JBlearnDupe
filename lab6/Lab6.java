package lab6;

import java.util.Scanner;

public class Lab6 {
    public static void main (String[] args) {
        //task1
        Client client = new Client("Иван", "Иванов", "Сбербанк");
        BankEmployee employee = new BankEmployee("Ольга", "Петрова", "ВТБ");
        System.out.println("Данные клиента:");
        client.printAllInfo();
        System.out.println("\nДанные работника:");
        employee.printAllInfo();

        System.out.println("---");//task3
        Truck myTruck = new Truck(8000, "Volvo", 'R', 90.5f, 12, 25000);
        myTruck.outPut();
        myTruck.newWheels(10);

        System.out.println("---");//task4
        ChildClass child = new ChildClass();
        child.parentNumber = 42;
        child.displayParentVariable();

        System.out.println("---");//task5
        UserChild user = new UserChild();
        String name = user.getUserData();
        int age = user.getUserAge();

        System.out.println("\nИтоговые данные пользователя:");
        System.out.println("Имя: " + name + ", Возраст: " + age);
        UserParent.scanner.close();
    }
}

//task1
abstract class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract void printAllInfo();
}

class Client extends Person {
    private String bankName;

    public Client(String firstName, String lastName, String bankName) {
        super(firstName, lastName);
        this.bankName = bankName;
    }

    @Override
    public void printAllInfo() {
        System.out.println("Имя: " + getFirstName());
        System.out.println("Фамилия: " + getLastName());
        System.out.println("Банк: " + bankName);
    }
}

class BankEmployee extends Person {
    private String bankName;

    public BankEmployee(String firstName, String lastName, String bankName) {
        super(firstName, lastName);
        this.bankName = bankName;
    }

    @Override
    public void printAllInfo() {
        System.out.println("Сотрудник: " + getFirstName() + " " + getLastName());
        System.out.println("Место работы: " + bankName);
    }
}

//task2
/* Ok. Interfaces in current task allows us to define common behaviour for different types of "persons", for example:
* interface BankParticipant will make both Client and Employee to have a getBankName() method. This is smth about
* polymorphism, right? I.e, in a single loop we can process all people associated with a specific bank, regardless of
* their position/role */

//task3
class Car {
    public int weight;
    public String model;
    public char color; //this is soo lame, to use char as color id...
    public float speed;


    public void outPut () {
        System.out.println("Вес " + model + " составляет " + weight + "кг.");
        System.out.println("Цвет машины - " + color + " и её скорость - " + speed);
    }

    public Car (int w, String m, char c, float s) {
        weight = w;
        model = m;
        color = c;
        speed = s;
    }

    public Car () {}
}

class Truck extends Car {
    private int numberOfWheels;
    private int maxWeight;

    public Truck(int w, String m, char c, float s, int wheels, int maxW) {
        super(w, m, c, s);
        this.numberOfWheels = wheels;
        this.maxWeight = maxW;
    }

    public void newWheels(int wheels) {
        this.numberOfWheels = wheels;
        System.out.println("Новое количество колес: " + this.numberOfWheels);
    }
}

//task4
class ParentClass {
    public int parentNumber;
}

class ChildClass extends ParentClass {

    public void displayParentVariable() {
        System.out.println("Значение переменной из главного класса: " + parentNumber);
    }
}

//task5
class UserParent {
    protected static Scanner scanner = new Scanner(System.in);

    public int getUserAge() {
        System.out.print("Введите ваш возраст: ");
        int age = scanner.nextInt();
        return age;
    }

    public String getUserData() {
        System.out.print("Введите имя: ");
        return scanner.next();
    }
}

class UserChild extends UserParent {
    @Override
    public String getUserData() {
        System.out.print("Введите Ваше имя: ");
        String name = scanner.next();
        return name;
    }
}