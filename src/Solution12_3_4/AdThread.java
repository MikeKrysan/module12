package Solution12_3_4;

public class AdThread extends Thread{
    public AdThread(Advertisement advertisement) {

    }

    public void run() {
        Advertisement.show();
    }
}
