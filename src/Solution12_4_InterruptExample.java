public class Solution12_4_InterruptExample {
    public static void main(String[] args) throws InterruptedException { // 4
        Thread threadToInterrupt = new Thread(){
            public void run(){
                while (true) {
                    System.out.println("Working hard");
                    try {
                        Thread.sleep(1000); // 1
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted!");
                        break; // 2
                    }
                }
            }
        };

        threadToInterrupt.start();
        Thread.currentThread().sleep(2500); // 3
        threadToInterrupt.interrupt(); // 5
    }
}


/*
1.В потоке в бесконечном цикле мы каждый раз замораживаем поток на 1 секунду. Метод бросает InterruptedException, который мы можем отловить в методе run().

2. Когда мы обрабатываем исключение, просто выходим из цикла. Тогда метод run() дойдет до конца метода, и поток завершит работу.

3. Главный поток мы тоже блокируем, для наглядности на 2.5 секунды.

4. Обратите внимание: так как на строке 3 мы вызвали операцию sleep(), мы должны так же и в главном потоке обработать InterruptedException.
Но в этом нет необходимости, так как мы не собираемся писать логику прерывания главного потока из-за отсутствия необходимости его прерывать в нашем приложении.
Так как метод main() — наш созданный метод, мы можем прописать в его сигнатуре любые checked exceptions, что мы и сделали, прописав InterruptedException.

5. Метод для прерывания созданного пользовательского потока.
 */