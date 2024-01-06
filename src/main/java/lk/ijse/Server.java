package lk.ijse;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3002);
            System.out.println("Server is started");
            Socket localSocket = serverSocket.accept();
            System.out.println("Server is accept");
            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Client = " + message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}