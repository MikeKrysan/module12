public class Solution12_4_1 {
    Thread t1 = new Thread() {
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.currentThread().start(); // 1
        }
    };
   // t1.start(); // 2
   // t1.join();
}

/*
1 - Итак, Thread.currentThread () - это способ получить экземпляр Thread, отвечающий за поток выполнения, внутри которого вызывается метод.
2- в строке
 */