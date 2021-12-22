public class Solution12_4_JoinExample {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread() {
            public void run(){
                for (int i = 0; i < 50000000; i++) {
                    Solution12_4_JoinExample.counter++;
                }
            }
        }.start();

        System.out.println("Counter value: " + counter); // Counter value: 0
    }
}

/*
В консоли результатом будет:
Counter value: 0
Здесь один поток в цикле увеличивает счетчик на 1, а второй распечатывает его значение в консоль. Программа работает не так, как задумывалось: наиболее вероятный результат в консоли — 0.
 */