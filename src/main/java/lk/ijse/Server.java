package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(3002);
            System.out.println("Server is started");
            Socket localSocket = serverSocket.accept();
            System.out.println("Server is accept");
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Client = " + message);

            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
            dataOutputStream.writeUTF("I'm server how can i help you");

            while (true){
                System.out.println(dataInputStream.readUTF());
                String msg = scanner.nextLine();
                dataOutputStream.writeUTF(msg);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}