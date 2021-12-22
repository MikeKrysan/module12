package Solution12_4_ChickenEgg;

public class Main {
    public static void main(String[] args) {
        // �������� ������� � �������
        ChickenEgg chicken = new ChickenEgg("������");
        ChickenEgg egg = new ChickenEgg("����");
        System.out.println("�������� ����: ��� �������� ������?");
        // ������ �������
        chicken.start();
        egg.start();
        // ���� ��� ������ ��������
        while (chicken.isAlive() || egg.isAlive()) {
            try {
                // ���������������� ����� "�i����"
                Thread.sleep(100);
                System.out.println("������");
            } catch (InterruptedException e) {
            }
        }
        // C������ �� ���� ��������� �����?
        if (egg.isAlive()) {
            try {
                // ��������� ����
                egg.interrupt();
                // ����, ���� ���� �������� �������������
                egg.join();
            } catch (InterruptedException e) {
            }

            System.out.println("������ ��������� ����!");
        } else {
            try {
                // ��������� ������
                //chicken.interrupt();
                // ����, ���� ������ �������� �������������
                chicken.join();
            } catch (InterruptedException e) {
            }
            System.out.println("������ ��������� ������!");
        }
        System.out.println("���� ��������");
    }
}
