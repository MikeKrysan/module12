public class Solution12_4_3 extends Thread {
    @Override
    public void run() {
//        try {
//            System.out.println("Thread started");
//        } catch (InterruptedException exception) {  //не скомпелируется
//            System.out.println("Thread interrupted");
//        }
//    }
//В данном случае не нужен отработчик try/catch, так как никогда не будет catch и поэтому  нужно убрать:
        System.out.println("Thread started");
    }

    public static void main(String[] args) {
        Thread thread = new Solution12_4_3();
        thread.start();
        thread.interrupt();
    }
}

 /*
Компилятор: is never thrown in body of corresponding try statement
  */