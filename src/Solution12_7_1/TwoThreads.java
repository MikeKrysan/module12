package Solution12_7_1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/*
В одном потоке в бесконечном цикле добавлять случайные элементы в очередь в диапазоне 0–100 ( вместимость очереди — 10).
Во втором потоке каждые 100 мс генерировать случайные целые числа в диапазоне 0–10. При получении во втором потоке числа 5, удалить из очереди первый элемент.
 */
public class TwoThreads {

    private static ArrayBlockingQueue queue = new ArrayBlockingQueue <>(10);

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Random random = new Random();
                    while (true) {
                        queue.put(random.nextInt(100));
                    }
                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Random random = new Random();
                    int rand = 0;
                    while(true) {
                        Thread.sleep(100);
                        rand = random.nextInt(10);
                        if(rand ==5) {
                            System.out.println("First threat: " + queue.take());
                            System.out.println("Second threat: " + rand);
                            System.out.println("Queue size: " + queue.size() + "\n");
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
