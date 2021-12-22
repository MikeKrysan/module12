public class Solution12_4_JoinExampleWithJoin {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                for (int i = 0; i < 1000000000; i++) {
                    Solution12_4_JoinExampleWithJoin.counter++;
                }
            }
        };
        thread.start();
        thread.join(); // main() поток блокируется и ждет, пока не завершится поток thread
        System.out.println("Counter value: " + counter); // Counter value: 1000000000
    }
}


/*
Теперь мы дожидаемся пока не завершит работу второй поток, и только затем main() продолжает работу. Вывод этой программы всегда одинаковый  — миллиард.
 */