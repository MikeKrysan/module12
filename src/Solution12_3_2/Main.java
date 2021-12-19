package Solution12_3_2;

import java.util.Scanner;

/*
Для монетизации своего приложения автор разработал класс Advertisement
(в тестирующей системе он скрыт). Естественно, реклама должна показываться в
отдельном потоке, чтобы пользователь имел возможность остановить ее.

Запустите статический метод show() класса Advertisement в новом потоке.
 */
public class Main {
    public static void main(String[] args) {
        AdThread adThread = new AdThread();
        adThread.start();
        //Scanner scanner = new Scanner(System.in);
    }
}

/*  Класс потока можно сделать таким
    (это отдельный класс и для запуска потока в точке входа в программу нужно
    создать его объект):

    class AdThread extends Thread{
    public void run(){
        Advertisement.show();
    }
}
*/

