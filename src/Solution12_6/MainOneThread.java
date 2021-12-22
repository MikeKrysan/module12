package Solution12_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainOneThread {
    public static void main(String[] args) throws InterruptedException {

        // 1 часть
        Thread maxFromList = new Thread() {
            @Override
            public void run() {
                List<Integer> numbers = new ArrayList<>();
                for (int i = 1; i <= 10000000; i++) {
                    numbers.add(i);
                }
                int max = Collections.max(numbers);
                System.out.println("Max found: " + max);
            }
        };

        // 2 часть
        Thread sortedList = new Thread() {
            @Override
                    public void run() {
                List<Integer> unsorted = new ArrayList<>();
                for (int i = 10000000; i >= 1; i--) {
                    unsorted.add(i);
                }
                Collections.sort(unsorted);
                System.out.println("List is sorted now");
            }
        };

        // 3 часть
        Thread removedFirst = new Thread() {
            @Override
                    public void run() {
                List<Integer> list = new ArrayList<>();
                for (
                        int i = 1;
                        i <= 10000000; i++) {
                    list.add(i);
                }
                while (list.size() != 0) {
                    list.remove(list.size() - 1);
                }
                System.out.println("List cleared");
            }
        };

        // Итог
        long start = System.currentTimeMillis();
        maxFromList.start();
        sortedList.start();
        removedFirst.start();

        maxFromList.join();
        sortedList.join();
        removedFirst.join();

        long end = System.currentTimeMillis();

        System.out.println("Total time: " + (end - start) + " ms");
    }
}

/*
- когда все три части программы работают без потоков: Total time: 1587 ms
- с потоками в пределах от 947 до 1146ms
 */