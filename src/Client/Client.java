package Client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8188);
            System.out.println("Успешно подключен");
            DataInputStream in = new DataInputStream(socket.getInputStream()); // Поток ввода
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // Поток вывода
            String response = in.readUTF(); // Читаем ответ от сервера
            System.out.println(response);
            Scanner scanner = new Scanner(System.in);
            while (true){
                /*byte[] array = new byte[7]; // length is bounded by 7
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));
                System.out.println("Message to server "+generatedString);*/
                String consoleText = scanner.nextLine(); // Ждём сообщение от пользователя
                out.writeUTF(consoleText); // Отправляем сообщение на сервер
                response = in.readUTF(); // Читаем ответ от сервера
                System.out.println("Ответ сервера: "+response); // Печатаем ответ от сервера на экран
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}