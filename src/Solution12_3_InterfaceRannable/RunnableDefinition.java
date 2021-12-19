package Solution12_3_InterfaceRannable;
/*
Другой способ запустить поток в своей программе  — использовать интерфейс Runnable:

public interface Runnable {
   public abstract void run();
}
Благодаря ему можно любой класс, уже пронаследованный от другого класса (не от Thread), сделать потоком.

Для запуска потока при помощи Runnable нужно:

Реализовать интерфейс в каком-нибудь классе.
Создать экземпляр этого  класса.
Создать экземпляр класса Thread, передав ему в конструкторе созданный экземпляр (то есть создать объект класса поток).
Запустить поток вызовом метода start().
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class RunnableDefinition {
    public static void main(String[] args) throws IOException {
        // создаем серверный сокет на порту 1234
        ServerSocket server = new ServerSocket(1234);   //1.
        while(true) {
            System.out.println("Waiting...");

            // ждем клиента из сети
            Socket socket = server.accept(); //2.accept() - Listens for a connection to be made to this socket and accepts it. The method blocks until a connection is made
            System.out.println("Client connected!");

//            //создаем клиента на своей стороне
//            Client client = new Client(socket);
//            //запускаем поток
//            Thread thread = new Thread(client);
//            thread.start();

//            //Последние три строки можно написать в две:
//            Thread thread = new Thread(new Client(socket));
//            thread.start();

            //Или даже в одну:
            new Thread(new Client(socket)).start();
//            // получаем потоки ввода и вывода
//            InputStream is = socket.getInputStream();    //3.getInputStrem() - Returns an input stream for this socket.
//            OutputStream os = socket.getOutputStream();  //4. getOutputStream() - Returns an output stream for this socket.
//
//            // создаем удобные средства ввода и вывода
//            Scanner in = new Scanner(is);
//            PrintStream out = new PrintStream(os);
//
//            // читаем из сети и пишем в сеть
//            out.println("Welcom to mountains!");
//            String input = in.nextLine();
//            while(!input.equals("bye")) {
//                out.println(input + "-" + input + "-" +
//                        input.substring(input.length()/2) + "...");
//                input = in.nextLine();
//            }
//            socket.close();
        }
    }

}

/*
1.Наверное, единственное, что нужно пояснить, это константа 1234. На одной машине может быть запущено много серверов. Чтобы входящие данные не путались, у каждого сервера есть порт — номер.
2. Прослушивает подключение к этому сокету и принимает его. Метод блокируется до тех пор, пока не будет установлено соединение
3. Возвращает входной поток для этого сокета. Переопределенный метод класса InputStream классом Socket
4. Возвращает выходной поток для этого сокета. Переопределенный метод класса InputStream классом Socket
 */