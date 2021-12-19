package Solution12_3_1;

public class TestStart extends Thread {
    int i;

    public TestStart(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}


class Main1 {
    //What does this code output?
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new TestStart(i).start();
        }
    }
}