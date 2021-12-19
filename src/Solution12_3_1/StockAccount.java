package Solution12_3_1;

public class StockAccount extends Thread{
    int money = 1000;
    @Override
    public void run() {
        while(true) {
            money++;
        }
    }
}
