package multithread;

public class threads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- task1: СОСТОЯНИЯ 10 ПОТОКОВ ---");
        runTask1();

        Thread.sleep(1000); // pause
        System.out.println("\n--- task2: СИНХРОНИЗАЦИЯ СЧЕТЧИКА ---");
        runTask2();

        Thread.sleep(1000); // pause
        System.out.println("\n--- task3: ПИНГ-ПОНГ (wait/notify) ---");
        System.out.println("(Запущено на 5 итераций)");
        runTask3();
    }

    //task1
    public static void runTask1() throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j <= 100; j++) {
                    System.out.println(Thread.currentThread().getName() + " вывел: " + j);
                }
            });
            threads[i].setName("Поток-" + (i + 1));
            System.out.println("--- " + threads[i].getName() + " ПЕРЕД СТАРТОМ: " + threads[i].getState());
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
            System.out.println("--- " + t.getName() + " ПОСЛЕ ФИНИША: " + t.getState());
        }
    }

    //task2
    public static void runTask2() throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) t.join();
        System.out.println("Итоговый счет (ожидаем 100 000): " + counter.getCount());
    }

    //task3
    public static void runTask3() {
        Object lock = new Object();
        Runnable task = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (count < 5) {
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName());
                        count++;
                        lock.notify(); // waking up
                        try {
                            if (count < 5) lock.wait(); // going to sleep
                        } catch (InterruptedException e) { break; }
                    }
                }
            }
        };

        new Thread(task, "Thread A").start();
        new Thread(task, "Thread B").start();
    }
}

//task2
class Counter {
    private int count = 0;
    public synchronized void increment() { //without this we can lose iterations
        count++;
    }
    public int getCount() { return count; }
}