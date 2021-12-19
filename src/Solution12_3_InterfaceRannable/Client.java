package Solution12_3_InterfaceRannable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
    Socket socket;

    public Client(Socket socket){

        this.socket = socket;
    }

    public void run() {
        try {
            // получаем потоки ввода и вывода
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            Scanner in = new Scanner(is);
            PrintStream out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("Welcome to mountains!");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                out.println(input + "-" + input + "-" +
                        input.substring(input.length() / 2) + "...");
                input = in.nextLine();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Обратите внимание: метод run() не может выбрасывать исключение IOException,
потому что в интерфейсе он объявлен как безопасный. Поэтому нам надо
перехватывать это исключение при помощи try-catch.
 */