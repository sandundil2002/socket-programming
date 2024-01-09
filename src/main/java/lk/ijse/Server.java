package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
            System.out.println("Server is connected");

            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client: " + clientMessage);

            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
            dataOutputStream.writeUTF("I'm server. How can I help you?");

            while (true) {
                String receivedMessage = dataInputStream.readUTF();
                if (receivedMessage.equals("end")) {
                    break;
                }

                System.out.println("Client: " + receivedMessage);
                String serverMessage = scanner.nextLine();
                dataOutputStream.writeUTF(serverMessage);

                if (serverMessage.equals("end")) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
