public class Solution12_4_CheckResultsWithSleep {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {    //1.
        new Thread() {
            public void run(){
                for (int i = 0; i < 100; i++) {
                    Solution12_4_CheckResultsWithSleep.counter++;
                }
            }
        }.start();
        while (Solution12_4_CheckResultsWithSleep.counter < 100) {
            System.out.println("Not reached yet");
            Thread.sleep(1000); // 1 секунда - метод заставляет перейти поток в спящий режим на определенное в параметре время.
        }
        System.out.println("Reached");
    }
}

/*
1. checked исключение InterruptedException. Это исключение выбрасывается, если посылается команда прервать поток — таким образом мы можем остановить его работу
 */