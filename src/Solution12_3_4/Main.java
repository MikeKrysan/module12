package Solution12_3_4;


/*
Дело монетизации пошло отлично и автор решил создать целую иерархию классов рекламы. Теперь класс Advertisement реализует интерфейс Runnable (в тестирующей системе он скрыт).

Запустите поток на базе класса Advertisement.
 */
public class Main {
    // Lunch thread on class Advertisement,
    // which implements Runnable
    // (it's hidden)
    public static void main(String[] args) {
        new AdThread(new Advertisement()).start();
    }
}

/*
Подсказка (1 из 1): Создайте подкласс класса Thread и передайте ему в конструктор объект класса Advertisement.
 */
