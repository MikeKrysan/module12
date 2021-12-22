public class Solution12_4_CheckResults {
    private static int counter = 0;

    public static void main(String[] args) {
        new Thread() {
            public void run(){
                for (int i = 0; i < 100; i++) {
                    Solution12_4_CheckResults.counter++;
                }
            }
        }.start();
        while (Solution12_4_CheckResults.counter < 100) {
            System.out.println("Not reached yet");
        }
        System.out.println("Reached");
    }
}
