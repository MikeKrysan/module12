package Solution12_4_4;
/*
Напишите консольные часы. Разработайте класс ConsoleClock — подкласс класса Thread, который каждую секунду будет выдавать время (локальное, часовые пояса учитывать не нужно)
 в формате ЧЧ:MM:CC.

Предусмотрите остановку часов при помощи interrupt(). После прерывания программа должна вывести на консоль сообщение "The clock was stopped".

Например, программа:

ConsoleClock cc = new ConsoleClock();
cc.start();
Thread.sleep(3000);
cc.interrupt();
Должна в течение примерно трех секунд выдать следующее:

08:09:43
08:09:44
08:09:45
The clock was stopped
И закончить работу.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException{

        ConsoleClock cc = new ConsoleClock();
        cc.start();
        Thread.sleep(3000);
        cc.interrupt();
    }
}
