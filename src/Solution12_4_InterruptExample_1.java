public class Solution12_4_InterruptExample_1 {
    public static void main(String[] args) throws InterruptedException { // 4
        Thread threadToInterrupt = new Thread(){
            public void run(){
                while (!isInterrupted()) {              //A
                    System.out.println("Working hard");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //Перехватываем молча
                }
                System.out.println("All done");
            }
        };

        threadToInterrupt.start();
        Thread.currentThread().sleep(2500); // 3
        threadToInterrupt.interrupt();
        threadToInterrupt.join();                       //B
        System.out.println("Thread finished");
    }
}

/*
A - В этом варианте поток в цикле сам проверяет свою прерванность методом isInterrupted() и, если метод возвращает true, завершает цикл, то есть корректно заканчивает программу.

B - Перед выводом “Thread finished” мы в этой программе делаем join() для того, чтобы дождаться реального окончания работы потока. Оно произойдет быстро, но не мгновенно.
 */