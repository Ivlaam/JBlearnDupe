package lab9;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Lab9 {
    public static void main(String[] args) {
        //task2 (???)
        List<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Apple", "Orange", "Banana", "Grape"));
        System.out.println("Исходная коллекция: " + fruits);
        Collection<String> uniqueFruits = removeDuplicates(fruits);
        System.out.println("Коллекция без дубликатов: " + uniqueFruits);

        System.out.println("---");//task3
        int addCount = 1_000_000;
        int getCount = 100_000;
        List<Integer> arrayList = new ArrayList<>();
        runTest("ArrayList", arrayList, addCount, getCount);
        System.out.println("\n");
        List<Integer> linkedList = new LinkedList<>();
        //runTest("LinkedList", linkedList, addCount, getCount); //it's taking too long, had to comment it out

        System.out.println("---");//task4
        Map<User, Integer> scores = new HashMap<>();
        scores.put(new User("Ivan"), 150);
        scores.put(new User("Anna"), 230);
        scores.put(new User("Oleg"), 85);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя пользователя для поиска очков: ");
        String searchName = scanner.nextLine();
        findUserScore(scores, searchName);
        scanner.close();
    }

    //task2
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        Set<T> set = new HashSet<>(collection);
        return new ArrayList<>(set);
    }

    //task3
    public static void runTest(String name, List<Integer> list, int addCount, int getCount) {
        long startAdd = System.currentTimeMillis();
        fillList(list, addCount);
        long endAdd = System.currentTimeMillis();
        System.out.println(name + " | Добавление " + addCount + " элементов: " + (endAdd - startAdd) + " мс");
        long startGet = System.currentTimeMillis();
        getRandomElements(list, getCount);
        long endGet = System.currentTimeMillis();
        System.out.println(name + " | Выборка " + getCount + " элементов: " + (endGet - startGet) + " мс");
    }

    public static void fillList(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }

    public static void getRandomElements(List<Integer> list, int count) {
        int size = list.size();
        for (int i = 0; i < count; i++) {
            int randomIndex = ThreadLocalRandom.current().nextInt(size);
            list.get(randomIndex);
        }
    }

    //task4
    public static void findUserScore(Map<User, Integer> map, String name) {
        User searchKey = new User(name);
        if (map.containsKey(searchKey)) {
            Integer score = map.get(searchKey);
            System.out.println("У пользователя " + name + " сейчас " + score + " очков.");
        } else {
            System.out.println("Пользователь с именем '" + name + "' не найден.");
        }
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}