package Solution12_3_3_MiniServer;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ArrayList<Client1> clients = new ArrayList<>();  //1.3
    ServerSocket serverSocket;

    ChatServer() throws IOException {
        // создаем серверный сокет на порту 1234
        serverSocket = new  ServerSocket(1234);
    }

    void sendAll(String message) {  //сервер передает соообщение всем клиентам
        for(Client1 client : clients) {
            client.receive(message);
        }
    }

    public void run() {
        while (true) {  //цикл, фактически наш менеджер:
            System.out.println("Waiting...");
            try {
                // ждем клиента из сети
                Socket socket = serverSocket.accept();  // принимается клиент
                System.out.println("Client connected!");

                //создаем клиента на своей стороне
                clients.add(new Client1(socket, this));    //Клиент добавляется и запускается(отрабатывается код в классе Client)
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
       new ChatServer().run();  //1.1 - запускаем чат-сервер на выполнение

    }
}


/*
1.1 Создаем в методе main настоящий объект ChatServer сервера;
1.2 Переносим часть функционала в клиента;
1.3 Главное: создаем ArrayList, в котором хранятся клиенты. Он нужен для того, чтобы
клиенты обменивались информацией между собой
 */