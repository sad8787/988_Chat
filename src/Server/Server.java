package Server;
import User.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        {
            List<User> users=new ArrayList<User>();
            try {
                ServerSocket serverSocket = new ServerSocket(8188); // Создаём серверный сокет
                System.out.println("Сервер запущен");
                while (true){ // Бесконечный цикл для ожидания родключения клиентов
                    Thread clientThread=new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                Socket socket = serverSocket.accept(); // Ожидаем подключения клиента
                                System.out.println("Клиент подключился");
                                User currentuser=new User(socket);
                                DataInputStream in = new DataInputStream(currentuser.getSoket().getInputStream()); // Поток ввода
                                DataOutputStream out = new DataOutputStream(currentuser.getSoket().getOutputStream()); // Поток вывода
                                out.writeUTF("Name ?");
                                String request = in.readUTF();
                                out.writeUTF("Добро пожаловать на сервер "+request);
                                currentuser.setName(request);
                                users.add(currentuser) ;
                                while (true){
                                     request = in.readUTF(); // Ждём сообщение от пользователя
                                    for(user:users){

                                    }
                                    out.writeUTF(request.toUpperCase()); // Отправляем сообщение пользователю
                                }
                            }catch (Exception e){}
                        }
                    });
                    clientThread.start();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}